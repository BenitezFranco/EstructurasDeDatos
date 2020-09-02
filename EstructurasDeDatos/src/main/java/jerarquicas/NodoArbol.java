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
public class NodoArbol {
    private Object elem;
    private NodoArbol derecho;
    private NodoArbol izquierdo;
   
    
    public NodoArbol(Object elem){
        this.elem=elem;
        this.derecho=null;
        this.izquierdo=null;
    }
    public Object getElem(){
        return this.elem;
    }
    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }
    public NodoArbol getDerecho(){
        return this.derecho;
    }
    
    public void setElem(Object elem ){
        this.elem=elem;
    }
    public void setIzquierdo(NodoArbol izq){
        this.izquierdo=izq;
    }
    public void setDerecho(NodoArbol der){
        this.derecho=der;
    }
    
    
    
}
