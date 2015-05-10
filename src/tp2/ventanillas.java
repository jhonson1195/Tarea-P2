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
        private int ClientesAtendidos;
        MedirTiempo tiempo;
        
        public ventanillas(String nombre){
            cliente=null;
            this.nombre=nombre;
            estado=false;
            ClientesAtendidos=0;
            tiempo=new MedirTiempo();
        }
        
        public void setCliente(Cliente cliente){
            this.cliente=cliente;
            estado=true;
            ClientesAtendidos++;
            tiempo.start();
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
        
        public long desocupar(){
            estado=false;
            tiempo.stop();
            return tiempo.getElapsedTimeSecs();
        }
        public int getClientesAtendidos(){
            return ClientesAtendidos;
        }
        
    }
