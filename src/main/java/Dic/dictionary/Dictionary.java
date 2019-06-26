package Dic.dictionary;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
// Import the HashMap class
import java.util.HashMap;

class Dictionary implements Serializable{
	
	HashMap<String,String> hm;

	public HashMap<String, String> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, String> hm) {
		this.hm = hm;
	}
	
	
	public Dictionary() {
		super();
		this.hm = new HashMap<String,String>();;
	}
	
	public Dictionary(HashMap<String, String> hm) {
		super();
		this.hm = hm;
	}

	public void add(String key, String value) {
		
		hm.put(key,value);
	}

	public String search(String key) throws Exception {
		if(hm.containsKey(key))
		return hm.get(key);
		else
			throw new Exception("The Word is not found");
	}
	
	public void delete(String key) {
		if(hm.containsKey(key))
			hm.remove(key);
	}
	
	public static Dictionary readFile() {
		File tmpDir = new File("d:\\dic.txt");
		
		boolean exists = tmpDir.exists();
		if(!exists)
			return null;
		FileInputStream file;
		Dictionary d = null;
		try {
			file = new FileInputStream("d:\\dic.txt");
			ObjectInputStream in = new ObjectInputStream(file); 
			d = (Dictionary)in.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
        
		return d;
	}
	
	
	public static void save(Dictionary d) {
		  
        // Serialization  
		FileOutputStream file;
		
        try
        {    
            //Saving of object in a file 
            file = new FileOutputStream("d:\\dic.txt"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(d); 
            out.close(); 
            file.close(); 
             
        }  
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
  
	}
	
	
}