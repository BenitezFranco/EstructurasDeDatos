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
public class Cola {
        private static final int TAM=10;
        private Object arr[];
        private int frente=0;
        private int fin=0;
        
        public Cola(){
            this.arr= new Object [Cola.TAM];
        }
        public boolean poner(Object elem){
            boolean res=false;
            if(this.frente!=(this.fin+1)% Cola.TAM){
                this.arr[this.fin]= elem;
                this.fin=(this.fin+1)%Cola.TAM;
                res=true;
            }
            return res;
        }
        public boolean sacar(){
            boolean res =false;
            if(this.fin!=this.frente){
                this.arr[this.frente]=null;
                this.frente=(this.frente+1)%Cola.TAM;
                res=true;
                }
            return res;
            }
        public Object obtenerFrente(){
            Object re=null;
            if(this.frente!=this.fin){
                re=this.arr[this.frente];
            }
            return re;
        }
        public boolean esVacia(){
            return this.frente==this.fin;
        }
        public void vaciar (){
            boolean res;
            do{
            res=this.sacar();
            }while(res);
        }
        public Cola clone(){
            int i=0;
            Cola clon=new Cola();
            while(i!=Cola.TAM){
                clon.arr[i]=this.arr[i];
                i++;
            }
            clon.frente=this.frente;
            clon.fin=this.fin;
            return clon;
        }
        public String toString(){
            int i= this.frente;
            String s= "[";
            while(i!=this.fin){
                s+=this.arr[i];
                i=(i+1)%Cola.TAM;
                if(i!=this.frente){
                    s+=",";
                }
            }
            s+="]";
            return s;
        }
}
