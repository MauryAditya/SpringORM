package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entyties.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
       ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
       StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//       Student student=new Student(1111,"Ritu Patel", "GKP");
//       int insert = studentDao.insert(student);
//       System.out.println( "Hello World!" +insert);
       
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       boolean go=true;
      while(go) {
    	  System.out.println( "press 1 for add new student");
          System.out.println( "press 2 for display all student");
          System.out.println( "press 3 for detail  of single student");
          System.out.println( "press 4 for deletw a student");
          System.out.println( "press 5 for update  student");
          System.out.println( "press 6 for exit");
          try{
        	  int input = Integer.parseInt(br.readLine());
        	  
//        	  if(input==1) {
//        		  //add new student
//        	  }else if(input==2) {
//        		// display all student  
//        	  }else if(input==3) {
//        		  //detail  of single student
//        	  }else if(input==4) {
//        		  //deletw a student
//				
//			}else if(input==5) {
//				// update  student
//			}
//			else if(input==6) {
//				// exit
//			}
        	  
        	  switch (input) {
			    case 1:
			    	//  //add new student
			    	 System.out.println("enter the id:");
			    	int sId = Integer.parseInt( br.readLine());
			    	System.out.println("enter the name:");
			    	String sname=br.readLine();
			    	System.out.println("enter the city:");
			    	String scity=br.readLine();
			    	
			    	Student s=new Student();
			    	s.setId(sId);
			    	s.setName(sname);
			    	s.setCity(scity);
			    	//saving student object into databaseby calling insert method
			    	int insert = studentDao.insert(s);
			    	 System.out.println("added" +insert);
			    	 System.out.println("**********************************************");	
				break;
				
				case 2:
					//diplay all
					List<Student> all=studentDao.getAllStudents();
					for(Student st:all) {
						 System.out.println("**********************************************");
						 System.out.println("name"+st.getId());	
						 System.out.println("name"+st.getName());	
						 System.out.println("name"+st.getCity());	
						 System.out.println("**********************************************");
					}
				break;
				case 3:
					 System.out.println("enter the id:");
				    	int uId = Integer.parseInt( br.readLine());
				    	Student student = studentDao.getStudent(uId);
				    	 System.out.println("**********************************************");
						 System.out.println("name"+student.getId());	
						 System.out.println("name"+student.getName());	
						 System.out.println("name"+student.getCity());	
						 System.out.println("**********************************************");
				break;
				case 4:
					 System.out.println("enter the id:");
				    	int Id = Integer.parseInt( br.readLine());
				    	studentDao.getStudent(Id);
				    	System.out.println("Student deleted");
				break;
				case 5:
				break;
				case 6:
				go=false;
				break;
				
			
			}
        	  
          }catch(Exception e) {
        	  System.out.println("invalid input try another");
        	  System.out.println(e.getMessage());
          }
      }
}
}
