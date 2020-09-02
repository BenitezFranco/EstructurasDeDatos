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
public class NodoBB {
    private Comparable elem;
    private NodoBB derecho;
    private NodoBB izquierdo;
   
    
    public NodoBB(Comparable elem){
        this.elem=elem;
        this.derecho=null;
        this.izquierdo=null;
    }
    public Comparable getElem(){
        return this.elem;
    }
    public NodoBB getIzquierdo(){
        return this.izquierdo;
    }
    public NodoBB getDerecho(){
        return this.derecho;
    }
    
    public void setElem(Comparable elem ){
        this.elem=elem;
    }
    public void setIzquierdo(NodoBB izq){
        this.izquierdo=izq;
    }
    public void setDerecho(NodoBB der){
        this.derecho=der;
    }
    
       
}
