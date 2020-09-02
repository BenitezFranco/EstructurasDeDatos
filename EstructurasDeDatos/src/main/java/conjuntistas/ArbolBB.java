/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

import dinamicas.Lista;


/**
 *
 * @author Mauricio
 */
public class ArbolBB {
    private NodoBB raiz;
    
    public ArbolBB(){
        this.raiz=null;
    }
    
    public boolean insertar(Comparable elem){
        boolean res= true;
        if(this.raiz==null){
            this.raiz=new NodoBB(elem);
        }else{
            res= insertarAux(this.raiz,elem);
        }
        
        return res;
    }
    
    private boolean insertarAux(NodoBB nodo, Comparable elem){
        boolean res=true;
        if(elem.compareTo(nodo.getElem())==0){
            res=false;
        }else{
            if(elem.compareTo(nodo.getElem())<0){
                if(nodo.getIzquierdo()!=null)
                    res=insertarAux(nodo.getIzquierdo(),elem);
                else 
                    nodo.setIzquierdo(new NodoBB(elem));
            }else{
                if(nodo.getDerecho()!=null)
                    res=insertarAux(nodo.getDerecho(),elem);
                    
                else
                    nodo.setDerecho(new NodoBB(elem));
            }
        
        }
        return res;
    }
    
    public boolean pertenece (Comparable elem){
        boolean res=false;
            if(this.raiz!=null){
                res=perteneceAux(this.raiz, elem);
            }
         return res;
    }
    
    public boolean perteneceAux(NodoBB nodo, Comparable elem){
        boolean res=false;
            if(elem.compareTo(nodo.getElem())==0){
                res=true;
            }else{
                if(elem.compareTo(nodo.getElem())<0){
                    if(nodo.getIzquierdo()!=null)
                        res=perteneceAux(nodo.getIzquierdo(),elem);
                }else{
                    if(nodo.getDerecho()!=null)
                        res=perteneceAux(nodo.getDerecho(),elem);
                }
            }          
            
        return res;    
    }
    
    public boolean eliminar(Comparable elem){
        boolean res=false;
        if(this.raiz!=null){
            if(elem.compareTo(this.raiz.getElem())==0){
                if(this.raiz.getDerecho()!=null || this.raiz.getIzquierdo()!=null){
                    eliminarAux(this.raiz);
                    res=true;
                }else{
                    this.raiz=null;
                    res=true;
                }
            }else{
                NodoBB aux= buscarNodoPadre(this.raiz, elem);
                if(aux!=null){
                    if(aux.getDerecho().getElem().compareTo(elem)==0){
                        NodoBB hijo=aux.getDerecho();
                        if(hijo.getDerecho()!=null||hijo.getIzquierdo()!=null){
                            eliminarAux(hijo);
                            res=true;
                        }else
                            aux.setDerecho(null);
                    }else{
                        NodoBB hijo=aux.getIzquierdo();
                        if(hijo.getDerecho()!=null||hijo.getIzquierdo()!=null){
                            eliminarAux(hijo);
                            res=true;
                        }else
                            aux.setIzquierdo(null);
                    }
                }            
            }        
        }
        return res;
    }
    
    private void eliminarAux(NodoBB n){
        if(n.getIzquierdo()!=null){
            NodoBB aux=n.getIzquierdo();
            if(aux.getDerecho()!=null){
                while(aux.getDerecho().getDerecho()!=null)
                    aux=aux.getDerecho();
                n.setElem(aux.getDerecho().getElem());
                aux.setDerecho(null);
            }else{
                n.setElem(aux.getElem());
                n.setIzquierdo(aux.getIzquierdo());
            }
        }else{
            NodoBB aux=n.getDerecho();
            if(aux.getIzquierdo()!=null){
                while(aux.getIzquierdo().getIzquierdo()!=null)
                    aux=aux.getIzquierdo();
                n.setElem(aux.getIzquierdo().getElem());
                aux.setIzquierdo(null);
            }else{
                n.setElem(aux.getElem());
                n.setDerecho(aux.getDerecho());
            }
        }
    }
    public NodoBB buscarNodoPadre(NodoBB nodo, Comparable elem){
        NodoBB res=null;
            if(elem.compareTo(nodo.getDerecho().getElem())==0||elem.compareTo(nodo.getIzquierdo().getElem())==0){
                res=nodo;
            }else{
                if(elem.compareTo(nodo.getElem())<0){
                    if(nodo.getIzquierdo().getIzquierdo()!=null|| nodo.getIzquierdo().getDerecho()!=null)
                        res=buscarNodoPadre(nodo.getIzquierdo(),elem);
                }else{
                    if(nodo.getDerecho().getIzquierdo()!=null|| nodo.getDerecho().getDerecho()!=null)
                        res=buscarNodoPadre(nodo.getDerecho(),elem);
                }
            }          
            
        return res;    
    }
 
