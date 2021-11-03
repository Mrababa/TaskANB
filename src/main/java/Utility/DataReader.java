package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.w3c.dom.*;
import org.xml.sax.SAXException;



import javax.xml.parsers.*;
import java.io.*;

public class DataReader {
	public static Properties obj = new Properties();

	public static FileInputStream objfile;

	

	public String getElement(String ElementName, String Page)
			throws IOException, ParserConfigurationException, SAXException {

//		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Objects.properties");
//		obj.load(objfile);
//		fXmlFile = null;
		String returnedValue= "";
		Element eElement;

		DocumentBuilderFactory dBfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dBfactory.newDocumentBuilder();
		// Fetch XML File
		Document document = builder
				.parse(new File("/Users/maenrababa/git/cucumber-extent/src/test/resources/Objects.xml"));
		
		
		document.getDocumentElement().normalize();
		// Get root node
		
		Element ele = document.getDocumentElement();
		NodeList parentList = ele.getElementsByTagName("Page");
		for (int i = 0; i < parentList.getLength(); i++) {
			Node parentNode = parentList.item(i);
			if (parentNode.getAttributes() != null && parentNode.getAttributes().getNamedItem("Pgname") != null
					&& parentNode.getAttributes().getNamedItem("Pgname").getNodeValue()
							.equalsIgnoreCase(Page)) {
				NodeList nList = parentNode.getChildNodes();
				document.getDocumentElement().normalize();

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						eElement = (Element) nNode;
						String value = eElement.getAttribute("objname");
						
						if (value.equalsIgnoreCase(ElementName)) {

							
							returnedValue=	eElement.getAttribute("locator").toString().trim();

							break;
						}

					}
				}

		
		
			}
		}
return returnedValue;
	}
	}
		
		// Get all students
		
//		NodeList nList = document.getElementsByTagName("Page");
//		System.out.println(".................................");
//
//		for (int i = 0; i < nList.getLength(); i++)
//		{
//			Node node = nList.item(i);
//			System.out.println();    //Just a separator
//			if (node.getNodeType() == Node.ELEMENT_NODE)
//			{
//				//Print each student's detail
//				Element element = (Element) node;
//				
//				while (element.getNextSibling()!=null) {
//				System.out.println("Name : "  + element.getElementsByTagName("element").item(0).getTextContent());
//				
//			}
//			
//		}
	
	
		

		

		
