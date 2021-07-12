package firstProject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class FileMain {

	public static void main(String[] args) {
		boolean toggle = true;
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~                                  ~");
		System.out.println("Welcome to your file system manager.");
		System.out.println("~                                  ~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Scanner inputDir = new Scanner(System.in);
		System.out.println("Enter name to create a new directory for your files: ");
		System.out.println("Please keep it short.  ");
		//User input will be their directory name
	    String path = inputDir.next();
	    File file = new File(path);
	    boolean bool = file.mkdir();
	    if(bool){
	        System.out.println(path + " Directory created successfully");
	     }else{
	        System.out.println("Sorry couldn’t create specified directory");
	     }
	      
		while(toggle) {
		 Scanner input = new Scanner(System.in);
			prompt1();
			int value = input.nextInt();
			switch(value){
			  case 1:
				  list(path);
			    break;
			  case 2:
				  prompt2();
				   value = input.nextInt();
				   switch(value) {
					  case 1:
						  create(path);
					    break;
					  case 2:
						  delete(path);
						  break;
					  case 3:
						  search(path);
						  break;
					  case 4:
						  break; 
						  default:
							System.out.println("Please enter a valid number.");
							break;
				   }
			    break;
			  case 3:
				  toggle=false;
				  inputDir.close();
				  input.close();
				    break;
			  default:
				  System.out.println("Please enter a valid number.");
				  break;
			}	
		}
		}
		public static void prompt1() {	
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("^                           ^");
			System.out.println("Which option do you choose?");
			System.out.println("Enter 1 to list files in directory.");
			System.out.println("Enter 2 to add, delete or search for files.");
			System.out.println("Enter 3 to exit program.");
			System.out.println("^                           ^");
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		}
		public static void prompt2() {
			System.out.println("*****************************");
			System.out.println("*                           *");
			System.out.println("Which option do you choose?");
			System.out.println("----------------------");
			System.out.println("Enter 1 to add a file.");
			System.out.println("Enter 2 to delete a file.");
			System.out.println("Enter 3 to search a file.");
			System.out.println("Enter 4 to return to the previous menu.");
			System.out.println("*                           *");
			System.out.println("*****************************");
		}
		public static void create(String path) {
			System.out.println("Enter name of file to create?");   
			Scanner input = new Scanner(System.in);
			String path1 = input.next(); 
			try {
			      File myObj = new File(path+"/"+path1+".txt");
			      if (myObj.createNewFile()) {
			        System.out.println("Successfully created file: " + myObj.getName());
			      } else {
			        System.out.println("Sorry, file name already exists.");
			      }
			    } catch (IOException e) {
			      System.out.println("Sorry, an error occured.");
			      e.printStackTrace();
			    }
		}
		public static void delete(String dir) {
			System.out.println("Enter name of file you want to delete?");   
			Scanner input = new Scanner(System.in);
			String path = input.next(); 
			File selectedFile = new File(dir+"/"+path+".txt");
			  if (selectedFile.delete()) {
			    System.out.println("File has been deleted: ");
			  } else {
			    System.out.println("File not found.");
			  }
		}
		public static void search(String dir) {
			System.out.println("Enter a file name to search for without the .txt. ");   
			Scanner input = new Scanner(System.in);
			String path = input.next(); 
			File fileToSearch = new File(dir+"/"+path+".txt");
			  if (fileToSearch.exists()) {
			    System.out.println("File exists: ");
			  } else {
				  System.out.println("#######");
			    System.out.println("File not found.");
			      System.out.println("#######");
			  }
	    }
		public static void list(String path) {
			File directory = new File(path);
		      String[] folder = directory.list();
		      System.out.println("List of files in the directory:");
		      System.out.println(" ");
		      if(folder.length<1) {
		    	  System.out.println("#######");
		    	  System.out.println("No files in directory");
		    	  System.out.println("#######");
		    	  
		      }else {
		    	  for(String file : folder) {
		    		  System.out.println("File name: "+file);
		          }
		      }
		}
}
