
public class Edge {
	private int from;
	private int to;
	private int length;
	
	public Edge(int from, int to, int length) {
		super();
		this.from = from;
		this.to = to;
		this.length = length;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public int getNeighbour(int index) {
		if(this.from == index) return this.to;
		else return this.from;
	}
}
