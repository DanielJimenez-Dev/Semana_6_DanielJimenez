/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package sistemadegestiondeestock;

/**
 *
 * @author jimen
 */
public enum CategoriaProducto {
    
    // Definimos las constantes del enum con sus descripciones
    ALIMENTOS("Productos Comestibles"),
    ELECTRONICA("Dispositivos electronicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Articulos para el hogar");
    
    // Atributos privados para guardar la descripción
    private final String descripcion;
    
    // Constructores privados para inicializar la descripcion de cada constante
    CategoriaProducto(String descripcion){
        this.descripcion = descripcion;
    }
    
    // Método público para obtener la descripción
    public String getDescripcion(){
        return descripcion;
    }
}
