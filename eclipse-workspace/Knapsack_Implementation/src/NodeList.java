// Evan Dowling
public class NodeList {
	
	public node data;
	public NodeList next;
	
	public NodeList(node u) {
		data = new node();
		data.bound=u.bound;
		data.level=u.level;
		data.profit=u.profit;
		data.weight=u.weight;
	}

}
