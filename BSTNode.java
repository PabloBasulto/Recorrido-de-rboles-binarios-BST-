
/**
 * @author Pablo David Basulto Polanco
 */
import java.util.Scanner;
 
 
 class BSTNode
 {
     /**
      * left: Nodo hijo del lado izquierdo∫
      * right: Nodo hijo del lado derecho
      */
     BSTNode left, right;
     int data;
 
     /**
      * Constructor para declarar un nodo con parámetro estándar 0 e hijos nulos
      */
     public BSTNode()
     {
         
         left = null;
         right = null;
         data = 0;
     }
     
     //Si el valor a buscar es menor que el valor del nodo actual el se hace recursión hacia la izquierda
     public BSTNode(int n)
     {
         left = null;
         right = null;
         data = n;
     }
     /**
      * Método para establecer un valor de nodo al hijo  izquierdo
      * @param n 
      */
     
     public void setLeft(BSTNode n)
     {
         left = n;
     }
     /**
      * Método para establecer un valor de nodo al hijo  derecho
      * @param n <-Data del hijo derecho
      */
      
     public void setRight(BSTNode n)
     {
         right = n;
     }
     
     /**
      * Método para obtener un valor de nodo al hijo izquierdo
      * @return <- Data del hijo izquierdo
      */
     public BSTNode getLeft()
     {
         return left;
     }
     
     /**
      * Método para obtener el valor de nodo del hijo derecho
      * @return <-Data del hijo derecho
      */
     public BSTNode getRight()
     {
         return right;
     }
     
    /**
     * Método para establecer data del nodo
     * @param d <-Data del nodo a establecer
     */
     public void setData(int d)
     {
         data = d;
     }
     
     /**
      * Método para obtener la data del nodo
      * @return <-Data del nodo
      */
     public int getData()
     {
         return data;
     }     
 }