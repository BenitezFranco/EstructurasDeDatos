/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author Mauricio
 */
public class Nodo {
        private String elem;
        private Nodo enlace;
        
        public Nodo(String elem){
            this.elem=elem;
            this.enlace=null;
        }
        
        public String getElem(){
            return this.elem;
        }
        public Nodo getNodo(){
            return this.enlace;
        }
        public void setElem(String otro){
            this.elem=otro;
        }
        public void setEnlace(Nodo otro){
            this.enlace=otro;
        }
}
