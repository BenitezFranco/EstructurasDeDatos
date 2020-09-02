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
public class TablaHash {
        private static final int TAM=10;
        private Nodo arr[];
        private int cant;
        
        public TablaHash(){
            this.arr= new Nodo [TablaHash.TAM];
            cant=0;
        }
        
        private int funcionH(String s){
            int res=0;
            char aux;
            for(int i=0;i < s.length();i++){
                aux =s.charAt(i);
                res= (int) aux +res;
        }
            res= res%TablaHash.TAM;
            return res;        
        }
    
}
