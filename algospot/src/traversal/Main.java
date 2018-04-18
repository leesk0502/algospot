package traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode(int value){
			this.value = value;
		}
	}
	public static int[] postorder;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		while(c-- > 0){
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int[] preorder = new int[n];
			int[] inorder = new int[n];
			int[] postorder = new int[n];
			for(int i=0; i<n; i++) {
				preorder[i++] = Integer.parseInt(st.nextToken());
				inorder[i++] = Integer.parseInt(st2.nextToken());
			}
			make_post(preorder, inorder);
		}
	}
	
	public static void make_post(int []preorder, int []inorder) {
		
	}
}