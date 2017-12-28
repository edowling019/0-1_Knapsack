// Evan Dowling
public class List {
	private NodeList first;
	
	public void List() {
		first = null;
	}
	
	public boolean isEmpty() {
		
		if(first == null) {
			return true;
		}

		return false;
	}
	
	public node remove() {
		NodeList temp = first;
		first = first.next;
		return temp.data;
	}
	
	public void add(node u) {
		
		node x = new node();
		
		x.bound = u.bound;
		x.level = u.level;
		x.profit = u.profit;
		x.weight = u.weight;
		
		NodeList newNode = new NodeList(x);
		
		NodeList trav = null;
		NodeList trav2 = first;
		
		while(trav2!=null && trav2.data.bound > x.bound) {
			trav = trav2;
			trav2 = trav2.next;
		}
		if(trav == null) {
			newNode.next = first;
			first = newNode;
		}else {
			trav.next = newNode;
			newNode.next = trav2;
		}
		
		
	}
	
}
