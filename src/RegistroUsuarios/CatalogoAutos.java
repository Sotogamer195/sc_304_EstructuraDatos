package RegistroUsuarios;

public class CatalogoAutos {

    private NodoAuto head;

    public void agregarAuto(String marca, String modelo, int anio) {
        Auto nuevoAuto = new Auto(marca, modelo, anio);
        head = agregarAutoRecursivo(head, null, nuevoAuto);
    }

    private NodoAuto agregarAutoRecursivo(NodoAuto current, NodoAuto prev, Auto nuevoAuto) {
        if (current == null) {
            NodoAuto nuevoNodo = new NodoAuto(nuevoAuto);
            nuevoNodo.setPrev(prev);
            if (prev != null) {
                prev.setNext(nuevoNodo);
            } else {
                head = nuevoNodo;
            }
            System.out.println("Auto agregado correctamente: " + nuevoAuto.getMarca() + " " + nuevoAuto.getModelo());
            return nuevoNodo;
        } else if (current.getAuto().getMarca().equals(nuevoAuto.getMarca()) && 
                current.getAuto().getModelo().equals(nuevoAuto.getModelo()) && 
                current.getAuto().getAnio() == nuevoAuto.getAnio()) {
            System.out.println(" El auto ya existe en el catalogo.");
            return current;
        } else {
            current.setNext(agregarAutoRecursivo(current.getNext(), current, nuevoAuto));
            return current;
        }
    }

    public void editarAuto(String marca, String modelo, int anio, String nuevaMarca, String nuevoModelo, int nuevoanio) {
        editarAutoRecursivo(head, marca, modelo, anio, nuevaMarca, nuevoModelo, nuevoanio);
    }

    private void editarAutoRecursivo(NodoAuto current, String marca, String modelo, int anio, String nuevaMarca, String nuevoModelo, int nuevoanio) {
        if (current == null) {
            System.out.println("Error: El auto a editar no existe.");
            return;
        } else if (current.getAuto().getMarca().equals(marca) && current.getAuto().getModelo().equals(modelo) && current.getAuto().getAnio() == anio) {
            current.getAuto().setMarca(nuevaMarca);
            current.getAuto().setModelo(nuevoModelo);
            current.getAuto().setAnio(nuevoanio);
            System.out.println("Auto editado: " + nuevaMarca + " " + nuevoModelo);
        } else {
            editarAutoRecursivo(current.getNext(), marca, modelo, anio, nuevaMarca, nuevoModelo, nuevoanio);
        }
    }

    public void inactivarAuto(String marca, String modelo, int anio) {
        inactivarAutoRecursivo(head, marca, modelo, anio);
    }

    private void inactivarAutoRecursivo(NodoAuto current, String marca, String modelo, int anio) {
        if (current == null) {
            System.out.println(" El auto a inactivar no existe.");
            return;
        } else if (current.getAuto().getMarca().equals(marca) && current.getAuto().getModelo().equals(modelo) && current.getAuto().getAnio() == anio) {
            if (current.getAuto().getUsuariosAsignados() > 0) {
                System.out.println("No se puede inactivar el auto porque tiene usuarios asignados.");
            } else if (!current.getAuto().isActivo()) {
                System.out.println(" El auto ya estÃ¡ inactivo.");
            } else {
                current.getAuto().setActivo(false);
                System.out.println("Auto inactivado: " + marca + " " + modelo);
            }
        } else {
            inactivarAutoRecursivo(current.getNext(), marca, modelo, anio);
        }
    }

    public void asignarUsuario(String marca, String modelo, int anio) {
        asignarUsuarioRecursivo(head, marca, modelo, anio);
    }

    private void asignarUsuarioRecursivo(NodoAuto current, String marca, String modelo, int anio) {
        if (current == null) {
            System.out.println(" El auto no existe.");
        } else if (current.getAuto().getMarca().equals(marca) && current.getAuto().getModelo().equals(
                modelo) && current.getAuto().getAnio() == anio) {
            current.getAuto().setUsuariosAsignados(current.getAuto().getUsuariosAsignados() + 1);
            System.out.println("Usuario asignado al auto: " + marca + " " + modelo);
        } else {
            asignarUsuarioRecursivo(current.getNext(), marca, modelo, anio);
        }
    }

    public void imprimirCatalogo() {
        NodoAuto current = head;
        while (current != null) {
            System.out.println(current.getAuto());
            current = current.getNext();
        }
    }

    public NodoAuto getHead() {
        return head;
    }

    public void setHead(NodoAuto head) {
        this.head = head;
    }
}
