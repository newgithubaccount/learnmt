package SampleCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TaxPerson {
	//method to read list of all luxury items from a luxury.properties file 
	public List<Object> getLuxuryList()
	{
		Properties prop = new Properties();
		InputStream input = null;
		List<Object> items=new ArrayList<>();
	
		try {
			 
			input = new FileInputStream("C:/Users/mansi/workspace/learnmt/src/SampleCode/luxury.properties");
	 		// load a properties file
			prop.load(input);
			int totalcount=getNumberOfLines("C:/Users/mansi/workspace/learnmt/src/SampleCode/luxury.properties");
			for(int i=1;i<totalcount;++i)
			{
				items.add(prop.getProperty("value"+i));
			}
			System.out.println(items);
			
			} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	
		}
		}
		return items;
	}
	//method to read list of all necessary items from a necessary.properties file
	public List<Object> getNecessaryList()
	{
		Properties prop = new Properties();
		InputStream input = null;
		List<Object> items=new ArrayList<>();
	
		try {
			 
			input = new FileInputStream("C:/Users/mansi/workspace/learnmt/src/SampleCode/necessary.properties");
	 		// load a properties file
			prop.load(input);
			int totalcount=getNumberOfLines("C:/Users/mansi/workspace/learnmt/src/SampleCode/necessary.properties");
			for(int i=1;i<totalcount;++i)
			{
				items.add(prop.getProperty("value"+i));
			}
			
			} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	
		}
		}
		return items;
	}
	//method to get number of items in propertyfile
	public int getNumberOfLines(String fileLocation)
	{	 int linenumber = 0;
		try{
			 
    		File file =new File(fileLocation);
 
    		if(file.exists()){
 
    		    FileReader fr = new FileReader(file);
    		    LineNumberReader lnr = new LineNumberReader(fr); 
    		    
    	            while (lnr.readLine() != null){
    	        	linenumber++;
    	            } 
    	            System.out.println("Total number of lines : " + linenumber);
     	            lnr.close();
     		}else{
    			 System.out.println("File does not exists!");
    		}
 
    	}catch(IOException e){
    		e.printStackTrace();
    	}
		return linenumber;
    }
//method to find out total cost basing on the type and cost
	public long calculateTax(String type,long cost)
	{
		long totalCost=cost,tax=0;
		if(type.equalsIgnoreCase("necessary"))
			tax=(cost*1)/100;
		else if(type.equalsIgnoreCase("luxury"))
			tax=(cost*9)/100;
		totalCost=totalCost+tax;		
		return totalCost;
	}
	//method to get the type basing on the given item
	public String getType(String item)
	{	String type=null;
		List<Object> necessary=getNecessaryList();
		List<Object> luxury=getLuxuryList();
		if(necessary.contains(item))
			type="necessary";
		else if(luxury.contains(item))
			type="luxury";
		return type;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long totalCost=0;
		TaxPerson taxPerson=new TaxPerson();
		String type=taxPerson.getType("ac");
		System.out.println(type);
		totalCost=taxPerson.calculateTax(type, 10054);
		System.out.println("total cost assossiated was    "+totalCost);	

	}

}
