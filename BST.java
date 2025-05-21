/**
 * @author Pablo David Basulto Polanco
 */
import java.util.Queue;
import java.util.LinkedList;

/**
 * 
 * @author Pablo Basulto 
 */
 class BST
 {
     /**
      * Nodo raiz del arbol
      */
     private BSTNode root;
 
     /**
      * Constructor de la clase BST, root se inicializa como varlo vacío
      */
     public BST()
     {
         root = null;
     }
     
     /**
      * Funcion que recorre verifica si el arbol tiene algun nodo obbservando el 
      * estado del nodo raiz
      * @return Verdadero si la raiz  del nodo No es vacia y falso de lo contrario 
      */
     public boolean isEmpty()
     {
         return root == null;
     }
     
     /**
      * funcion publica que llama a una funcion private que inserta un nodo en el arbol binario
      * @param data dato numerico del nodo que se está insertando en el arbol
      */
     public void insert(int data)
     {
         root = insert(root, data);
     }
     
     /**
      * Funcion recursiva que va insertando nodos de manera ordenda fijando los menores en el subarbol izquierdo
      * y lo mayores en el derecho
      * @param node nodo que se esta verificando
      * @param data dato del nuevo nodo a insertar
      * @return nodo raíz actualizado con el nuevo elemento.
      */
     private BSTNode insert(BSTNode node, int data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data <= node.getData()){
                 node.left = insert(node.left, data);
             }
             else{
                 node.right = insert(node.right, data);
             }
         }
         return node;
     }
     
     /**
      * Funcion publica que llama a la funcion privada delete pero antes verifica que el arbol no este vacio
      * o que el elemento a eliminar se encuentre en el arbol.
      * @param k 
      */
     public void delete(int k)
     {
         if (isEmpty())
             System.out.println("Arbol vacio");
         else if (search(k) == false)
             System.out.println("Ups "+ k +" no esta en el arbol");
         else
         {
             root = delete(root, k);
             System.out.println(k+ " eliminado del arbol");
         }
     }
             
     
     /**
      * Funcion publica que llama a la funcion privada para contar los nodos del arbol
      * @return numero total de nodos en el arbol
      */
     public int countNodes()
     {
         return countNodes(root);
     }
     
     /**
     * Método que recorre el árbol de manera recurrsiva y regresa un contador
     * con el total de nodos en el árbol
     * 
     * @param r <- Nodo raíz
     * @return total de nodos
     */
     private int countNodes(BSTNode r)
     {
         //Si el árbol está vacío se regres 0
         if (r == null)
             return 0;
         else
         {
             //Se inicializa el contador con valor de 1
             int l = 1;
             //Se cuentan los nodos del manera recursiva por el subarbol izquierdo
             l += countNodes(r.getLeft());
             //Se cuentan los nodos del manera recursiva por el subarbol derecho
             l += countNodes(r.getRight());
             return l;
         }
     }
     
  
     /**
      * Método de referencia para buscar un valor en el árbol
      * @param val <- Valor numérico a encontrar en el árbol
      * @return true si se encontró el valor false en caso contrario
      */
     public boolean search(int val)
     {
         return search(root, val);
     }
     
     /**
      * Método que elimina un nodo en específico del árbol 
      * @param root <-Nodo raíz del nodo a eliminar
      * @param k <- Valor del nodo a eliminar
      * @return <- Nodo raíz actualizado
      */
     private BSTNode delete(BSTNode root, int k)     {
         
        //Si el árbol está vacío se regresa el mismo nodo raíz
         if (root == null) {
            return root;
        }
         //Se va llamando a la función de manera recursiva a la izquierda o derecha dependiendo si es mayor o menor que el nodo actual
        if (k < root.getData()) {
            root.left = delete(root.left, k);            
        } 
        else if(k > root.getData()){
            root.right = delete(root.right, k);
        }
        //Caso base: Se encuentra el nodo con el valor a eliminar: 
        else if (root.getData() == k){
            
            //En caso de que el nodo a eliminar no tenga ningún hijo
            if (root.left == null && root.right == null)
            {
                return null;
            }
            //En caso a que el nodo a eliminar sola tenga hijo a la derecha
            else if (root.left == null)
            {
                return root.right;
            } 
            //En caso de que el nodo a eliminar solo tengo hijo a la izquierda
            else if (root.right==null)
            {
                return root.left;
            }
            else
            {
                // la variable p almacenara todo el nodo de la derecha
                BSTNode p, rt;
                rt = root.getRight();
                p = rt;
                //p sera el el nodo más a la izquierda del arbol derecho
                while (p.getLeft()!= null){
                    p = p.getLeft();
                }
                root.data=p.data;
                root.right=delete(root.right,root.data);
            }
            return root;
        }
       return root;
    }

     /**
      * Método que busca un valor en específico dentro del árbol binario 
      * 
      * @param r nodo actual que se esta analizando
      * @param val valor que del nodo a buscar en el arbol
      * @return verdadero si el nodo fue encontrado o falso si  se recorrio todo el arbol y el nodo no 
      */
     private boolean search(BSTNode r, int val)
     {
         //Se declara un booleano con valor estándar falso 
         boolean found = false;
         //Ciclo while pare recorrer los subárboles de manera recursiva
         while ((r != null) && !found)
         {
             
             int rval = r.getData();
             //Si el valor a buscar es menor que el valor del nodo actual el se hace recursión hacia la izquierda
             if (val < rval)
                 r = r.getLeft();
             //Si el valor a buscar es mayor que el valor del nodo actual el se hace recursión hacia la derecha
             else if (val > rval)
                 r = r.getRight();
             else
                 
             //Caso base: se encontró el valor en el árbol 
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     
     /**
      * Método que recorre los nodos del árbol por nivel
      * @param r <-Nodo raíz
      */
     private void RecorridoPerLever(BSTNode r){
         
        Queue<BSTNode> cola = new LinkedList<BSTNode>();
        
        cola.add(r);
        BSTNode p;
        while (!cola.isEmpty()){
            
            p = cola.peek();
            System.out.print(p.data + ", ");
            
            if (p.left != null){
                cola.add(p.left);
            }
            if (p.right != null){
                cola.add(p.right);
            }
            
            cola.remove();
            
        }
     }
     
     /**
      * Método público que llama a la función para recorrer nivel
      */
     public void RecorridoPerLever(){
         RecorridoPerLever(root);
     }
     
     /**
      * llamado a la funcion orden con el nodo raiz como parametro
      */
     public void inorder()
     {
         inorder(root);
     }
     
     /**
      * Funcion que recorre el arbol de manera recursiva dandole prioridad a los 
      * nodos que estén más a la izquierda, a la raíz y a la derecha respectivamente
      * @param r nodo raiz del subarbol que se esta recorriendo
      */
     private void inorder(BSTNode r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +" ");
             inorder(r.getRight());
         }
     }
     
     /**
      * Llamado a la funcion preorder con el nodo raiz como parametro
      */
     public void preorder()
     {
         preorder(root);
     }
     /**
      * Función que recorre el arbol de manera recursiva dando prioridad
      * a lo raiz, izquierda y derecha respectivamente
      * @param r <-nodo raiz del subarbol que se esta recorriendo
      */
     private void preorder(BSTNode r)
     {
         if (r != null)
         {
             System.out.print(r.getData() +" ");
             preorder(r.getLeft());             
             preorder(r.getRight());
         }
     }
     /**
      * Llamado a la funcion post orden con el nodo raiz como parametro
      */
     public void postorder()
     {
         postorder(root);
     }
     
     /**
      * Funcion que recorre el arbol de manera recursica dando a los nodos de la
      * izquiera, derecha y a la raiz respectivamente
      * @param r nodo raiz del subarbol que se esta recorriendo
      */
     private void postorder(BSTNode r)
     {
         if (r != null)
         {
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.print(r.getData() +" ");
         }
     }     
 }