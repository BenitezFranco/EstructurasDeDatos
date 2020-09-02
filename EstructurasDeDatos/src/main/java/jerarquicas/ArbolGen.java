/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import dinamicas.ColaDinamica;
import dinamicas.Lista;

/**
 *
 * @author Mauricio
 */
public class ArbolGen {
        private NodoGen raiz;
        
        public ArbolGen(){
            raiz=null;
        }
        
        public boolean insertar(Object hijo, Object padre){
            boolean res =false;
            if(this.raiz==null){
                this.raiz= new NodoGen(hijo);
                res=true;                
            }else{
                NodoGen nodoPadre= obtenerNodo(this.raiz, padre);
                if(nodoPadre!= null){
                    if(nodoPadre.getHijo()!=null){
                        NodoGen aux= nodoPadre.getHijo();
                        while(aux.getHermano()!=null){
                            aux=aux.getHermano();
                        }
                        aux.setHermano(new NodoGen (hijo));
                    }else{
                        nodoPadre.setHijo(new NodoGen(hijo));
                    }
                    res=true;
                }
            }            
            return res;
        }
        
        private NodoGen obtenerNodo(NodoGen nodo,Object elem){
            NodoGen res = null;
            if(nodo.getElem().equals(elem)){
                res=nodo;
            }else{
                if(nodo.getHijo()!=null){
                    res=obtenerNodo(nodo.getHijo(), elem);
                }
                if(nodo.getHermano()!=null && res==null){
                    res=obtenerNodo(nodo.getHermano(), elem);
                }
            }
            
            return res;
        }
        
        public boolean pertenece(Object elem){
            boolean res=false;
            if(this.raiz!=null){
                res= buscar(this.raiz, elem);
            }           
            return res;
        }
        
        private boolean buscar(NodoGen nodo, Object elem){
            boolean res= false;
                if(nodo.getElem().equals(elem)){
                    res=true;
                }else{
                    if(nodo.getHijo()!=null){
                        res=buscar(nodo.getHijo(), elem);
                    }
                    if(nodo.getHermano()!=null && !res){
                        res= buscar(nodo.getHermano(),elem);
                    }            
                }            
            return res;
        }
        public boolean esVacio(){
            return this.raiz==null;
        }
        public Object padre(Object elem){
            Object res= null;
            if(this.raiz!=null){
                if(this.raiz.getElem()!=elem &&this.raiz.getHijo()!=null){
                    res=padreAux(this.raiz, elem);
                }
            }
            return res;
        }
        
        private Object padreAux(NodoGen nodo, Object elem){
            Object res=null;
            if(nodo.getHijo().getElem().equals(elem)){
                res=nodo.getElem();
            }else{
               if(nodo.getHijo().getHijo()!=null){
                    res= padreAux(nodo.getHijo(),elem);
                }
                NodoGen hijo= nodo.getHijo().getHermano();
                while(hijo!=null&& res==null){
                    if(hijo.getElem().equals(elem)){
                        res=nodo.getElem();
                    }else{
                        if(hijo.getHijo()!=null)
                            res=padreAux(hijo, elem);
                        hijo=hijo.getHermano();
                    }
                }
            }
            
            return res;
        }
        
        public int altura(){
            int res=-1;
            if(this.raiz!=null){
                res=alturaAux(this.raiz);
            }            
            return res;
        }
        
        private int alturaAux(NodoGen nodo){
            int band=0;
            int aux= 0;
            if(nodo.getHijo()!=null){
                band=1+ alturaAux(nodo.getHijo());
            }
            if(nodo.getHermano()!=null){
                aux=alturaAux(nodo.getHermano());
            }
            if(band<aux){
                band=aux;
            }
            return band;
        }
        public int nivel(Object elem){
            int res=-1;
            if(this.raiz!=null)
                res=nivelAux(this.raiz,elem );
            return res;
        }
        
        private int nivelAux(NodoGen nodo, Object elem){
            int band=-1;
            if(nodo.getElem()==elem){
                band=0;
            }else{
                if(nodo.getHijo()!=null){
                    band=nivelAux(nodo.getHijo(), elem);
                    if(band>=0){
                        band++;
                    }
                }
                if(nodo.getHermano()!=null&& band==-1){
                    band= nivelAux(nodo.getHermano(), elem);
                }
            }           
            return band;
        }
        
