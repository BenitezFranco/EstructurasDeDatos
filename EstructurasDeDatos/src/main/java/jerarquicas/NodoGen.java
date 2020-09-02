/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author Mauricio
 */
public class NodoGen {
    
        private NodoGen hijo;
        private NodoGen hermano;
        private Object elem;
        
        public NodoGen(Object n){
            elem=n;
            hijo= null;
            hermano= null;
        }
        public NodoGen getHijo(){
            return hijo;
        }
        public NodoGen getHermano(){
            return hermano;
        }
        public Object getElem(){
            return elem;
        }
        public void setHijo(NodoGen n){
            hijo=n;
        }
        public void setHermano(NodoGen n){
            hermano= n;
        }
        public void setElem(Object n){
            elem=n;
        }
    
}
