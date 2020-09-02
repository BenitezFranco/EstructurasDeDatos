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
public class ColaDinamica {
    private Nodo frente;
    private Nodo fin;
    public ColaDinamica(){
        this.fin=null;
        this.frente=null;
        }
    public ColaDinamica(Nodo nuevo){
        this.fin=nuevo;
        this.frente=nuevo;
    }
    public boolean poner(Object elem){
        Nodo nuevo =new Nodo(elem);
        if(this.frente==null){
            this.frente=nuevo;
            this.fin=nuevo;
        }else{
            this.fin.setEnlace(nuevo);
            this.fin=nuevo;
        }
        return true;
    }
    public boolean sacar(){
        boolean res=false;
        if(this.frente!=null){
            this.frente=this.frente.getEnlace();
            if(this.frente==null){
                this.fin=null;
            }
            res=true;
        }
        return res;
    }
    public Object obtenerFrente(){
        Object res=null;
        if(this.frente!=null){
        res=this.frente.getElem();
        }
        return res;
    }
    public boolean esVacia(){
        return this.frente==null;
    }
    public void vaciar(){
        this.frente=null;
        this.fin=null;
    }
    public ColaDinamica clone(){
        ColaDinamica clon =new ColaDinamica();
        if(this.frente!=null){
            Nodo aux=this.frente;
            Nodo copia=new Nodo(aux.getElem());
            clon.frente=copia;
            clon.fin=copia;
            aux= aux.getEnlace();
            while(aux!=null){
                Nodo nuevo = new Nodo(aux.getElem());
                clon.fin.setEnlace(nuevo);
                clon.fin=nuevo;
                aux=aux.getEnlace();
            }
        }
        return clon;
    }
    public String toString(){
        Nodo aux =this.frente;
        String s="[";
        while(aux!=null){
            s+=aux.getElem();
            aux=aux.getEnlace();
            if(aux!=null)
                s+=",";
        }
        s+="]";
        return s;
        }
}
