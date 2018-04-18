package mordor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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

			for (int i = 0; i < q; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st3.nextToken());
				int end = Integer.parseInt(st3.nextToken());

				int max = 0, min = 100001;
				for (int k = start; k <= end; k++) {
					if(signs[k] > max) max = signs[k];
					if(signs[k] < min) min = signs[k];
				}
				System.out.println(max - min);
			}
		}
	}
}
