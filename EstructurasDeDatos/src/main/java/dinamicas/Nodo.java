/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinamicas;

/**
 *
 * @author Mauricio
 */
public class Nodo {
    private Object elem;
    private Nodo enlace;
    public Nodo(){
        this.elem = null;
        this.enlace=null;
    }
    public Nodo(Object obj){
        this.elem=obj;
        this.enlace=null;    
    }
    public Object getElem(){
        return this.elem;
    }
    public Nodo getEnlace(){
        return this.enlace;
    }
    public void setElem(Object obj){
        this.elem=obj;
    }
    public void setEnlace(Nodo nuevo){
        this.enlace=nuevo;
    }
}
