
package binaryexpression;

import java.util.StringTokenizer;

/**
 * Represents the binary expression tree as discussed in class.
 * The BET accepts pre-fix expressions as input, stores that data
 * into a tree, then outputs the numerical answer to the expression.
 * @author Todd A Qualiano
 */
public class BET {

    Node root;
	private boolean success;

    /**
     * Inner Node class. Nodes have a left and a right child and
     * store a String as a data variable.
     */
    private class Node {

        Node left, right;
        String data;

        private Node() {
            this(null, null, null);
        }

        private Node(String e) {
            this(e, null, null);
        }

        private Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
	
    public void add(String s) {
        Node newNode = new Node(s);
        success = false;
        if (root == null) {
            root = newNode;
        } else {
            findOpenSpot(root, newNode);
        }
    }

    private void findOpenSpot(Node curr, Node add) {
        if (curr.left == null) {
            curr.left = add;
            success = true;
        } else if (isOperator(curr.left.data)) {
            findOpenSpot(curr.left, add);
        }
        
        if (curr.right == null && !success) {
            curr.right = add;
            success = true;
        } else if (!success && isOperator(curr.right.data)) {
            findOpenSpot(curr.right, add);
        }

    }
    
    private int evaluate(Node curr){
        
        if(isOperator(curr.data)){
            switch(curr.data){
                case "/":
                    return evaluate(curr.left) / evaluate(curr.right);
                case "+":
                    return evaluate(curr.left) + evaluate(curr.right);
                case "*":
                    return evaluate(curr.left) * evaluate(curr.right);
                case "-":
                    return evaluate(curr.left) - evaluate(curr.right);
                default:
                    System.out.println("error in evaluate");
                    return 0;
            }
        } else{
            return Integer.parseInt(curr.data);
        }
        
    }
    
   

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static void main(String[] args) {
        BET bet = new BET();
        String test = "/ + 8 4 - 6 2";
        System.out.println("Evaluating " + test);
        StringTokenizer tokens = new StringTokenizer(test);
        while (tokens.hasMoreTokens()) {
            String temp = tokens.nextToken();
            bet.add(temp);
        }
        
        System.out.print("Result: ");
        System.out.println(bet.evaluate(bet.root));
        
        BET bet1 = new BET();
        String test1 = "+ * 4 1 * 2 1";
        System.out.println("Evaluating " + test1);
        StringTokenizer tokens1 = new StringTokenizer(test1);
        while (tokens1.hasMoreTokens()) {
            String temp = tokens1.nextToken();
            bet1.add(temp);
        }
        
        System.out.print("Result: ");
        System.out.println(bet1.evaluate(bet1.root));
        
        BET bet2 = new BET();
        String test2 = "- * + 8 4 - 6 3 5";
        System.out.println("Evaluating " + test2);
        StringTokenizer tokens2 = new StringTokenizer(test2);
        while (tokens2.hasMoreTokens()) {
            String temp = tokens2.nextToken();
            bet2.add(temp);
        }
        
        System.out.print("Result: ");
        System.out.println(bet2.evaluate(bet2.root));
        
        BET bet3 = new BET();
        String test3 = "+ / 8 4 - 6 2";
        System.out.println("Evaluating " + test3);
        StringTokenizer tokens3 = new StringTokenizer(test3);
        while (tokens3.hasMoreTokens()) {
            String temp3 = tokens3.nextToken();
            bet3.add(temp3);
        }
        
        System.out.print("Result: ");
        System.out.println(bet3.evaluate(bet3.root));
        
    }
}

/*
run:
Evaluating / + 8 4 - 6 2
Result: 3
Evaluating + * 4 1 * 2 1
Result: 6
Evaluating - * + 8 4 - 6 3 5
Result: 31
Evaluating + / 8 4 - 6 2
Result: 6
BUILD SUCCESSFUL (total time: 0 seconds)

*/