/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author samaniw
 */
public class Graph {

    private boolean aMatrix[][];
    private int totalNodes;
    private LinkedList<Integer> aList[];
    ArrayList<String> visited=new ArrayList<>();

    public Graph(int n) {
        totalNodes = n;
        aMatrix = new boolean[n][n];
        aList = new LinkedList[n];
        for (int i = 0; i < totalNodes; i++) {
            aList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        aMatrix[source][destination] = true;
        aList[source].add(destination);
    }

    public void deleteEdge(int source, int destination) {
        aMatrix[source][destination] = false;
        aList[source].remove((Object)destination);
    }

    public String showAMatrix() {
        String Table = "";

        for (int i = 0; i < totalNodes; i++) {
            for (int j = 0; j < totalNodes; j++) {
                Table += aMatrix[i][j] ? 1 : 0;
            }
            Table += "\n";
        }

        return Table;
    }

    public String showAList() {
        String List = "";
        for (int i = 0; i < totalNodes; i++) {
            List += i + ": ";
            for (Integer v : aList[i]) {
                List += v + " ";
            }
            List += "\n";
        }
        return List;
    }
    
    /*1. Para un grafo de N nodos conectados bidireccionalmente,
    retornar la ruta que permite visitar todos sus nodos. Se puede 
    empezar y finalizar en cualquier nodoy visitarlos múltiples veces.*/
    
    public void GraphPath(){
        GraphPath(0);
    }
    private void GraphPath(int source){
        if(visited.size()!=aList.length){
        visited.add(source+"");
        System.out.print(source+" - ");
          for(int neighbour:aList[source]){
             if(!visited.contains(neighbour+"")){
                    GraphPath(neighbour);
                    System.out.print(source+" - ");
                }
            }
        }
    }
    
    
    /*2. Para una matriz de adyacencias de un grafo, determinar si cada nodo 
    tiene el mismo número de entradas y salidas.*/
    public boolean SameInputsAndOutputs(){
        int a=0,b=0;
        for (int i = 0; i < totalNodes; i++) {
            for (int j = 0; j < totalNodes; j++) {
                if(aMatrix[i][j]){
                    a++;
                }
            }
            for (int j = 0; j < totalNodes; j++) {
                if(aMatrix[j][i]){
                    b++;
                }
            }
            if(!(a==b)){
                return false;
            }
        }
        return true;
    }
    
    /*3. Dada una cantidad de nodos y una lista de arcos, 
    retornar los arcos faltantes para conectar todos los nodos.*/
    public void MissingArcs(){
        ArrayList<String> missed =new ArrayList<>();
        for (int i = 0; i < totalNodes; i++) {
            for (int j = i; j < totalNodes; j++) {
                boolean exists=false;
                for(int neighbours:aList[i]){
                    if((neighbours==j&&!aList[neighbours].contains(i))
                            ||(aList[j].contains(i))){
                        exists=true;
                    }
                }
                if(!exists&&i!=j){
                    missed.add("("+i+","+j+")");
                }
            }
        }
        for(String arc:missed){
            System.out.print(arc+" - ");
        }
    }

}
