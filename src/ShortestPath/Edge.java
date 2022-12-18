package ShortestPath;

public class Edge {
	private int u;   
	//it is the destination vertex  
	private int v;   
	//it denotes the weight on edge  
	private int w;   
	 
	public int getU()   
	{  
	return u;  
	}  
	public void setU(int u)   
	{  
	this.u = u;  
	}  
	public int getV()   
	{  
	return v;  
	}  
	public void setV(int v)   
	{  
	this.v = v;  
	}  
	public int getW()   
	{  
	return w;  
	}  
	public void setW(int w)   
	{  
	this.w = w;  
	}  
	//creating constructor of the Edge class  
	public Edge(int u, int v, int w)   
	{  
	this.u = u;  
	this.v = v;  
	this.w = w;  
	}  
}
