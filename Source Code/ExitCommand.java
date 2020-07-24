import Graph.*;
import java.util.*;

public class ExitCommand implements Command{

	public Graph execute()
	{
		System.out.println("-- End --");
		System.exit(0);
		return null;
	}
	
	public void setGraph(Graph graph){}
	
}