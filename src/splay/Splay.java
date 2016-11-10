/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splay;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author tomas
 */
public class Splay {

    private Node root;
    Stack<Node> cesta;

    public void add(Node paNode) {
        cesta = new Stack<Node>();
        if (root == null) {
            root = paNode;
        }

        Node actual = root;
        //  cesta.push(actual);
        while (true) {  //proces prejdenia stromu az k listu a pridanie prvku

            if (actual.getData().compare(paNode) == -1) { //ak vkladany prvok je mensi ako aktualny
                if (actual.getLeft() == null) {     //ak sa nachadza v liste prvok sa prida                   
                    actual.setLeft(paNode);
                    cesta.push(actual);
                    this.splay(paNode);
                    break;
                } else {                           //ak sa nenachadyame v liste pokracuje dalej     
                    cesta.push(actual);
                    actual = actual.getLeft();
                }

            } else if (actual.getData().compare(paNode) == 1) {      //ak vkladany prvok je vacsi ako aktualny
                if (actual.getRight() == null) {        //ak sa nachadza v liste prvok sa prida                  
                    actual.setRight(paNode);
                    cesta.push(actual);
                    this.splay(paNode);
                    break;
                } else {                                //ak sa este nenachadza v liste, nastavi sa novy aktualny vrchol a pokracuje sa dalej    
                    cesta.push(actual);
                    actual = actual.getRight();
                }
            } else {
                
                break;
            }
        }
        // System.out.println(paNode.getData().toString() + " " + cesta);
    }

    public Node search(Node paNode) {
        Node actual = root;
        cesta = new Stack<>();

        while (true) {
            if (actual.getData().compare(paNode) == 0) {
                cesta.push(actual);
                this.splay(cesta.pop());

                return (Node) actual;
            }
            if (actual.getData().compare(paNode) == -1) {
                cesta.push(actual);                
                
                actual = actual.getLeft();

            } else if (actual.getData().compare(paNode) == 1) {
                cesta.push(actual); 
                actual = actual.getRight();
                
            }

            if (actual == null) {
                System.out.println("Nenasiel sa vrchol s klucom:" + paNode.toString());
                if (!cesta.empty()) {
                    splay(cesta.pop());//splay nad poslednym dosiahnuty vrchol
                }
                return null;
            }
        }

    }

