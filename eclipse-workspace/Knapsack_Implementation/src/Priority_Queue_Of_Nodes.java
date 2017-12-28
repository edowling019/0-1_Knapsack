// Evan Dowling

public class Priority_Queue_Of_Nodes {
	List list;
	
	public Priority_Queue_Of_Nodes() {
		list = new List();
		
	}
	public void add(node u) {
		list.add(u);
		
	}
	public node remove() {
		
		return list.remove();
	}
	public boolean isEmpty() {
		
		return list.isEmpty();
		
	}

}
