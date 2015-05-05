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
public class ventanillas {
        private Cliente cliente;
        private String nombre;
        private boolean estado;
        
        public ventanillas(String nombre){
            cliente=null;
            this.nombre=nombre;
            estado=false;
        }
        
        public void setCliente(Cliente cliente){
            this.cliente=cliente;
            estado=true;
        }
        public Cliente getCliente(){
            return cliente;
        }
        
        public String getNombre(){
            return nombre;
        }
        
        public boolean getEstado(){
            return estado;
        }
        
        public void desocupar(){
            estado=false;
        }
        
        
    }
