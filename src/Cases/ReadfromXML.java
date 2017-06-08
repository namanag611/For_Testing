package Cases;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadfromXML {
	
	static int depthOfXML = 1;
	static int count;
	//@Test
	public void test() throws ParserConfigurationException, SAXException, IOException{

	File xmlread=new File("C:\\Users\\namanagrawal\\Desktop\\Automation\\testdata\\testdata.xml");
	 //creating object for DocumentBuilderFactory
	 DocumentBuilderFactory dbfocrory=DocumentBuilderFactory.newInstance();
	 
	 DocumentBuilder dBuilder=dbfocrory.newDocumentBuilder();
	 Document doc=dBuilder.parse(xmlread);
	 
	 NodeList lxml=doc.getChildNodes();
	 Node nxml=lxml.item(0);
	 Element element=(Element)nxml;
	 //get element by tagname
	 System.out.println(element.getElementsByTagName("vc_search_term").item(0).getTextContent());
	 
	 
	 
	 //Navigate to google from data retrived from xml
	 //WebDriver driver=new FirefoxDriver();
	 //driver.get(element.getElementsByTagName("APP_URL").item(0).getTextContent());
	 //driver.close();
	 
	 //-------------------
	 //Document document = dBuilder.parse("C:\\Users\\namanagrawal\\Desktop\\Automation\\testdata\\testdata.xml");
	 NodeList entities = doc.getElementsByTagName("EyeglassesWithLenses"); //List of all the entity nodes
	 int nchild; //Number of children
	 System.out.println("Number of EyeGlassesWithLenses: "+ entities.getLength()); //Prints 1 as expected
	 nchild=entities.item(0).getChildNodes().getLength(); 
	 System.out.println("Child: "+nchild);
	}
	
	@Test
	public void test2() throws ParserConfigurationException, SAXException, IOException{
		
		try
		{
		String filepath = "C:\\Users\\namanagrawal\\Desktop\\Automation\\testdata\\testdata.xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(filepath);

		Element elements = doc.getDocumentElement();

		int level = 1;
		System.out.println(elements.getNodeName() + "[" + level + "]");

		NodeList nodeList = elements.getChildNodes();
		printNode(nodeList, level);

		System.out.println("The deepest level is : " + depthOfXML);
		System.out.println("Level 2 node count is: "+ count);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void printNode(NodeList nodeList, int level) {
		level++;
		if (nodeList != null && nodeList.getLength() > 0) {

		  for (int i = 0; i < nodeList.getLength(); i++) {
			  
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				System.out.println(node.getNodeName() + "[" + level + "]");
				printNode(node.getChildNodes(), level);
				
				String level1=Integer.toString(level);
				
				if(level1.equalsIgnoreCase("2"))
				{
					count++;
				}
				
				// how depth is it?
				if (level > depthOfXML) {
					depthOfXML = level;
				}

			 }
			
			

		    }

		  }
	}
}
