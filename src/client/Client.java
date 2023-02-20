/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;
//imported libaries
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import org.json.*;
import java.util.stream.Collectors;
/**
 *
 * @author david
 */
public class Client {
  static Scanner userInput = new Scanner(System.in);
  //Register function defined for user sign up  
    public static void register(){
      String Full_name = "";
      InputStreamReader isr = null;
      BufferedReader br = null;
      //streams to process user input
      isr = new InputStreamReader(System.in);
      br = new BufferedReader(isr);
      try {
        //prompts user to enter name
        System.out.print("\nPlease Enter your Full name: ");
         //reads in the full name from the command prompt
        Full_name = br.readLine();
        System.out.print("\nPlease Enter your PIN: ");
         //reads in the PIN from the command prompt
        int pin=userInput.nextInt();
        // section below calls the user ID from the orchestrator using Azure Tomcat
        URL url = new URL("http://20.2.85.48:8080/TravelBuddy/webresources/getUserID");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
// Get the response
BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
String response = in.readLine();
//function defined to store the user sign up info
connect(response,pin,Full_name);
System.out.println("\nWelcome "+ Full_name);
System.out.println(response+"-USER ID");
      } 
      catch(IOException e) {
        System.out.println("IO Exception ocuured " + e);
      } 
    }
    //Login function defined for user login
    public static void login(){
        //Declaration of variables
       int login_pin;
        Connection con;
        PreparedStatement pst = null;
        ResultSet rs;
        int q;
        //prompts user to enter PIN
        System.out.print("\nPlease Enter your PIN: ");
         //reads in the PIN from the command prompt
        login_pin=userInput.nextInt();
        try{
        //SQL database code for authentication of the inputed pin
Class.forName("com.mysql.cj.jdbc.Driver");
con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","service_centric");
pst= con.prepareStatement("SELECT Full_name FROM register WHERE PIN=?");
pst.setInt(1,login_pin);
rs= pst.executeQuery();
while (rs.next()){
    String y=rs.getString("Full_name");
    System.out.println("\nWelcome "+y);
}
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    /**
     * @param args the command line arguments
     */
  
  //main function that starts the program  
    public static void main(String  args[]) throws IOException{
        
        // TODO code application logic here
        System.out.println("TRAVEL BUDDY\n");
        System.out.println("1.Register");
        System.out.println("2.Login");
    
        System.out.print(":");
        int x=userInput.nextInt();
        //switch statement defined for register and login
        switch (x){
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            
        }
        
        String contYorn = " ";
        //while statement to keep the client functions running until stopped by client
        while (!"n".equals(contYorn)){
            InputStreamReader isr = null;
            BufferedReader br = null;
            //streams to process user input
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            System.out.println("\n----------Menu----------");
            System.out.println("1.Query new Trip");
            System.out.println("2.Propose new trip");
            
            System.out.print(":");
            int y=userInput.nextInt();
            //switch statement defined for query new trip and proposed new trip
            switch (y){
                case 1:
                    query();
                    System.out.println("Continue y or n?");
                    contYorn=br.readLine();
                    break;
                case 2:
                    new_trips();
                    System.out.println("Continue y or n?");
                    contYorn=br.readLine();
                    break;
            }
            
            
            
        }
    }
    
        public static void query() throws IllegalStateException{
        //Defined variables
        String location = "";
        String start_date="";
        String end_date="";
      InputStreamReader isr = null;
      BufferedReader br = null;
      //streams to process user input
      isr = new InputStreamReader(System.in);
      br = new BufferedReader(isr);
      //try-catch defined to establish if an exception error occured
      try {
        //prompts user to enter the neccessary info
        System.out.print("Location: ");
         //reads in the user input from the command prompt
        location = br.readLine();
        System.out.println("\nDate format: YYYY-MM-DD");
        System.out.print("\nStart Date: ");
        start_date = br.readLine();
        System.out.print("End Date: ");
        end_date = br.readLine();
        //code below defines the url parameters using the user input
        Map<String, String> parameters = new HashMap<>();
        parameters.put("location", location);
        parameters.put("Start", start_date);
        parameters.put("end", end_date);
        //code below helps structure the parameters into the default structure
        String convertedParamsToString = parameters.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&")); 
        // section below calls the weather info from the orchestrator using Azure Tomcat
        URL url = new URL("http://20.2.85.48:8080/TravelBuddy/webresources/getWeather?"+convertedParamsToString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
// Get the response
BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
String response;
StringBuilder responseInfo= new StringBuilder();
while((response=in.readLine())!=null){
    responseInfo.append(response);
} in.close();
//code below prints out the weather info based on the user location
System.out.println("\n---"+location+" Weather Information---");
      //defined JSONObject to go through weather info json
        JSONObject json = new JSONObject (responseInfo.toString());
        //defined JSONArray to go through days 
JSONArray albums =  (JSONArray) json.get("days");
//for loop code below prints out the defined information
            for (int i=0;i<albums.length();i++) {
                JSONObject album= (JSONObject) albums.get(i);
                String x=album.getString("datetime");
                double y=album.getDouble("temp");
                String w=album.getString("description");
                String z=album.getString("sunrise");
                String v=album.getString("sunset");
               System.out.println(x+",Temperature is " +y+" degrees celcius and it will be "+w);
               System.out.println("Sunrise will be at "+ z +" and Sunset will be at "+v);
            }
      } 
      catch(IOException e) {
        System.out.println("IO Exception ocuured " + e);
      } 
    }
        
        public static void new_trips(){
        String location = "";
        String start_date="";
        String end_date="";
      InputStreamReader isr = null;
      BufferedReader br = null;
      //streams to process user input
      isr = new InputStreamReader(System.in);
      br = new BufferedReader(isr);
      System.out.println("\n-------Trip Info--------");
      try {
        //prompts user to enter the necessary info
        System.out.print("\nLocation: ");
         //reads in the user input from the command prompt
        location = br.readLine();
        System.out.println("\nDate format: YYYY-MM-DD");
        System.out.print("\nStart Date: ");
        start_date = br.readLine();
        System.out.print("End Date: ");
        end_date = br.readLine();
        // section below calls the trip ID from the orchestrator using Azure Tomcat
        URL url = new URL("http://20.2.85.48:8080/TravelBuddy/webresources/getTripID");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
// Get the response
BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
String response = in.readLine();

System.out.println("\n"+response+"-TRIP ID"+"\n"
        +location + "\n"
        +start_date +"\n"
        +end_date
);
//function defined to store the user trip info
insert(response,location,start_date,end_date);
System.out.println("\nYour trip information above has been saved");
      } 
      catch(IOException e) {
        System.out.println("IO Exception ocuured " + e);
      } 
    }
        
        
  //function defined to carry out insert sql command for register    
    public static void connect(String userID,int PIN,String Full_name){
        Connection con;
        PreparedStatement pst = null;
        ResultSet rs;
      try {
Class.forName("com.mysql.cj.jdbc.Driver");
con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","service_centric");
pst= con.prepareStatement("INSERT INTO register(Full_name,PIN,UserID)VALUES(?,?,?)");
pst.setString(1, Full_name);
pst.setInt(2,PIN);
pst.setString(3, userID);
pst.executeUpdate();

      } catch (ClassNotFoundException ex) {
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }
         }  
    //function defined to carry out insert sql command for propse new trip
    public static void insert(String ID,String Location,String Start_date,String End_date){
        Connection con;
        PreparedStatement pst = null;
        ResultSet rs;
      try {
Class.forName("com.mysql.cj.jdbc.Driver");
con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","service_centric");
pst= con.prepareStatement("INSERT INTO new_trip(TRIP_ID,LOCATION,START_DATE,END_DATE)VALUES(?,?,?,?)");
pst.setString(1, ID);
pst.setString(2,Location);
pst.setString(3, Start_date);
pst.setString(4, End_date);
pst.executeUpdate();

      } catch (ClassNotFoundException ex) {
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }
         }
}

 
