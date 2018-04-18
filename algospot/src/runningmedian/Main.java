package runningmedian;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static class Heap {
		int[] heap;
		int size;
		boolean isMaxHeap;

		Heap(int n, boolean isMaxHeap) {
			this.isMaxHeap = isMaxHeap;
			heap = new int[n + 1];
			Arrays.fill(heap, 0);
		}

		void insert(int data) {
			size++;
			int index = size;
			heap[index] = data;
			while (size > 1) {
				int parent = index / 2;
				if ((isMaxHeap && heap[index] > heap[parent]) || (!isMaxHeap && heap[index] < heap[parent])) {
					int temp = heap[index];
					heap[index] = heap[parent];
					heap[parent] = temp;
					index /= 2;
				} else {
					break;
				}
			}
		}

		int pop() {
			int root = heap[1];
			int index = 1;
			heap[index] = heap[size];
			heap[size--] = 0;

			while (index < size) {
				if (isMaxHeap && heap[index * 2] < heap[index * 2 + 1]) {
					int temp = heap[index * 2 + 1];
					heap[index * 2 + 1] = heap[index];
					heap[index] = temp;
					index = index * 2 + 1;
				} else {
					int temp = heap[index * 2];
					heap[index * 2] = heap[index];
					heap[index] = temp;
					index = index * 2;
				}
			}
			return root;
		}

		int getSize() {
			return size;
		}

		int top() {
			if (heap[1] > 0)
				return heap[1];
			return 0;
		}
		
		void print() {
			for(int i=0; i<size+1; i++) {
				System.out.print(heap[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());

		while (c-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] list = new int[n];
			list[0] = 1983;
			for (int i = 1; i < n; i++) {
				list[i] = (list[i - 1] * a + b) % 20090711;
			}

			Heap maxHeap = new Heap(n, true);
			Heap minHeap = new Heap(n, false);
			int median = list[0];
			int result = median;
			maxHeap.insert(list[0]);
			for (int i = 1; i < n; i++) {
				int data = list[i];
				if (data < median) {
					maxHeap.insert(data);
				} else {
					minHeap.insert(data);
				}
				System.out.print("Maxheap : ");
				maxHeap.print();
				System.out.print("Minheap : ");
				minHeap.print();
				if (maxHeap.getSize() > minHeap.getSize()) {
					int temp = maxHeap.pop();
					minHeap.insert(temp);
					median = maxHeap.top();
				} else {
					int temp = minHeap.pop();
					maxHeap.insert(temp);
					median = 
				}
				System.out.println("Median : " + median + " ");
				result += median;
			}
			System.out.println(result);
		}
	}
}
