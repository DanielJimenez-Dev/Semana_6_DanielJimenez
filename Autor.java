/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecasylibros;

/**
 *
 * @author jimen
 */
public class Autor {
    // Atributos de la clase autor
    private String id;
    private String nombre;
    private String nacionalidad;
    
    // Constructor para inicializar un nuevo autor
    public Autor(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    // Metodos Getters
    // usamos los getter para que otra clase pueda leer los atributos

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    
    // creamos el metodo para mostrar la informacion del autor en consola
    public void mostrarInfo() {
        System.out.println(" [Autor ID: " + id + "]");
        System.out.println(" [Nombre: " + nombre + "]");
        System.out.println(" [Nacionalidad: " + nacionalidad + "]");
    }
}
