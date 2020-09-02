/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import dinamicas.Lista;

/**
 *
 * @author Mauricio
 */
public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(elemNuevo);
        } else {
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo));
                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo));
                    } else {
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol nodo, Object elem) {
        NodoArbol res = null;
        if (nodo.getElem() == elem) {
            res = nodo;
        } else {
            if (nodo.getIzquierdo() != null) {
                res = obtenerNodo(nodo.getIzquierdo(), elem);
            }
            if (nodo.getDerecho() != null && res == null) {
                res = obtenerNodo(nodo.getDerecho(), elem);
            }

        }
        return res;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public int altura() {
        int al = -1;
        if (this.raiz != null) {
            al = distanciaHoja(this.raiz);
        }
        return al;
    }

    private int distanciaHoja(NodoArbol nodo) {
        //devuelve la longitud del camino mas largo de un nodo a una hoja
        int con = 0;
        int der = 0;
        if (nodo.getIzquierdo() != null) {
            con = 1 + distanciaHoja(nodo.getIzquierdo());
        }
        if (nodo.getDerecho() != null) {
            der = 1 + distanciaHoja(nodo.getDerecho());
        }
        if (der > con) {
            con = der;
        }
        return con;
    }

    public int nivel(Object elem) {
        int lvl = -1;
        if (this.raiz != null) {
            lvl = nivelLugar(this.raiz, elem);
        }
        return lvl;
    }

    private int nivelLugar(NodoArbol nodo, Object elem) {
        //cuenta la cantidad de enlaces entre "nodo" y el nodo contenedor de "elem"
        int con = -1;
        if (nodo.getElem() == elem) {
            con = 0;
        } else {
            if (nodo.getDerecho() != null) {
                int der = nivelLugar(nodo.getDerecho(), elem);
                if (der >= 0) {
                    con = 1 + der;
                }
            }
            if (nodo.getIzquierdo() != null && con < 0) {
                int izq = nivelLugar(nodo.getIzquierdo(), elem);
                if (izq >= 0) {
                    con = 1 + izq;
                }
            }
        }
        return con;
    }

    public Object padre(Object elem) {
        Object res = null;
        if (this.raiz != null) {
            res = buscarPadre(this.raiz, elem);
        }
        return res;
    }

    private Object buscarPadre(NodoArbol nodo, Object elem) {
        //busca el padre del "elem" entre el "nodo" y su hijos
        Object band = null;
        if (nodo.getDerecho().getElem() == elem || nodo.getIzquierdo().getElem() == elem) {
            band = nodo.getElem();
        } else {
            if (nodo.getDerecho().getDerecho() != null || nodo.getDerecho().getIzquierdo() != null) {
                band = buscarPadre(nodo.getDerecho(), elem);
            }
            if ((nodo.getIzquierdo().getDerecho() != null || nodo.getIzquierdo().getIzquierdo() != null) && band == null) {
                band = buscarPadre(nodo.getIzquierdo(), elem);
            }
        }
        return band;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public ArbolBin clone() {
        ArbolBin clon = new ArbolBin();
        if (this.raiz != null) {
            NodoArbol aux = cloneAux(this.raiz);
            clon.raiz = aux;
        }
        return clon;
    }

    private NodoArbol cloneAux(NodoArbol auxIzq) {
        NodoArbol res = null;
        if (auxIzq != null) {
            res = new NodoArbol(auxIzq.getElem());
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

    private String toStringAux(NodoArbol aux) {
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

    public Lista listarPreorden() {
        Lista list = new Lista();
        if (this.raiz != null) {
            preOrdenAux(this.raiz, list);
        }
        return list;
    }

    private void preOrdenAux(NodoArbol aux, Lista list) {
        if (aux != null) {
            int con = list.longitud() + 1;
            list.insertar(aux.getElem(), con);
            preOrdenAux(aux.getIzquierdo(), list);
            preOrdenAux(aux.getDerecho(), list);
        }
    }

    // public Lista listarInOrden(){
    //}
    /* posorden (nodobin n)
        si n!=null
            posorden(HI)
            posorden(HD)
            visitar n
     */
    public ArbolBin clonarInvertido() {
        ArbolBin clon = new ArbolBin();
        if (this.raiz != null) {
            NodoArbol nodo = invertido(this.raiz);
            clon.raiz = nodo;
        }
        return clon;
    }

    private NodoArbol invertido(NodoArbol nodo) {
        NodoArbol aux = null;
        if (nodo != null) {
            aux = new NodoArbol(nodo.getElem());
            aux.setIzquierdo(invertido(nodo.getDerecho()));
            aux.setDerecho(invertido(nodo.getIzquierdo()));
        }
        return aux;
    }

    public boolean verPatron(Lista patron) {
        boolean res = false;
        if (this.raiz == null && patron.esVacia()) {
            res = true;
        }
        if (this.raiz != null && !patron.esVacia()) {
            res = patronAux(this.raiz, patron, 1);
        }
        return res;
    }

    private boolean patronAux(NodoArbol nodo, Lista list, int con) {
        boolean res = false;
        if (nodo.getElem().equals(list.recuperar(con))&& (list.longitud())==con) {
            if(nodo.getDerecho() == null && nodo.getIzquierdo() == null){
            res = true;
            }
        }
        if (nodo.getElem().equals(list.recuperar(con)) && con<list.longitud()) {
            if(nodo.getIzquierdo()!=null){
                res = patronAux(nodo.getIzquierdo(), list, con + 1);
                if (!res) {
                   if(nodo.getDerecho()!=null){
                    res = patronAux(nodo.getDerecho(), list, con+1);
                   }
                }
            }else{
                if(nodo.getDerecho()!=null){
                    res=patronAux(nodo.getDerecho(),list,con+1);
                }
                    
            }
            
        
        }
        
        return res;
    }
}