        public Lista ancestros(Object elem){
            Lista res= new Lista();
            if(this.raiz!=null){
                ancestrosAux(this.raiz, elem,res);
            }            
            return res;
        }
        
        private boolean ancestrosAux(NodoGen nodo,Object elem,Lista list){
            boolean res=false;
                if(nodo.getElem().equals(elem)){
                    res=true;
                }else{
                    if(nodo.getHijo()!=null){
                        res=ancestrosAux(nodo.getHijo(),elem,list);
                        if(res){
                            list.insertar(nodo.getElem(), 1);
                        }
                    }
                    if(nodo.getHermano()!=null && !res){
                        res= ancestrosAux(nodo.getHermano(), elem,list);
                    }
                }
            return res;
        }
        
        public void vaciar(){
            this.raiz=null;
        }
        
        public ArbolGen clonar(){
            ArbolGen clon = new ArbolGen ();
                clon.raiz=clonarAux(this.raiz);
            return clon;
        }
        
        private NodoGen clonarAux(NodoGen nodo){
            NodoGen res= null;
            if(nodo!=null){
                res= new NodoGen(nodo.getElem());
                res.setHijo(clonarAux(nodo.getHijo()));
                res.setHermano(clonarAux(nodo.getHermano()));
            }
            return res;        
        }
        
        public Lista listarInorden(){
            Lista salida= new Lista();
            listarInordenAux(this.raiz, salida);
            return salida;
        }
        
        private void listarInordenAux(NodoGen nodo, Lista list){
            if(nodo!=null){
                if(nodo.getHijo()!=null){
                    listarInordenAux(nodo.getHijo(), list);
                }
                list.insertar(nodo.getElem(), list.longitud()+1);
                if(nodo.getHijo()!=null){
                    NodoGen hijo= nodo.getHijo().getHermano();
                    while(hijo!=null){
                        listarInordenAux(hijo,list);
                        hijo=hijo.getHermano();
                    }
                }
            }
        }
        
        public Lista listarPreorden(){
            Lista salida = new Lista();
            preOrdenAux(this.raiz,salida);    
            return salida;        
        }
        
        private void preOrdenAux(NodoGen nodo, Lista list){
            if(nodo!=null){
                list.insertar(nodo.getElem(), list.longitud()+1);
                if(nodo.getHijo()!=null){
                    preOrdenAux(nodo.getHijo(),list);
                    NodoGen hijo=nodo.getHijo().getHermano();
                    while(hijo!=null){
                        preOrdenAux(hijo, list);
                        hijo=hijo.getHermano();
                    }                
                }
            }
        }
        public Lista listarPostorden(){
            Lista salida=new Lista();
            postOrdenAux(this.raiz,salida);
            return salida;
        }
        private void postOrdenAux(NodoGen nodo, Lista list){
            if(nodo!=null){
                if(nodo.getHijo()!=null){
                    postOrdenAux(nodo.getHijo(),list);
                    NodoGen hijo=nodo.getHijo().getHermano();
                    while(hijo!=null){
                        postOrdenAux(hijo, list);
                        hijo=hijo.getHermano();
                    }                
                }
                list.insertar(nodo.getElem(), list.longitud()+1);
            }
        }
        
        public Lista listarPorNiveles(){
            Lista res= new Lista();
            if(this.raiz!=null){
                ColaDinamica q =new ColaDinamica();
                q.poner(this.raiz);
                while(!q.esVacia()){
                    NodoGen aux =(NodoGen) q.obtenerFrente();
                    q.sacar();
                    res.insertar(aux.getElem(),res.longitud()+1);
                    aux=aux.getHijo();
                    while (aux!=null){
                        q.poner(aux);
                        aux=aux.getHermano();
                    }
                }
            }
            return res;
        }
        
        public String toString(){
            String s="";
            if(this.raiz!=null){
                s+=toStringAux(this.raiz);            
            }            
            return s;
        }
        
        private String toStringAux(NodoGen nodo){
            String s="";
            if(nodo!=null){
                s+=nodo.getElem()+"->";
                NodoGen hijo=nodo.getHijo();
                while(hijo!=null){
                s+=hijo.getElem()+", ";
                hijo=hijo.getHermano();
                }
                hijo=nodo.getHijo();
                while(hijo!=null){
                    s+="\n"+toStringAux(hijo);
                    hijo=hijo.getHermano();
                }
            }
            return s;
        }
}
