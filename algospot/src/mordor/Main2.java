package mordor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static int [] maxtree; 
	public static int [] mintree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());

		while (c-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int[] signs = new int[n];
			for (int i = 0; i < n; i++) {
				signs[i] = Integer.parseInt(st2.nextToken());
			}
			int h = (int) Math.ceil(log(n, 2));
			int tree_size = (1 << (h+1));
			
			maxtree = new int[tree_size];
			mintree = new int[tree_size];
			
			make_maxtree(signs, 1, 0, n-1);
			make_mintree(signs, 1, 0, n-1);
			
			for (int i = 0; i < q; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st3.nextToken());
				int end = Integer.parseInt(st3.nextToken());

				int max = find_max(1, 0, n-1, start, end);
				int min = find_min(1, 0, n-1, start, end);
				System.out.println(max - min);
			}
		}
	}
	public static double log(int x, int base) {
	    return (double) (Math.log(x) / Math.log(base));
	}
	public static int make_maxtree(int[] signs, int node, int start, int end) {
		if(start == end) {
			return maxtree[node] = signs[start];
		} else {
			return maxtree[node] = Math.max(make_maxtree(signs, node * 2, start, (start+end)/2), make_maxtree(signs, node*2+1, (start+end)/2+1, end));
		}
	}
	public static int find_max(int node, int start, int end, int left, int right) {
		if(right < start || end < left) {
			return Integer.MIN_VALUE;
		}
		if(left <= start && end <= right) {
			return maxtree[node];
		}
		return Math.max(find_max(node*2, start, (start+end)/2, left, right), find_max(node*2+1, (start+end)/2+1, end, left, right));
	}
	public static int make_mintree(int[] signs, int node, int start, int end) {
		if(start == end) {
			return mintree[node] = signs[start];
		} else {
			return mintree[node] = Math.min(make_mintree(signs, node * 2, start, (start+end)/2), make_mintree(signs, node*2+1, (start+end)/2+1, end));
		}
	}
	public static int find_min(int node, int start, int end, int left, int right) {
		if(right < start || end < left) {
			return Integer.MAX_VALUE;
		}
		if(left <= start && end <= right) {
			return mintree[node];
		}
		return Math.min(find_min(node*2, start, (start+end)/2, left, right), find_min(node*2+1, (start+end)/2+1, end, left, right));
	}
}
