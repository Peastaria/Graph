import Graph.*;
import java.util.*;

public interface Command{

	public Graph execute();
	
	public void setGraph(Graph graph);
	
}