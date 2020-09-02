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
public class ArbolAVL {
    
     private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }
    public boolean pertenece (Comparable elem){
        boolean res=false;
            if(this.raiz!=null){
                res=perteneceAux(this.raiz, elem);
            }
         return res;
    }
    
    public boolean perteneceAux(NodoAVL nodo, Comparable elem){
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
    
    private NodoAVL rotarIzquierda(NodoAVL n){
        System.out.println("hola");
        NodoAVL h= n.getDerecho();
        NodoAVL temp= h.getIzquierdo();
        h.setIzquierdo(n);
        n.setDerecho(temp);
        n.recalcularAltura();
        h.recalcularAltura();
        return h;
    }
    
    private NodoAVL rotarDerecha(NodoAVL r){
        System.out.println("hola");
        NodoAVL h= r.getIzquierdo();
        NodoAVL temp= h.getDerecho();
        h.setDerecho(r);
        r.setIzquierdo(temp);
        h.recalcularAltura();
        r.recalcularAltura();
        return h;
    }
    
    private NodoAVL rotarDerechaIzquierda(NodoAVL r){
        rotarDerecha(r.getDerecho());
        NodoAVL res= rotarIzquierda(r);
        return res;
    }
    private NodoAVL rotarIzquierdaDerecha(NodoAVL r){
        rotarIzquierda(r.getIzquierdo());
        NodoAVL res= rotarDerecha(r);
        return res;
    }
    
    private NodoAVL balancear(NodoAVL n){
        int sum=0;
        NodoAVL res= n;
        NodoAVL izq= n.getIzquierdo();
        NodoAVL der= n.getDerecho();
        if(izq!=null){
                    sum= izq.getAltura(); 
                if(der!=null)
                    sum= sum-der.getAltura();
        }else{
            if(der!=null)
                sum=-der.getAltura();
        }             
        if(sum<=-2){
            int aux= 0;
            if(der.getIzquierdo()!=null){
                    aux= der.getIzquierdo().getAltura(); 
                if(der.getDerecho()!=null)
                    aux= aux-der.getDerecho().getAltura();
        }else{
            if(der.getDerecho()!=null)
                aux =-der.getDerecho().getAltura();
        }
            if(aux==1)
                res= rotarDerechaIzquierda(n);
            else{
                if(aux <= 0)
                    res=rotarIzquierda(n);
            }
        }
        if(sum>=2){
            int aux= 0;
            if(izq.getIzquierdo()!=null){
                    aux= izq.getIzquierdo().getAltura(); 
                if(izq.getDerecho()!=null)
                    aux= aux-izq.getDerecho().getAltura();
        }else{
            if(izq.getDerecho()!=null)
                aux =-izq.getDerecho().getAltura();
        }
            if(aux==-1)
                res=rotarIzquierdaDerecha(n);
            else
                if(aux>=0){
                res=rotarDerecha(n);
                }
        }
        return res;
    }
    public boolean insertar(Comparable elem){
        boolean res= true;
        if(this.raiz==null){
            this.raiz=new NodoAVL(elem);
        }else{
            res= insertarAux(this.raiz,elem);
            this.raiz= balancear(this.raiz);
        }
        
        return res;
    }
    
    private boolean insertarAux(NodoAVL nodo, Comparable elem){
        boolean res=true;
        if(elem.compareTo(nodo.getElem())==0){
            res=false;
        }else{
            if(elem.compareTo(nodo.getElem())<0){
                if(nodo.getIzquierdo()!=null){
                    res=insertarAux(nodo.getIzquierdo(),elem);
                    nodo.setIzquierdo(balancear(nodo.getIzquierdo()));
                }
                else 
                    nodo.setIzquierdo(new NodoAVL(elem));
            }else{
                if(nodo.getDerecho()!=null){
                    res=insertarAux(nodo.getDerecho(),elem);
                    nodo.setDerecho(balancear(nodo.getDerecho()));
                }else{
                    nodo.setDerecho(new NodoAVL(elem));
                }
            }
        
        }
                        nodo.recalcularAltura();
                        System.out.println(""+nodo.getAltura()+" "+nodo.getElem());
                       
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
                res= eliminarRecur(this.raiz, elem);
                
            }        
        }
        if(this.raiz!=null)
            this.raiz=balancear(this.raiz);
        return res;
    }
    
    private void elimConPadre (NodoAVL n, Comparable elem){
        if(n.getDerecho().getElem().compareTo(elem)==0){
                        NodoAVL hijo=n.getDerecho();
                        if(hijo.getDerecho()!=null||hijo.getIzquierdo()!=null){
                            eliminarAux(hijo);
                            n.setDerecho(balancear(hijo));
                        }else{
                            n.setDerecho(null);
                        }
                    }else{
                        NodoAVL hijo=n.getIzquierdo();
                        if(hijo.getDerecho()!=null||hijo.getIzquierdo()!=null){
                            eliminarAux(hijo);
                            n.setIzquierdo(balancear(hijo));
                           }else{
                            n.setIzquierdo(null);
                        }
        }
        n.recalcularAltura();
    }
    
    private boolean eliminarRecur(NodoAVL n, Comparable elem){
        boolean res= false;
            if(elem.compareTo(n.getDerecho().getElem())==0||elem.compareTo(n.getIzquierdo().getElem())==0){
                res=true;
                elimConPadre(n,elem);
            }else{
                if(elem.compareTo(n.getElem())<0){
                    if(n.getIzquierdo().getIzquierdo()!=null|| n.getIzquierdo().getDerecho()!=null){
                        res=eliminarRecur(n.getIzquierdo(),elem);
                        if(res)
                            n.setIzquierdo(balancear(n.getIzquierdo()));
                    }
                }else{
                    if(n.getDerecho().getIzquierdo()!=null|| n.getDerecho().getDerecho()!=null){
                        res=eliminarRecur(n.getDerecho(),elem);
                        if(res)
                            n.setDerecho(balancear(n.getDerecho()));
                    }
                }
            }
            
        n.recalcularAltura();
        return res;
    }
    
    private void eliminarAux(NodoAVL n){
        if(n.getIzquierdo()!=null){
            NodoAVL aux=n.getIzquierdo();
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
            NodoAVL aux=n.getDerecho();
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
        n.recalcularAltura();
    }
    public NodoAVL buscarNodoPadre(NodoAVL nodo, Comparable elem){
        NodoAVL res=null;
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
    private void listarAux(NodoAVL nodo, Lista list){
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
            NodoAVL aux= buscarNodo(this.raiz,minimo);
            if(aux!=null){    
                listarRangoAux(maximo,aux,list);
            }
        }        
        return list;
    }
    private boolean listarRangoAux(Comparable maximo, NodoAVL nodo, Lista list){
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
    private NodoAVL buscarNodo(NodoAVL nodo,Comparable elem){
        NodoAVL res=null;
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
            NodoAVL aux=this.raiz;
            while(aux.getIzquierdo()!=null)
                aux=aux.getIzquierdo();
            res=aux.getElem();
        }     
        return res;
    }
    public Comparable maximoElem(){
        Comparable res=null;
        if(this.raiz!=null){
            NodoAVL aux=this.raiz;
            while(aux.getDerecho()!=null)
                aux=aux.getDerecho();
            res=aux.getElem();
        }     
        return res;
    }
    
     public ArbolAVL clone() {
        ArbolAVL clon = new ArbolAVL();
        if (this.raiz != null) {
            NodoAVL aux = cloneAux(this.raiz);
            clon.raiz = aux;
        }
        return clon;
    }

    private NodoAVL cloneAux(NodoAVL auxIzq) {
        NodoAVL res = null;
        if (auxIzq != null) {
            res = new NodoAVL(auxIzq.getElem());
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

    private String toStringAux(NodoAVL aux) {
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
