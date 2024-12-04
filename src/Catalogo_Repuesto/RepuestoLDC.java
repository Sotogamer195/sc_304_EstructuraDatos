package Catalogo_Repuesto;

import javax.swing.JOptionPane;

public class RepuestoLDC {

    // Esta clase se usará para manejar todos los repuestos con lista doble circular
    private NodoDC inicioDC;
    private NodoDC finDC;

    public RepuestoLDC() {
        this.inicioDC = null;
        this.finDC = null;
    }

    // Método para agregar a la lista doble circular
    public void agregarRespuesto(NodoDC aux, String nombreRepuesto, String codigo) {
        Repuesto r = new Repuesto();
        // Se ingresan los datos a la lista
        r.setNombreRepuesto(nombreRepuesto);
        r.setCodigo(codigo);

        // Se llama al método para saber si los datos ya fueron anteriormente ingresados al sistema
        if (existeRepuesto(r.getNombreRepuesto(), r.getCodigo())) {
            JOptionPane.showMessageDialog(null, "Error, el repuesto ya existe en el sistema");
            // Se usa el return para que deje de ejecutar el método
            return;
        }

        // De lo contrario se ejecuta el método para agregar
        NodoDC nuevo = new NodoDC();
        nuevo.setElemento(r);
        if (esVaciaDC()) {
            inicioDC = nuevo;
            finDC = nuevo;
            // Se hacen los enlaces
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        } else if (r.getCodigo().compareTo(inicioDC.getElemento().getNombreRepuesto()) < 0) {
            nuevo.setSiguiente(inicioDC); // Donde colocar nuevo y enlazar a inicio
            inicioDC.setAnterior(nuevo);
            inicioDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        } else if (r.getCodigo().compareTo(inicioDC.getElemento().getCodigo()) >= 0) {
            // Ingresar al final
            finDC.setSiguiente(nuevo);
            nuevo.setAnterior(finDC);
            finDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        } else {
            // Se ingresa al medio
            while (aux.getSiguiente().getElemento().getCodigo().compareTo(r.getCodigo()) < 0) {
                aux = aux.getSiguiente();
            }
            // Se enlazan los elementos
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            // Se ajusta el siguiente nodo del auxiliar
            aux.getSiguiente().setAnterior(nuevo);
            aux.setSiguiente(nuevo);
        }
    }

    // Método para saber si el repuesto está registrado en el programa
    public boolean existeRepuesto(String nombreRepuesto, String codigo) {
        boolean esta = false;
        // Busca en la lista, y retorna true si un codigo tiene el codigo en la lista
        // Verifica si la lista no está vacía
        if (inicioDC != null) {
            NodoDC aux = inicioDC;
            do {
                // Verifica si el nombre o el id del nodo actual coincide con el buscado
                if (aux.getElemento().getNombreRepuesto().equalsIgnoreCase(nombreRepuesto)
                        && aux.getElemento().getCodigo().equalsIgnoreCase(codigo)) {
                    esta = true;
                    break; // Sale del bucle si lo encuentra
                }
                aux = aux.getSiguiente(); // Avanza al siguiente nodo
            } while (aux != inicioDC);
        }
        return esta;
    }

    // Método para llamar a agregarRespuesta
    public void confirmarAgregarRepuesto() {
        NodoDC aux = inicioDC;
        String nombre = JOptionPane.showInputDialog(null,
                "Ingrese el nombre del repuesto que quiere para su auto");
        String codigo = JOptionPane.showInputDialog(null,
                "Ingrese el código del repuesto");
        agregarRespuesto(aux, nombre, codigo);
    }

    // Método para mostrar la lista doble circular
    public void mostrarLDC() {
        if (!esVaciaDC()) {
            String s = "";
            NodoDC aux = inicioDC;
            do {
                s += aux.getElemento().getNombreRepuesto() + "--"
                        + aux.getElemento().getCodigo() + "-->";
                aux = aux.getSiguiente();
            } while (aux != inicioDC);
            JOptionPane.showMessageDialog(null, "La Lista Doble Circular contiene:\n" + s);
            System.out.println("La Lista Doble Circular contiene:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar, ¡lista vacía!");
        }
    }

