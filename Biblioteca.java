/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecasylibros;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jimen
 */

// Creamos la clase principal que contiene y gestiona los libros
public class Biblioteca {
    
    private String nombre;
    // Atributo: almacena objetos libros
    private List<Libro> libros;
    
    // Constructor para inicializar la biblioteca con su nombre y la lista vacia
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        // Inicializamos la lista cumpliendo con el principio de composicion.
       this.libros = new ArrayList<>();
        System.out.println("Biblioteca " + nombre + "Creada Exitosamente.");
    }
    
    // Creamos los metodos solicitados en el ejercicio
    
    // 1. Agregamos un nuevo libro a la lista
    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        // Creamos una nueva instancia de libro
        Libro nuevoLibro = new Libro(isbn, titulo, anioPublicacion, autor);
        // Agregamos nuevos objeto aLibro a la lista
        libros.add(nuevoLibro);
        System.out.println("Libro agregado: " + titulo + ".");
    }
    
    // 2. Listar todos los libros en la biblioteca
    public void listarLibros() {
        System.out.println("\n--- LISTADO DE LIBROS en " + nombre + " ---");
        if (libros.isEmpty()) {
            System.out.println("La biblioteca no tiene libros disponibles.");
            return;
        }
        for (Libro l : libros) {
            l.mostrarInfo(); // Llama al método del Libro para mostrar su info completa
        }
    }

    // 3. Buscar un libro por su ISBN
    public Libro buscarLibroPorIsbn(String isbn) {
        // Recorre la lista de libros
        for (Libro l : libros) {
            // Compara el ISBN del libro con el ISBN buscado
            if (l.getIsbn().equals(isbn)) {
                return l; // Devuelve el objeto Libro si lo encuentra
            }
        }
        return null; // Devuelve null si no se encuentra
    }

    // 4. Eliminar un libro por su ISBN
    public boolean eliminarLibro(String isbn) {
        Libro libroAEliminar = buscarLibroPorIsbn(isbn); // Primero, buscamos el libro
        if (libroAEliminar != null) {
            libros.remove(libroAEliminar); // Si lo encontramos, lo eliminamos de la lista
            System.out.println("🗑️ Libro eliminado con ISBN: " + isbn);
            return true;
        }
        System.out.println("Error: Libro con ISBN " + isbn + " no encontrado para eliminar.");
        return false;
    }

    // 5. Obtener la cantidad total de libros
    public int obtenerCantidadLibros() {
        // El método size() devuelve la cantidad de elementos en la lista
        return libros.size();
    }

    // 6. Filtrar y mostrar los libros publicados en un año específico
    public List<Libro> filtrarLibrosPorAnio(int anio) {
        List<Libro> filtrados = new ArrayList<>();
        System.out.println("\n--- LIBROS PUBLICADOS en " + anio + " ---");
        for (Libro l : libros) {
            // Compara el año de publicación
            if (l.getAnioPublicacion() == anio) {
                filtrados.add(l);
                l.mostrarInfo();
            }
        }
        if (filtrados.isEmpty()) {
             System.out.println("No se encontraron libros publicados en el año " + anio + ".");
        }
        return filtrados;
    }

    // 7. Listar todos los autores únicos de los libros disponibles
    public void mostrarAutoresDisponibles() {
        // Usamos un HashSet para almacenar los autores y evitar duplicados
        Set<String> autoresUnicos = new HashSet<>();
        System.out.println("\n--- AUTORES DE LIBROS DISPONIBLES ---");

        for (Libro l : libros) {
            // Agregamos el nombre del autor a nuestro Set. El Set garantiza la unicidad.
            autoresUnicos.add(l.getAutor().getNombre() + " (" + l.getAutor().getNacionalidad() + ")");
        }

        if (autoresUnicos.isEmpty()) {
            System.out.println("No hay autores registrados.");
            return;
        }
        
        int contador = 1;
        for (String autor : autoresUnicos) {
            System.out.println(contador++ + ". " + autor);
        }
    }
}
