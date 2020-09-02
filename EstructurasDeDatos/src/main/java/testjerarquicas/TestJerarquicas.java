/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjerarquicas;

import conjuntistas.ArbolAVL;
import conjuntistas.ArbolBB;
import dinamicas.Lista;
import jerarquicas.ArbolBin;
import jerarquicas.ArbolGen;

/**
 *
 * @author Mauricio
 */
public class TestJerarquicas {
    
    public static void main(String[] args){
        ArbolAVL arb= new ArbolAVL();
        arb.insertar(6);
        arb.insertar(5);
        arb.insertar(2);
        arb.insertar(3);
        arb.insertar(4);
        arb.insertar(1);
        arb.insertar(7);
        arb.insertar(10);
        System.out.println(""+arb.toString());
        arb.eliminar(2);
         System.out.println(""+arb.toString());
        /*ArbolBB clon= arb.clone();
        System.out.println(""+clon.toString());
        if(arb.pertenece(20)){
            System.out.println("pertenece");
        }else{        
            System.out.println("no pertenece");
        }
        if(!arb.esVacio())
            System.out.println("no es vacio");
        
        
        
        clon.eliminar(9);
        
        System.out.println(""+clon.toString());
            
         
        /*System.out.println("padre: "+arb.padre(90));
        System.out.println(" "+arb.altura());
        System.out.println(" "+arb.nivel(100));
        
        System.out.println(""+arb.ancestros(1).toString());
        
        System.out.println(""+arb.listarInorden().toString());
        System.out.println(""+arb.listarPreorden().toString());
        System.out.println(""+arb.listarPostorden().toString());
        System.out.println(""+arb.listarPorNiveles().toString());
        /*Lista list = arb.listarPreorden();
        String j = list.toString();
        Lista list = new Lista();
        list.insertar(1, 1);
        list.insertar(2, 2);
        list.insertar(1, 3);
        list.insertar(4, 4);
        list.insertar(1, 5);
        list.insertar(1, 6);
        //ArbolBin clonInv= arb.clonarInvertido();
        //String j= clonInv.toString();
        System.out.println(""+list.toString());
        if(arb.verPatron(list)){
        System.out.println("es true");
        }else{
            System.out.println("es false");
        }
        list.eliminarAparicionesM(1);
        System.out.println(""+list.toString());
               Lista lis= list.obtenerMultiplos(1);
        System.out.println(""+lis.toString());
        */
        
    }
    
}