    //Método para editar el repuesto
    public void editarRepuestoRecursivo(NodoDC aux, String nombre, String codigo) {
        // El supuesto en el que la lista esté vacía devuelve un error
        if (esVaciaDC()) {
            JOptionPane.showMessageDialog(null, "Error, la lista está vacía");
            // Se usa el return para que deje de ejecutar el método recursivo
            return;
        }
        // Caso en el que se encuentra el dato con el codigo ingresado
        if (aux.getElemento().getCodigo().equals(codigo)) {
            aux.getElemento().setNombreRepuesto(nombre);
            aux.getElemento().setCodigo(codigo);
            JOptionPane.showMessageDialog(null,
                    "El repuesto ha sido modificado exitosamente");
            return;
        }
        // Si no se encuentra el repuesto, se avanza al siguiente
        if (aux.getSiguiente() != inicioDC) { // Mientras siguiente no sea inicio
            editarRepuestoRecursivo(aux, nombre, codigo);
        } else {
            JOptionPane.showMessageDialog(null, "El repuesto con ese codigo no existe!");
        }

    }

    public void confirmarEditarRepuesto() {
        NodoDC aux = inicioDC;
        String codigo = JOptionPane.showInputDialog(null, 
                "Ingrese el código del repuesto que desea cambiar");
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del repuesto");
        
        editarRepuestoRecursivo(aux, nombre, codigo);
    }

    // Método para extraer un elmemento de la lista doble circular 
    public Repuesto extraerRepuestoRecursivo(String id) {
        Repuesto r = null; // Inicializo la persona a retornar como null
        if (!esVaciaDC()) { // Si la lista no está vacía
            // Caso especial: Si la lista tiene un solo nodo
            if (inicioDC == finDC && inicioDC.getElemento().getCodigo().equals(id)) {
                r = inicioDC.getElemento(); // Guardo el dato a extraer
                JOptionPane.showMessageDialog(null, "El repuesto con código " + id + " fue extraído!");
                inicioDC = null;
                finDC = null;
            } else if (inicioDC.getElemento().getCodigo().equals(id)) {
                // Caso 1: Si el nodo a extraer es la cabeza
                r = inicioDC.getElemento(); // Guardo el dato de la cabeza
                JOptionPane.showMessageDialog(null, "El repuesto con código " + id + " fue extraído!");
                inicioDC = inicioDC.getSiguiente(); // Actualizo la cabeza
                inicioDC.setAnterior(finDC); // Ajusto la referencia previa de la nueva cabeza
                finDC.setSiguiente(inicioDC); // Enlazo el último nodo a la nueva cabeza
            } else {
                // Caso 2: El nodo a extraer está en otro lugar
                NodoDC aux = inicioDC; // Utilizo aux como índice
                do {
                    if (aux.getSiguiente().getElemento().getCodigo().equals(id)) {
                        NodoDC eliminar = aux.getSiguiente(); // Nodo a eliminar
                        r = eliminar.getElemento(); // Guardo el dato del nodo a extraer
                        JOptionPane.showMessageDialog(null,
                                "El repuesto con código " + id + " fue extraído!");
                        aux.setSiguiente(eliminar.getSiguiente()); // Ajusto la referencia del siguiente
                        eliminar.getSiguiente().setAnterior(aux); // Ajusto la referencia previa del siguiente
                        if (eliminar == finDC) {
                            finDC = aux;
                        }
                        break; // Salgo del bucle al encontrar y extraer el nodo
                    }
                    // Si no se encuentra el repuesto, se avanza al siguiente
                    if (aux.getSiguiente() != inicioDC) { // Mientras siguiente no sea inicio
                        extraerRepuestoRecursivo(id);
                    } else {
                        JOptionPane.showMessageDialog(null, "El repuesto con ese codigo no existe!");
                    }
                } while (aux != inicioDC);
            }
        }
        return r; // Retorna el dato extraído
    }

    //Método para llamar al método de extraer el repuesto para eliminarlo
    public void confirmarExtraerRepuesto() {
        String id = JOptionPane.showInputDialog(null, "Ingrese el código del repuesto a eliminar");
        extraerRepuestoRecursivo(id);
    }
    
    // Método para saber si la lista doble circular está vacía
    public boolean esVaciaDC() {
        if (inicioDC == null) {
            return true;
        } else {
            return false;
        }
    }
}
