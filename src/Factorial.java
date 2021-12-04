/**
 * 
 * = preview of trees =
 * 
 *  - The tree is a fundamental structure in computer science.
 *  - Almost all operating systems stores files in trees or tree-like structures.
 *  - Tree are also used in compiler design, text processing, and searching algorithms.
 *  
 *  - One definition of the tree is recursive:
 *    
 *    - Either a tree is empty or it consists of a root and zero or more nonempty subtrees T1, T2, T3...Tk, each of whose roots are connected by an edge from the root.
 *      (The figure below)
 *    - In certain instances(most notably, the binary trees), we may allow some of the subtrees to be empty.  
 *      
 *      - A tree viewed recursively
 *        
 *          root
 *      /  /  \  \
 *     T1 T2  T3  T4
 *    
 *     
 *  - Nonrecursively, then, a tree consists of a set of nodes and a set of directed edges that connect pairs of nodes.
 *  - Throughout this text we consider only rooted trees.
 *  
 *  - A rooted tree has the following properties.   
 *  
 *    1.
 *    - One node is distinguished as the root.
 *    
 *    2.
 *    - Every node c, except the root, is connected by an edge from exactly one other node p.
 *    - Node p is c's parent, and c is one p's children.
 *    
 *    3.
 *    - A unique path traverses from the root to each node.
 *    - The number of edges that must be followed is the path length.
 *    
 *  - Parents and children are naturally defined.
 *  - A directed edge connects the parent to the child.
 *  
 *    A tree:
 *    
 *        
 *          A
 *      / /  \  \
 *     B  C   D   E
 *    /\      /   /\  
 *   F  G    H   I  J
 *                 /
 *                K
 *    
 *     - The root node is A:
 *     
 *       - A's children are B, C, D and E.
 *       - Because A is the root, it has no parent; all other nodes have parents.
 *       
 *         - For instance, B's parent is A.
 *         - The node that has no children is called a leaf.
 *         - The lead in this tree are C,F, G, H, I and K.
 *         
 *         - The length of the path from A to K is 3(edges); the length of the path from A to A is 0(edges).
 *         
 *           
 *  = factorials =
 *  
 *   - N! is the product of the first N integers.
 *   - Thus we can express N! as N times (N-1)!.
 *   - Combined with the base case 1! = 1, this information immediately provides all that we need for a recursive implementation.    
 * 
 *
 */
public class Factorial {
	
	// Recursive implementation of the factorial method
	// Evaluate n!
	public static long factorial(int n) {
		if(n <= 1) // base case
			return 1;
		else
			return n*factorial (n-1);
		
	}

	public static void main(String[] args) {
		
		System.out.println(factorial(10000));
		System.out.println(factorial(1000));
		System.out.println(factorial(100));
		System.out.println(factorial(50));
		System.out.println(factorial(40));
		System.out.println(factorial(30));
		
		System.out.println(factorial(20));
		System.out.println(factorial(10));
		System.out.println(factorial(5));
		System.out.println(factorial(3));
		System.out.println(factorial(1));
		System.out.println(factorial(0));


	}

}
