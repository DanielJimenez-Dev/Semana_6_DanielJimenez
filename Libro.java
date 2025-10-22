/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecasylibros;

/**
 *
 * @author jimen
 */
public class Libro {
    // Atributos de libros
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor; // Relacion: un libre tiene un autor
    
    // Constructor para inicializar un nuevo libro
 
    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }
    
    // creamos los metodos Getter

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }
    
    // Creamos el metodo para mostrar la informacion completa del libro y el autor
    public void mostrarInfo() {
        System.out.println("*****************************************");
        System.out.println("Titulo: " + titulo);
        System.out.println("ISBN: " + isbn);
        System.out.println("Año de Publicacion: " + anioPublicacion);
        System.out.println("-------Informacion del Autor--------");
        
    // Delega la impresion de la informacion del autor al objeto Autor
        autor.mostrarInfo();
        System.out.println("******************************************");
    
    }
    
}
