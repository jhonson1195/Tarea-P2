/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

/**
 *
 * @author jhonson
 */
public interface Estructura {
    
    public void Agregar(Cliente info);
    public Cliente Atender();
    public Cliente SiguienteClienteaTeneder();
    public String getTiquetes();
    public int [] CantidadClientePortipos();
    
    
}
