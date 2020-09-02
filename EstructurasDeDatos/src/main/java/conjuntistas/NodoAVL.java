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
public class NodoAVL {
    private Comparable elem;
    private int altura;
    private NodoAVL derecho;
    private NodoAVL izquierdo;
   
    
    public NodoAVL(Comparable elem){
        this.elem=elem;
        this.derecho=null;
        this.izquierdo=null;
        this.altura=1;
    }
    public Comparable getElem(){
        return this.elem;
    }
    public NodoAVL getIzquierdo(){
        return this.izquierdo;
    }
    public NodoAVL getDerecho(){
        return this.derecho;
    }
    public int getAltura(){
        return this.altura;
    }
    
    public void setElem(Comparable elem ){
        this.elem=elem;
    }
    public void setIzquierdo(NodoAVL izq){
        this.izquierdo=izq;
    }
    public void setDerecho(NodoAVL der){
        this.derecho=der;
    }
    public void recalcularAltura(){
        if(this.izquierdo!= null){
            int izq= this.izquierdo.getAltura();
            if(this.derecho!=null){
              int der= this.derecho.getAltura();
                if(izq<der)
                    this.altura=der+1;
                else
                    this.altura=izq+1;   
            }else{
                this.altura=izq+1;
            }
        }else{
            if(this.derecho!=null)
                this.altura=this.derecho.getAltura()+1;
            else
                this.altura=1;
        }
        
    }
    
}
