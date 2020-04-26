/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.ArrayList;

/**
 *
 * @author samaniw
 */
public class BinarySearchTree {

    private BinaryNode root;
    private BinaryNode father;
    private boolean position;
    private ArrayList<String> levels;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int data) {
        root = new BinaryNode(data);
    }

    //Punto 1
    public void InOrden() {
        InOrden(root);
    }

    private void InOrden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            InOrden(currentRoot.getLeft());
            System.out.print(currentRoot.getData() + " ");
            InOrden(currentRoot.getRight());
        }
    }

    //Punto 2
    public void Postorden() {
        Postorden(root);
    }

    private void Postorden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            Postorden(currentRoot.getLeft());
            Postorden(currentRoot.getRight());
            System.out.print(currentRoot.getData() + " ");
        }
    }

    //Punto 3
    public void PreOrden() {
        PreOrden(root);
    }

    private void PreOrden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            System.out.print(currentRoot.getData() + " ");
            PreOrden(currentRoot.getLeft());
            PreOrden(currentRoot.getRight());
        }
    }

    //Punto 4
    public int CountNodes() {
        return CountNodes(root, 0);
    }

    private int CountNodes(BinaryNode currentRoot, int cont) {
        if (currentRoot != null) {
            cont++;
            cont = CountNodes(currentRoot.getLeft(), cont);
            cont = CountNodes(currentRoot.getRight(), cont);
        }
        return cont;
    }

    //Punto 5
    public int CountLeafs() {
        return CountLeafs(root, 0);
    }

    private int CountLeafs(BinaryNode currentRoot, int cont) {
        if (currentRoot != null) {
            if (currentRoot.isLeaf()) {
                cont++;
            } else {
                cont = CountLeafs(currentRoot.getLeft(), cont);
                cont = CountLeafs(currentRoot.getRight(), cont);
            }
        }
        return cont;
    }

    public void Add(int data) {
        if (root == null) {
            root = new BinaryNode(data);
        } else //validar si el dato ya existe
        {
            if (Search(data) != null) {
                System.out.println("Dato repetido, no se puede insertar");
            } else {
                Add(data, root);

            }
        }
    }

    private void Add(int data, BinaryNode currentRoot) {
        if (data < currentRoot.getData()) {
            if (currentRoot.getLeft() == null) {
                currentRoot.setLeft(new BinaryNode(data));
            } else {
                Add(data, currentRoot.getLeft());
            }

        } else if (currentRoot.getRight() == null) {
            currentRoot.setRight(new BinaryNode(data));
        } else {
            Add(data, currentRoot.getRight());
        }
    }

    public BinaryNode Search(int data) {
        return Search(data, root);
    }

    private BinaryNode Search(int data, BinaryNode currentRoot) {
        if (currentRoot == null) {
            return null;
        }
        if (data == currentRoot.getData()) {
            return currentRoot;
        }

        father = currentRoot;

        if (data < currentRoot.getData()) {
            position = false;
            return Search(data, currentRoot.getLeft());
        } else {
            position = true;
            return Search(data, currentRoot.getRight());
        }
    }

    //Punto 6
    public void Delete(int data) {
        if (root == null) {
            System.out.print("Árbol vacío");
        } else {
            Delete(data, root);
        }
    }

    private void Delete(int data, BinaryNode currentRoot) {

        BinaryNode v = Search(data);
        if (v == root) {
            BinaryNode minimum = getMinor(v.getRight());
            Delete(minimum.getData());
            v.setData(minimum.getData());
        } else if (v.isLeaf()) {
            if (position) {
                father.setRight(null);
            } else {
                father.setLeft(null);
            }
        } else if (v.hasOneChild()) {
            if (v.isChildPosition()) {
                if (v.getData() < father.getData()) {
                    father.setLeft(v.getRight());
                } else {
                    father.setRight(v.getRight());
                }
            } else {
                if (v.getData() < father.getData()) {
                    father.setLeft(v.getLeft());
                } else {
                    father.setRight(v.getLeft());
                }
            }
        } else {
            BinaryNode minimum = getMinor(v.getRight());
            Delete(minimum.getData());
            v.setData(minimum.getData());
        }
    }

    //Punto 7
    public int LastLevel() {
        levels = new ArrayList<>();
        LevelOrder(root, 0);
        return (levels.size() - 1);
    }

    //Punto 8
    public String LevelOrder() {
        levels = new ArrayList<>();
        LevelOrder(root, 0);
        String text = "";
        for (int i = 0; i < levels.size(); i++) {
            text += (levels.get(i));
            if (i < levels.size() - 1) {
                text += "\n";
            }
        }
        return text;
    }

    private void LevelOrder(BinaryNode pivot, int level) {
        if (pivot != null) {

            LevelOrder(pivot.getLeft(), level + 1);
            while (level > levels.size() - 1) {
                levels.add("");
            }
            levels.set(level, levels.get(level) + pivot.getData() + " ");
            //System.out.println(pivot.getData() + " Level: " + level);
            LevelOrder(pivot.getRight(), level + 1);
        }
    }

    public BinaryNode getMinor(BinaryNode currentRoot) {
        if (currentRoot.getLeft() == null) {
            return currentRoot;
        } else {
            return getMinor(currentRoot.getLeft());
        }
    }
}
