// Evan Dowling


public class main {
	// varibale to count nodes
	static int nodecount = 1;

	public static void main(String[] args) {

		// input to the program
		int n = 4;
		int p[] ={20,30,10, 40};
		int w[] = {2,6,2,9};
		int W = 12;
		int maxprofit = 0;
		// call to the algorithm
		maxprofit = knapsack3(n,p,w,W, maxprofit);

		// output nodes and the max profit
		System.out.println(nodecount);
		System.out.println(maxprofit);

	}

	static int knapsack3(int n, int p[], int w[], int W, int maxprofit){

		Priority_Queue_Of_Nodes PQ = new Priority_Queue_Of_Nodes();
		node u = new node(), v = new node();
		
		v.level  = 0; 
		v.profit = 0; 
		v.weight = 0;
		maxprofit = 0;
		v.bound = bound(v, W, w, p, n);
		PQ.add(v);

		while(!PQ.isEmpty()) {
			 v = PQ.remove();
			 u = new node();

			if(v.bound > maxprofit) {
				u.level = v.level+1;
				u.weight = v.weight +w[u.level-1];
				u.profit = v.profit +p[u.level-1];
				
				if(u.weight <= W && u.profit > maxprofit) {
					maxprofit = u.profit;
				}
				
				
				u.bound = bound(u, W, w, p , n);
				nodecount++;
				if(u.bound > maxprofit) {
					PQ.add(u);
				
				}
				u.weight = v.weight;
				u.profit = v.profit;
				u.bound = bound(u, W, w, p , n);
				nodecount++;
				if(u.bound > maxprofit) {
					PQ.add(u);
					
				}
			}	
		}	
		
		return maxprofit;

	}

	static float bound(node u, int W, int w[], int p[], int n) {

		int j, k;
		int totweight;
		float result;

		if(u.weight >= W) {
			return 0;
		}
		else {
			result = u.profit;
			j = u.level +1;
			totweight = u.weight;
			while(j<= n && (totweight +w[j-1]) <= W) {
				totweight = totweight +w[j-1];
				result = result + p[j-1];
				j++;
			}
			k = j;
			if(k<= n) {
				result = result +(W - totweight) * (p[k-1]/w[k-1]);
			}
			return result;
		}
	}

}
