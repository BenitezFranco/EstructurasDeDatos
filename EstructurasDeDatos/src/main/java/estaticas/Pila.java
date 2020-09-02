/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estaticas;

/**
 *
 * @author Mauricio
 */
public class Pila {
    private static final int TAM=10;
    private Object arr[];
    private int  tope=-1;
    
    public Pila(){
        this.arr= new Object [Pila.TAM];
    }
    public boolean apilar(Object elem){
        boolean res=false;
        if(this.tope+1!=Pila.TAM){
            this.tope=this.tope+1;
            this.arr[this.tope]=elem;
            res=true;
        }
        return res;
    }
    public boolean desapilar(){
        boolean res=false;
        if(this.tope!=-1){
            this.arr[this.tope]=null;
            this.tope=this.tope-1;
            res=true;
        }
        return res;
    }
    public Object obtenerTope(){
        return this.arr[this.tope];
    }
    public boolean esVacia(){
        return this.tope==-1;
        }
    public void vaciar (){
        while(this.tope!=-1){
            this.arr[this.tope]=null;
            this.tope=this.tope-1;
        }
    }
    public Pila clone(){
        int i=0;
        Pila clon= new Pila();
        while(i!=Pila.TAM){
            clon.arr[i]=this.arr[i];
            i++;
        }
        clon.tope=this.tope;
        return clon;
    }
    public String toString(){
        int i=0;
        String s= "[";
        while(i!=this.tope+1){
        s+=this.arr[i];
        i++;
        if (i!=this.tope)
            s+=",";
        }
        s+="]";
        return s;
    } 
    
    
}
