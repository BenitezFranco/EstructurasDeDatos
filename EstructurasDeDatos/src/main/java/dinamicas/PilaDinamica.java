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
public class PilaDinamica {
    private Nodo tope;
    public PilaDinamica(){
        this.tope=null;
    }
    public boolean apilar(Object elem){
        Nodo nuevo= new Nodo(elem);
        nuevo.setEnlace(this.tope);
        this.tope=nuevo;
        return true;
    }
    public boolean desapilar(){
        boolean res=false;
        if(this.tope!=null){
        this.tope=this.tope.getEnlace();
        res=true;
        }
        return res;
    }
    public Object obtenerTope(){
        return this.tope.getElem();
    }
    public boolean esVacia(){
        return this.tope==null;
    }
    public void vaciar(){
        this.tope=null;
    }
    public PilaDinamica clone(){
        PilaDinamica clon = new PilaDinamica();
        if(this.tope!=null){
        Nodo aux=this.tope;
        clonar(aux,clon);
        }
        return clon;
    }
    public void clonar(Nodo aux, PilaDinamica clon){
        if(this.tope!=null){
            Nodo nuevo= new Nodo (aux.getElem());
            clonar (nuevo,clon);
            nuevo.setEnlace(clon.tope);
            clon.tope=nuevo;
        }
    }
    public String toString(){
        Nodo aux=this.tope;
        String s= "[";
        s+=vuelta(aux);
        s+=aux.getElem();
        s+="]";
        return s;
    }
    public String vuelta(Nodo aux){
        String s= "";
        if(aux!=null){
            s+=vuelta(aux.getEnlace());
            s+=",";
        }
        return s;
    }
}
