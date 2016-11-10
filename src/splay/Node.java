/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splay;


import core.IData;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author tomas
 */
public class Node {

    private IData data;
    private Node Left;
    private Node Right;
  

    
  
    public Node(IData data) {

        this.data = data;
    }

    public int getPocetDeti() {
        if (this.Left != null && this.Right != null) {
            return 2;
        } else if (this.Left != null || this.Right != null) {
            return 1;
        } else {
            return 0;
        }

    }

    public IData getData() {
        return data;
    }

    public void setData(IData data) {
        this.data = data;
    }

    public Node getLeft() {
        return Left;
    }

    public void setLeft(Node Left) {
        this.Left = Left;
    }

    public Node getRight() {
        return Right;
    }

    public void setRight(Node Right) {
        this.Right = Right;
    }

    public int vyskaVrch() {
        Queue<Node> front = new LinkedList<>();
        int vyska = 0;
        Node pomNode;

        if (this == null) {
            return 0;
        }
        front.offer(this);
        front.offer(null);

        while (!front.isEmpty()) {
            pomNode = front.poll();  //vrchol z fronty sa ulozi do premennej
            if (pomNode == null) {   
                vyska++;
                if (front.isEmpty()) {
                    break;
                }
                front.offer(null);      //ak front nieje prazdny preida sa null (odelenie urovni)

            } else {                    
                if (pomNode.getLeft() != null) {
                    front.offer(pomNode.getLeft());
                }
                if (pomNode.getRight() != null) {
                    front.offer(pomNode.getRight());
                }

            }

        }

        return vyska;
    }

    

    @Override
    public String toString() {
        return data.toString();
    }

    

  
    
}
