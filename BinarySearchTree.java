
/**
 * @author Pablo David Basulto Polanco
 */
import java.util.Scanner;

public class BinarySearchTree
 {
     public static void main(String[] args)
    {                 
        Scanner scan = new Scanner(System.in);
        
        BST bst = new BST(); 
        System.out.println("Binary Search Tree \n");   
        char ch;
        /*  Perform tree operations  */
        do    
        {
            System.out.println("\nOperaciones en un Binary Search Tree\n");
            System.out.println("1. inserta ");
            System.out.println("2. eliminar");
            System.out.println("3. Recorrer el árbol por niveles");
            System.out.println("4. Recorrer el árbol a lo profundo");
 
            int choice = scan.nextInt();            
            
            switch(choice){
                case 1:
                    System.out.println("Ingrese el número a insertar: ");
                    bst.insert(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Ingrese el número a eliminar: ");
                    bst.delete(scan.nextInt());
                    break;
                case 3:
                    if (!bst.isEmpty()){
                        bst.RecorridoPerLever();
                    }
                    else{
                        System.out.println("El árbol está vacío");
                    }
                    break;
                case 4:
                    if (!bst.isEmpty()){
                        System.out.println("Ingrese el recorrido que desea analizar: ");
                        System.out.println("1. Preorden");
                        System.out.println("2. Inorden");
                        System.out.println("3. Postorden");
                        int choice2 = scan.nextInt();
                        if (choice2 == 1){
                            bst.preorder();
                        }
                        else if(choice2 == 2){
                            bst.inorder();
                        }
                        else if(choice2 == 3){
                            bst.postorder();
                        }
                        else{
                            System.out.println("Opción no válida");
                        }
                       
                    }
                    else{
                        System.out.println("El árbol está vacío");
                    }
                     break;
                
            }
                    
 
            System.out.println("\nContinuar (S o N) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'S'|| ch == 's');               
    }
}
     