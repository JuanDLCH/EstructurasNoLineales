/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

/**
 *
 * @author samaniw Juan Diego Londoño Chavarría
 */
public class EstructurasNoLineales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(3, 0);
        g1.addEdge(3, 1);
        g1.addEdge(3, 2);
        //...
        g1.deleteEdge(0, 1);
        g1.deleteEdge(1, 2);
//        System.out.println("Matriz de adyacencias");
//        System.out.println(g1.showAMatrix());
//        System.out.println("Lista de adyacencias");
//        System.out.println(g1.showAList());

        MaxHeap maxData = new MaxHeap();
        //31,51,53,28,47,22
        maxData.insert(31);
        maxData.insert(51);
        maxData.insert(53);
        maxData.insert(28);
        maxData.insert(47);
        maxData.insert(22);
        //System.out.println(maxData.getDataHeap());
        //maxData.ExtractMax();
        //System.out.println(maxData.getDataHeap());

        BinarySearchTree pino = new BinarySearchTree(10);
        try {
            pino.Add(5);
            pino.Add(3);
            pino.Add(8);
            pino.Add(20);
            pino.Add(7);
            pino.Add(18);
            pino.Add(25);
            pino.Add(23);
            pino.Add(30);
            pino.Add(21);
            pino.Add(24);

            pino.Delete(5);
            pino.Delete(3);
            pino.Delete(20);
            pino.Delete(25);
            pino.Delete(30);
            pino.Delete(8);
            //pino.Delete(3);
            System.out.println("");
            System.out.println("Nodos: " + pino.CountNodes());
            System.out.println("Hojas: " + pino.CountLeafs());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("");

        System.out.println("PreOrden: ");
        pino.PreOrden();
        System.out.println("");
        System.out.println("InOrden: ");
        pino.InOrden();
        System.out.println("");
        System.out.println("PostOrden");
        pino.Postorden();
        System.out.println("");

        System.out.println("Transversal");
        System.out.println(pino.LevelOrder());

        System.out.println("Último nivel:");
        System.out.println(pino.LastLevel());
        //System.out.println(pino.Search(88));

        System.out.println("\n\nGRAFOS:");

        System.out.println("1. Retornar la ruta que permite visitar todos sus nodos: \n");
        Graph g69 = new Graph(4);
        g69.addEdge(0, 1);
        g69.addEdge(0, 2);
        g69.addEdge(0, 3);
        g69.addEdge(1, 0);
        g69.addEdge(2, 0);
        g69.addEdge(3, 0);
        System.out.println("[[1,2,3],[0],[0],[0]]");
        System.out.println("Recorrido:");
        g69.GraphPath();
        //punto 2:
        //[[false, true,  false, false],
        //[false, false, true,  false],
        //[true,  false, false, true ],
        //[false, false, true,  false]]
        System.out.println("\n\nMatriz");
        System.out.println("[[false, true,  false, false],");
        System.out.println("[false, false, true,  false],");
        System.out.println("[true,  false, false, true ],");
        System.out.println("[false, false, true,  false]]");
        g69 = new Graph(4);
        g69.addEdge(0, 1);
        g69.addEdge(1, 2);
        g69.addEdge(2, 0);
        g69.addEdge(2, 3);
        g69.addEdge(3, 2);
        System.out.println("\n2. Determinar si cada nodo tiene el mismo número de entradas y salidas: ");
        System.out.println(g69.SameInputsAndOutputs());
        System.out.println("\n3.Retornar los arcos faltantes para conectar todos los nodos: \n");
        System.out.println("Arcos");
        System.out.println("[[5,3],  [4,0],  [0,1],  [6,5],  [3,4],  [0,3],  [2,0],  [2,1],  [2,6], "
                + "\n [5,1],  [3,2],  [0,5],  [1,3],  [1,4],  [6,3]]\n");
        g69 = new Graph(7);
        g69.addEdge(5, 3);
        g69.addEdge(4, 0);
        g69.addEdge(0, 1);
        g69.addEdge(6, 5);
        g69.addEdge(3, 4);
        g69.addEdge(0, 3);
        g69.addEdge(2, 0);
        g69.addEdge(2, 1);
        g69.addEdge(2, 6);
        g69.addEdge(5, 1);
        g69.addEdge(3, 2);
        g69.addEdge(0, 5);
        g69.addEdge(1, 3);
        g69.addEdge(1, 4);
        g69.addEdge(6, 3);
        System.out.println("Arcos faltantes");
        g69.MissingArcs();

        System.out.println("Profe perdóname las 22 horas"
                + "de retraso, calificame el taller plis :'v");
    }

}