    public boolean splay(Node paN) {
        Node otec;
        Node praotec;
        
        while (paN != root && paN != null) {
            otec = cesta.pop();
            if (otec == root) {
                if (paN == otec.getLeft()) {
                    this.setRoot(pravaRotacia(otec));
                }
                if (paN == otec.getRight()) {
                    this.setRoot(lavaRotacia(otec));
                }
            } else {
                praotec = cesta.pop();
                if (paN == otec.getLeft() && otec == praotec.getLeft()) {
                    if (praotec == root) {
                        this.setRoot(this.pravaRotacia(praotec));
                        this.setRoot(this.pravaRotacia(otec));
                    } else {
                        if (cesta.peek().getLeft() == praotec) {
                            cesta.peek().setLeft(this.pravaRotacia(praotec));
                            cesta.peek().setLeft(this.pravaRotacia(otec));
                        }
                        if (cesta.peek().getRight() == praotec) {
                            cesta.peek().setRight(this.pravaRotacia(praotec));
                            cesta.peek().setRight(this.pravaRotacia(otec));
                        }
                    }
                }

                if (paN == otec.getRight() && otec == praotec.getRight()) {
                    if (praotec == root) {

                        this.setRoot(this.lavaRotacia(praotec));
                        this.setRoot(this.lavaRotacia(otec));
                    } else {
                        if (cesta.peek().getLeft() == praotec) {
                            cesta.peek().setLeft(this.lavaRotacia(praotec));
                            cesta.peek().setLeft(this.lavaRotacia(otec));
                        }
                        if (cesta.peek().getRight() == praotec) {
                            cesta.peek().setRight(this.lavaRotacia(praotec));
                            cesta.peek().setRight(this.lavaRotacia(otec));
                        }
                    }
                }
                if (paN == otec.getLeft() && otec == praotec.getRight()) {

                    praotec.setRight(this.pravaRotacia(otec));
                    if (praotec == root) {

                        this.setRoot(this.lavaRotacia(praotec));
                    } else {

                        if (cesta.peek().getLeft() == praotec) {
                            cesta.peek().setLeft(lavaRotacia(praotec));
                        }
                        if (cesta.peek().getRight() == praotec) {
                            cesta.peek().setRight(lavaRotacia(praotec));
                        }
                    }
                }
                if (paN == otec.getRight() && otec == praotec.getLeft()) {
                    praotec.setLeft(this.lavaRotacia(otec));
                    if (praotec == root) {
                        //System.out.println("Lavo prava - root");
                        this.setRoot(this.pravaRotacia(praotec));
                    } else {
                        //System.out.println("Lavo Prava -");
                        if (cesta.peek().getLeft() == praotec) {
                            cesta.peek().setLeft(pravaRotacia(praotec));
                        }
                        if (cesta.peek().getRight() == praotec) {
                            cesta.peek().setRight(pravaRotacia(praotec));
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean delete(Node deleteNode) {
        Node actual = root;
        cesta = new Stack<>();
        if(root==null){            
            return false;
        }
        
        while (true) {
            if (actual.getData().compare(deleteNode) == 0) {
                //if (actual == root) {
                //cesta.push(actual);
                // }
                break;
            } else if (actual.getData().compare(deleteNode) == -1) {
                cesta.push(actual);
                actual = actual.getLeft();
            } else if (actual.getData().compare(deleteNode) == 1) {
                cesta.push(actual);
                actual = actual.getRight();
            }
            if (actual == null) {
                cesta.clear();
                break;
            }
        }
        if (cesta.isEmpty() && actual != root) {
            System.out.println("Vrchol neexituje");
            return false;
        }
       // System.out.println("DELETE  CETSA" + cesta);
        Node rodic = null;

        rodic = (actual == root) ? null : cesta.peek();

        if (actual.getPocetDeti() == 0) {
            if (actual == root) {
                this.setRoot(null);
            } else {
                if (rodic.getLeft() == actual) {
                    rodic.setLeft(null);
                } else {
                    rodic.setRight(null);
                }
            }
            //ak jedno dieta  
        } else if (actual.getPocetDeti() == 1) {

            if (actual != root) {
                if (rodic.getLeft() == actual) { //ak mazany vrchol je lavym synom, rodicovi sa prenastavy lavy syn inak pravy
                    if (actual.getLeft() == null) {     //zistovanie ktory syn mazaneho vrhola sa priradi rodicu
                        rodic.setLeft(actual.getRight()); //rodicovi sa priradi lavy syn (pravy syn mazaneho vrchola)                        
                    } else {
                        rodic.setLeft(actual.getLeft());   // rodicovi sa priradi lavy syn (lavy syn mazaneho vrchola)                        
                    }
                } else if (actual.getLeft() == null) {  //pripad ked mazany brchol je pravym synom rodica
                    rodic.setRight(actual.getRight());  //rodicovu sa priradi pravy syn (pravy syn mazaneho vrchola)                    
                } else {
                    rodic.setRight(actual.getLeft());   //rodiovi sa priradi pravy syn (lavy syn mazaneho vrchola)                  
                }
            } else {//actual is root

                if (actual.getLeft() != null) {
                    this.setRoot(actual.getLeft());
                } else {
                    this.setRoot(actual.getRight());
                }
            }
            //ak 2 deti
        } else {
            Node min = actual.getRight();
            Node rodicMin = actual;  //pomocna  premena na ulozenie vrcholu ktory je rodicom minima     

            //Najdenie minima v Pravom podstrome
            while (min.getLeft() != null) {
                rodicMin = min;
                min = min.getLeft();
            }

            //mazanie VRCHOLA KTORY NIEJE KOREN A MA 2 DETI
            if (rodicMin.getLeft() == min) { //odstranenie odkazu na vrchol s min. hodnotou kluca (ktory pojde na miesto mazaneho)
                rodicMin.setLeft(min.getRight());
            } else {
                rodicMin.setRight(min.getRight());
                //rodicMin.setRight(null);//
            }

            if (actual != root) {

                min.setLeft(actual.getLeft());
                min.setRight(actual.getRight());

                if (cesta.peek().getLeft() == actual) {//samotne nahradenia mazaneho prvku minimom
                    cesta.peek().setLeft(min);
                } else {
                    cesta.peek().setRight(min);
                }
            } else {

                min.setLeft(root.getLeft());
                min.setRight(root.getRight());
                this.setRoot(min);
            }

        }
        //System.out.println("satva csty na konci metodz" + cesta);
        if (!cesta.empty()) {
            this.splay(cesta.pop());
        }
        return true;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node pravaRotacia(Node paNode) {
        Node pomNode;
        pomNode = paNode.getLeft();
        paNode.setLeft(paNode.getLeft().getRight());
        pomNode.setRight(paNode);

        return pomNode;
    }

    public Node lavaRotacia(Node paNode) {
        Node pomNode;
        pomNode = paNode.getRight();
        paNode.setRight(paNode.getRight().getLeft());
        pomNode.setLeft(paNode);
        return pomNode;
    }

    public String preOrderPrint() {
        String retaz = "";
        Stack<Node> naVypis = new Stack<Node>();
        Node pomNode;

        if (this.root == null) {
            return "Strom neobsahuje ziadny vrchol";
        } else {
            naVypis.push(root);
            while (!naVypis.empty()) {
                pomNode = naVypis.pop();
                retaz += pomNode.getData().toString() + "\n";
                if (pomNode.getRight() != null) {
                    naVypis.push(pomNode.getRight());
                }
                if (pomNode.getLeft() != null) {
                    naVypis.push(pomNode.getLeft());
                }
            }
        }

        return retaz;
    }

    public String InOrderPrint() {
        String retaz = "";
        Stack<Node> naVypis = new Stack<Node>();
        Node pomNode = root;
        while ((!naVypis.empty()) || (pomNode != null)) {
            if (pomNode != null) {
                naVypis.push(pomNode);
                pomNode = pomNode.getLeft(); //vlozi sa do stacku lavy syn
            } else {                        //ak neexistuje lavy syn resp. null vypis vrchol a chod vpravo
                pomNode = naVypis.pop();
                retaz += pomNode.getData().toString() + "\n";
                pomNode = pomNode.getRight();
            }
        }

        return retaz;
    }

    public String levelOrder() {
        String vypis = "";
        Queue<Node> naVypis = new LinkedList<Node>();
        Node pomNode;
        if (root != null) {
            naVypis.offer(root);
        }
        int pocet;
        while (!naVypis.isEmpty()) {
            pocet = naVypis.size();
            while (pocet > 0) {
                pomNode = naVypis.poll();
                vypis += pomNode.getData() + "  ";
                if (pomNode.getLeft() != null) {
                    naVypis.offer(pomNode.getLeft());
                }
                if (pomNode.getRight() != null) {
                    naVypis.offer(pomNode.getRight());
                }
                pocet--;
            }
            vypis += "\n";
        }
        return vypis;
    }

}
