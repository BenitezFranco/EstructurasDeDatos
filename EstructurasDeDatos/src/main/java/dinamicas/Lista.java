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
public class Lista {
    private Nodo cabecera;
    private int longitud;
    public Lista(){
        this.cabecera=null;
        this.longitud=0;
    }
    public boolean insertar(Object elem, int pos){
        boolean res= false;
        int i=1;
        if(pos >= 1 && pos <= longitud()+1){
            if(pos==1){
                Nodo aux= new Nodo(elem);
                aux.setEnlace(this.cabecera);
                this.cabecera= aux;
                this.longitud++;
                res= true;
            }
            else{
                Nodo aux= this.cabecera;
                while(i<pos-1){
                    aux=aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(elem);
                nuevo.setEnlace(aux.getEnlace());
                aux.setEnlace(nuevo);
                this.longitud++;
                res=true;
            }
        }
        return res;
    }

    
    public boolean eliminar (int pos){
        boolean res =false;
        if(pos <=this.longitud && 1<=this.longitud){
            if(pos==1){
                this.cabecera= this.cabecera.getEnlace();
                res=true;
                this.longitud--;
            }else{
                Nodo aux= this.cabecera;
                int i= 1;
                while(i<pos-1){
                    aux=aux.getEnlace();
                    i++;
                }
                aux.setEnlace((aux.getEnlace()).getEnlace());
                res=true;
                this.longitud--;
            }
        }
        return res;
    
    }
    public Object recuperar (int n){
        Object res=null;
            if(this.cabecera!=null&& n<= this.longitud){
                Nodo aux= this.cabecera;
                if(n==1){
                    res=aux.getElem();
                }else{
                    int cont= 1;
                    do{
                        aux=aux.getEnlace();
                        cont++;
                    }while(cont<n);
                    res=aux.getElem();
                }
            }
        
        return res;
    }

    public int localizar(Object elem){
        int res=-1;
        if(this.cabecera!=null){
            Nodo aux= this.cabecera;
            boolean con= aux.getElem().equals(elem);
            if(con){
                res=1;
            }else{
                int i=1;
                while(i<= this.longitud&& !con){
                    aux= aux.getEnlace();
                    i++;
                    con =(aux.getElem().equals(elem));
                }
                if(con)
                    res=i;
            }
        }
        return res;    
    }
    
    public void vaciar(){
        this.cabecera=null;
        this.longitud=0;
    }
    public boolean esVacia(){
        return this.cabecera==null;
    }
    

    public int longitud(){
        /*int i=0;
        if(this.cabecera!= null){
            Nodo aux =this.cabecera;
            while (aux!=null){
                i++;
                aux=aux.getEnlace();
            }                
        }*/
        return this.longitud;
    }
    public Lista clone(){
        Lista clon =new Lista();
        if(this.cabecera!= null){
            Nodo aux= this.cabecera;
            clonar(aux, clon);
        }
        return clon;
    }
    public void clonar(Nodo aux, Lista clon){
        if(aux!=null){
            Nodo nuevo= new Nodo (aux.getElem());
            clonar(aux.getEnlace(), clon);
            nuevo.setEnlace(clon.cabecera);
            clon.cabecera=nuevo;
        }    
    }
    public String toString (){
        String s="[";
        if(this.cabecera!=null){
            Nodo aux=this.cabecera;
            while(aux!=null){
                s+=aux.getElem();
                aux=aux.getEnlace();
                if(aux!=null)
                    s+=",";
            }
        }
        s+="]";
        return s;
    }
    
    public void eliminarAparicionesM(Object elem){
        
            while(this.cabecera!=null&&this.cabecera.getElem().equals(elem)){ 
                if(this.cabecera.getEnlace()==null){
                    this.cabecera=null;
                }else{
                    this.cabecera=this.cabecera.getEnlace();
                }
                            
            }
            
            if(this.cabecera!=null){
                Nodo aux=this.cabecera;
                Nodo siguiente= aux.getEnlace();
                while(siguiente!=null){
                    if(siguiente.getElem().equals(elem)){
                        aux.setEnlace(siguiente.getEnlace());
                        siguiente=siguiente.getEnlace();
                    }else{
                    aux=aux.getEnlace();
                    siguiente=siguiente.getEnlace();
                    }           
                }
            }
            
    }
    public Lista obtenerMultiplos(int num){
        Lista nueva= new Lista();
            if(num<=this.longitud){
                int sum= num;
                int con= 1;
                Nodo aux= this.cabecera;
                Nodo auxNuev= new Nodo();
                while(num <= this.longitud){
                    if(con!=num){
                        con++;
                        aux= aux.getEnlace();
                    }else{
                        if(nueva.cabecera==null){
                           auxNuev.setElem(aux.getElem());
                           nueva.cabecera=auxNuev;
                        }else{
                            auxNuev.setEnlace(new Nodo(aux.getElem()));
                            auxNuev=auxNuev.getEnlace();
                        }
                        aux=aux.getEnlace();
                        con++;
                        num=num+sum;
                    }
                }                    
            }       
        return nueva;
    }
    
    
}
