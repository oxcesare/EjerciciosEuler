/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CursoXML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;



/**
 *
 * @author cesar_ar
 * 
 * Ejemplo para leer un archivo XML
 * 
 * Todos estos ejercicios forman parte de  DOM Parser
 */
public class QueryXmlFileDemo {
    
    
     public static void main(String argv[]) {
 
      try {
         File inputFile = new File("C:\\Users\\cesar_ar\\Documents\\NetBeansProjects\\ProyectoEuler\\src\\CursoXML\\nuevo3.txt");
         DocumentBuilderFactory dbFactory = 
            DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.print("Root element: ");
         System.out.println(doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("supercars");
         System.out.println("----------------------------");
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :");
            System.out.print(nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.print("company : ");
               System.out.println(eElement.getAttribute("company"));
               NodeList carNameList = 
                  eElement.getElementsByTagName("carname");
               for (int count = 0; 
                  count < carNameList.getLength(); count++) {	 
                  Node node1 = carNameList.item(count);
                  if (node1.getNodeType() ==
                     node1.ELEMENT_NODE) {
                     Element car = (Element) node1;
                     System.out.print("car name : ");
                     System.out.println(car.getTextContent());
                     System.out.print("car type : ");
                     System.out.println(car.getAttribute("type"));
                  }
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
    
}