    public Lista listar(){
        Lista list= new Lista();
        if(this.raiz!=null){
            listarAux(this.raiz,list);
        }        
        return list;
    }
    private void listarAux(NodoBB nodo, Lista list){
        if(nodo!=null){
            if(nodo.getIzquierdo()!=null)
                listarAux(nodo.getIzquierdo(),list);
            list.insertar(nodo.getElem(), list.longitud()+1);
            if(nodo.getDerecho()!=null)
                listarAux(nodo.getDerecho(),list);
        }    
    }
    
    public boolean esVacio(){
        return this.raiz==null;
    }
    
    public Lista listarRango(Comparable minimo, Comparable maximo){
        Lista list=new Lista();
        if(this.raiz!=null){
            NodoBB aux= buscarNodo(this.raiz,minimo);
            if(aux!=null){    
                listarRangoAux(maximo,aux,list);
            }
        }        
        return list;
    }
    private boolean listarRangoAux(Comparable maximo, NodoBB nodo, Lista list){
        boolean res=false;
            if(nodo!=null){
                 if(nodo.getElem().compareTo(maximo)==0){
                     res=true;
                     list.insertar(nodo.getElem(), 1);
                 }else{
                     if(nodo.getElem().compareTo(maximo)<0){
                         if(nodo.getDerecho()!=null){
                             res=listarRangoAux(maximo,nodo.getDerecho(),list);
                             if(res){
                                 list.insertar(nodo.getElem(), 1);
                             }
                         }
                     }else{
                         if(nodo.getIzquierdo()!=null){
                             res=listarRangoAux(maximo, nodo.getIzquierdo(),list);
                             if(res)
                                 list.insertar(nodo.getElem(),1);
                         }        
                     }
                 }
            }
        return res;
    }
    private NodoBB buscarNodo(NodoBB nodo,Comparable elem){
        NodoBB res=null;
        int n= nodo.getElem().compareTo(elem);
        if(n==0){
            res=nodo;
        }else{
            if(n<0){
                if(nodo.getDerecho()!=null)
                    res=buscarNodo(nodo.getDerecho(), elem);           
            }else{
                if(nodo.getIzquierdo()!=null)
                    res=buscarNodo(nodo.getIzquierdo(),elem);
            }       
        }
    return res;
    }
    
    public Comparable minimoElem(){
        Comparable res=null;
        if(this.raiz!=null){
            NodoBB aux=this.raiz;
            while(aux.getIzquierdo()!=null)
                aux=aux.getIzquierdo();
            res=aux.getElem();
        }     
        return res;
    }
    public Comparable maximoElem(){
        Comparable res=null;
        if(this.raiz!=null){
            NodoBB aux=this.raiz;
            while(aux.getDerecho()!=null)
                aux=aux.getDerecho();
            res=aux.getElem();
        }     
        return res;
    }
     public ArbolBB clone() {
        ArbolBB clon = new ArbolBB();
        if (this.raiz != null) {
            NodoBB aux = cloneAux(this.raiz);
            clon.raiz = aux;
        }
        return clon;
    }

    private NodoBB cloneAux(NodoBB auxIzq) {
        NodoBB res = null;
        if (auxIzq != null) {
            res = new NodoBB(auxIzq.getElem());
            res.setIzquierdo(cloneAux(auxIzq.getIzquierdo()));
            res.setDerecho(cloneAux(auxIzq.getDerecho()));
        }
        return res;
    }

    public String toString() {
        String s = "";
        if (this.raiz != null) {
            s = toStringAux(this.raiz);
        }
        
        return s;
    }

    private String toStringAux(NodoBB aux) {
        String str = "";
        if (aux != null) {
            str += " Nodo:"+aux.getElem();
            if (aux.getIzquierdo() != null) {
                str += " HI: "+aux.getIzquierdo().getElem();
            }else{
                str+=" HI: null";
            }
            if(aux.getDerecho()!=null){
                str+=" HD: "+aux.getDerecho().getElem();
            }else{
                str+=" HD: null";
            }
            str+="\n";
            str += toStringAux(aux.getIzquierdo());
            str+= toStringAux(aux.getDerecho());
            
         }
        return str;
    }
    
    
}
