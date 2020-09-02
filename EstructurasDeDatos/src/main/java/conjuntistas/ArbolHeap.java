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
public class ArbolHeap {
    
    private static final int TAM=20;
    private Comparable heap[];
    private int ultimo=0;
    
    public ArbolHeap(){
        this.heap=new Comparable[ArbolHeap.TAM];    
    }
    
    public boolean insertar(Comparable elem){
        boolean res=false;
        if(this.ultimo < (ArbolHeap.TAM) -1){
            this.heap[this.ultimo+1]=elem;
            this.ultimo++;
        }
        int lugar = this.ultimo;
        Comparable aux;
        while(this.heap[lugar].compareTo(this.heap[(lugar)/2])<0 || lugar==1){
                aux= this.heap[lugar/2];
                this.heap[lugar/2]=this.heap[lugar];
                this.heap[lugar]=aux;
                lugar=lugar/2;
        }       
        return res;
    }
    
    public boolean eliminarCima(){
        boolean res=false;
        if(this.ultimo>0){
            if(this.ultimo==1){
                this.heap[1]=null;
            }else{
            this.heap[1]=this.heap[this.ultimo];
            this.heap[this.ultimo]=null;
            }
            this.ultimo--;
            res=true;
            int lugar=1;
            int con= lugar*2;
            Comparable aux;
            while((this.heap[con].compareTo(this.heap[lugar])<0||this.heap[con+1].compareTo(this.heap[lugar])<0)&&lugar<=this.ultimo){
                if(this.heap[con].compareTo(this.heap[con+1])<0){
                    aux=this.heap[con+1];
                    this.heap[con+1]=this.heap[lugar];
                    this.heap[lugar]=aux;
                    lugar=(con+1);
                    con=(con+1)*2;
                }else{
                    aux=this.heap[con];
                    this.heap[con]=this.heap[lugar];
                    this.heap[lugar]=aux;
                    lugar=con;
                    con=con*2;
                }
            }
            
        }
                
        return res;
    }
    
    public Comparable recuperarCima(){
        return this.heap[1];
    }
    public boolean esVacio(){
        return this.ultimo==0;
    }
    
        
    
}
