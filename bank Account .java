
import java.util.Random;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    
   //This HashMap is for Signup, login, recoveracc and addinfo.
    private static HashMap<String, String> user = new HashMap<>();
   private static HashMap<String, Integer> recover = new HashMap<>();
   
   
    public static void main(String[] args) {
       
       intro();
       
       bankm a = new bankm();
       
    }
   
   
   
   
   // This part is for signing up;
   //This method is for the first part.
    static void intro(){
       Scanner in = new Scanner (System.in); 
        
        System.out.println();
        System.out.println("------SIMPLE BANK ACCOUNT------");
        System.out.println("\n");
        String [] opt = {" A. Sign Up", " B. Log-in"};
        for(int i = 0; i < 2 ; i++){
            System.out.println(opt[i]);
        }
       System.out.println();
        //This code is for the different choice.
       
                 String ch;   
       System.out.print("Enter choice: ");
         ch = in.nextLine();
            if (ch.equalsIgnoreCase("A")){
               System.out.println(); 
               signUp();
            } 
            else if (ch.equalsIgnoreCase("B")){
               System.out.println(); 
               logIn();
            }else{
          System.out.println();
                System.out.println(" Invalid choice!");
          System.out.println();
            intro();
            }

}

        
    
   
    
    private static void signUp(){
        Scanner in = new Scanner (System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println();
       System.out.println("-------------Sign Up---------------"); 
        System.out.println("\n");
        
        String uname;
        System.out.print("Enter Username : "); 
        uname = in.nextLine();
        System.out.println();
       //This code is for username.
        if (user.containsKey(uname)){
           System.out.println("-------------------------------------------------------");
            System.out.println("Username has already taken!");
           System.out.println("-------------------------------------------------------");
            System.out.println();
           signUp();
        }
        else{
                   // This is for password.
            String password;
            System.out.print("Enter Password : ");
            password = in.nextLine();
           //This code create your username and password.
           System.out.println();
            user.put(uname, password);
           
System.out.println("-------------------------------------------------------");
            System.out.println("You've successfully  signed up.");System.out.println("-------------------------------------------------------");
           System.out.println();
           forgot();
           

        }
      
    }
   
   
   
  static void forgot(){
    Scanner in = new Scanner (System.in); 
     
     //This part ask the user to have an back up way to recover acc in case he/she forgot the password.
        System.out.println();
     String ans;
       System.out.println("Want to add recovery mode? ");
       System.out.print("Yes/No: ");
       ans = in.nextLine();
       //If the user enter yes, they will be redirected to Add Info..ang add info mao na ang registeran aron ma gamit nmo sa pag recover sa acc.
       if (ans.equalsIgnoreCase("Yes")){
          System.out.println();
          System.out.println("-------------------------------------------------------");
          System.out.println("You've been redirected to Additional Info option. ");
System.out.println("-------------------------------------------------------");
          
          System.out.println();
         addInfo();
       }
     else if (ans.equalsIgnoreCase("no")){
        
        System.out.println();
          intro();
     }
       else{
          System.out.println();
          System.out.println("-------------------------------------------------------");
       System.out.println("Invalid Choice! Try again.");   
          System.out.println("-------------------------------------------------------");
          
          forgot();
       }
     
  }
   
   
   
   //This part used to recover acc through registering their email address.
   static void addInfo(){
      
      Scanner in = new Scanner (System.in);
        
      System.out.println("-------------------------------------------------------");
      
        System.out.println("------USER'S ADDITIONAL INFORMATION------");
        System.out.println("\n");
        String usern;
        System.out.print("Enter email: ");
        usern = in.nextLine();
      //This code check if the users username already registered on the signup option and if it is registered, it will print enter the email add.
      
      if (recover.containsKey(usern)){
         System.out.println();
System.out.println("-------------------------------------------------------");
         System.out.println("Email address is already used!");
         System.out.println("-------------------------------------------------------");
         System.out.println();
         addInfo();
         
      }     
      else{
         System.out.println();
         int num;
         System.out.println("✓Enter phone number:  ");
         num = in.nextInt();
         //This part registered your phone and username which you can use to recover your acc.
         recover.put(usern, num);
         
         System.out.println();
System.out.println("-------------------------------------------------------");
         System.out.println("You've successfully register your number.");
         System.out.println("-------------------------------------------------------");
        System.out.println();
         System.out.println("-------------------------------------------------------");
         System.out.println("[Note:] You can now use it to recover your account.");System.out.println("-------------------------------------------------------");
         System.out.println();
         intro();
         
      }
   }
    
   
    
   
    private static void logIn(){
        Scanner in = new Scanner (System.in);
        
       System.out.println();
       
        System.out.println("--------------LOG IN------------------");
        System.out.println("\n");
       
       String uname;
       
       System.out.println("✓Enter Username: ");
        uname = in.nextLine();
       System.out.println();
        //This code check if the username you entered is stored on thw user Hashmap.
        if (user.containsKey(uname)){
           //if it is correct it print out enter password.
           System.out.println();
           
            String pass;
          int chance = 2; 
           
           while(chance > 0){
               System.out.println("✓Enter Password: ");
            pass = in.nextLine();
            System.out.println();
            if (user.get(uname).equals(pass)){
               System.out.println("-------------------------------------------------------");
               System.out.println("Log-in successfully! Welcome, "+uname+".");
               System.out.println("-------------------------------------------------------");

               System.out.println();
               bankm a = new bankm();
               a.bankMenu();
               break;
            }else{
               System.out.println();
System.out.println("-------------------------------------------------------");
               System.out.println("Incorrect password!");
               
               chance--;
               System.out.println("-------------------------------------------------------");  
           }
           }              //while bracket 
         
               System.out.println();
                String ans;
              System.out.println("Forgot Password?");
            ans = in.nextLine();
                if (ans.equalsIgnoreCase("yes")){
                   System.out.println("Gaba! Joke.");
                   System.out.println();
                    recoverAcc();}
                else if(ans.equalsIgnoreCase("no")){    System.out.println();
        String an;            
       System.out.println("Are you sure?: ");
         an = in.nextLine();
                if(an.equals("yes")){
                   System.out.println();
                   System.out.println("---Oki!---"); 
                   logIn();  
                } 
                else{
                    String tubag;
                   System.out.println();
                    System.out.println("Want to recover account?");
                    tubag = in.nextLine();
                    
                    if (ans.equalsIgnoreCase("yes")){
                    System.out.println();
                       recoverAcc();}
                else if(ans.equalsIgnoreCase("no")){
                   System.out.println();
                   System.out.println("-------------------------------------------------------");
       System.out.println("Bahala ka diha, uyy!");
System.out.println("-------------------------------------------------------");
                   
           System.out.println();        
              logIn();      
                }         
                    
                }
            }else{
               System.out.println();
System.out.println("-------------------------------------------------------");
                System.out.println("Tarong sa imong kunabuhi ha!");
               System.out.println("-------------------------------------------------------");

               System.out.println();
                logIn();
            }
        }
        else{
           System.out.println();
System.out.println("-------------------------------------------------------");
            System.out.println("Invalid Username! Try again!");
           System.out.println("-------------------------------------------------------");
           
          System.out.println();
           logIn();
        }
       
       
        }
    
   
   
    
    private static void recoverAcc(){
        Scanner in = new Scanner (System.in);
        
       System.out.println("-------------------------------------------------------");
       
        System.out.println("------RECOVERY OPTION------");
       
        System.out.println();
        String uname;
        System.out.print("Enter email address: ");
        uname = in.nextLine();
       System.out.println();
        if (recover.containsKey(uname)){
           int num;
           System.out.println("Enter phone number: ");
           num = in.nextInt();
           if(recover.get(uname).equals(num)){
              
               System.out.println();
               System.out.println("-------------------------------------------------------");
               System.out.println("Note : A 4-digit code will be sent to you for the final part of recovering your account.");
               System.out.println("----------------8---------------------------------------");
               System.out.println();
              sumpay();
           }else{
            System.out.println("Incorrect phone number! Try again.");
            System.out.println(); 
              recoverAcc();
           }
        }else{
           System.out.println("-------------------------------------------------------");
           System.out.println("Unregistered Email! Try again or sign up!");
           System.out.println("-------------------------------------------------------");
           System.out.println("Do you want to sign up? Yes/No?");
           System.out.print("Enter your choice : ");
           String ch = in.nextLine();
           
           if(ch.equalsIgnoreCase("yes")){
              signUp();
           }
          System.out.println(); 
           recoverAcc();
           
        } 
              
            
    }
   
   
   
   static void sumpay(){
      Scanner in = new Scanner (System.in);
      
      Random r = new Random();
         
        int no = r.nextInt((3000-1000)+1)+1000;  
              
              
         try{      
              Thread.sleep(1000);  
            System.out.println("-------------------------------------------------------");
               System.out.println("Your 4-digit code is "+no+".");
            System.out.println("-------------------------------------------------------");
               
            Thread.sleep(500);   
            
            }catch(InterruptedException e){
               System.out.println("Interrupted!");
            }
              
                        System.out.println("-------------------------------------------------------");   
              try{
               int cod;
               do{               
               System.out.print("✓Enter the 4-digit code : ");
                  cod = in.nextInt();
                  
               }while(cod != no);
                 System.out.println("-------------------------------------------------------"); 
              System.out.println("Successfully recovered!");
              System.out.println("-------------------------------------------------------");    
                 System.out.println();
                 bankm a = new bankm();
               a.bankMenu();
                 
              }catch(InputMismatchException e){
              System.out.println("Enter number only!");  
            }
              System.out.println("-------------------------------------------------------");               
              
    }

   }




//This part is for the bank account body in where all the transaction happened.
class bankm {
    
    double balance;
    double previousTransaction;
    
    bankm(){
       
       bankMenu();
    }
    
   public  void bankMenu(){
     Scanner in = new Scanner (System.in); 
      
      System.out.println();
      System.out.println("-------Bank Account Menu-------");
      System.out.println("\n");
      String[] ch = {" A. Check Balance", " B. Withdraw", " C. Deposit", " D. Previous Transaction ", " E. Exit"};
      for(int i = 0; i < 5; i++){
         System.out.println(ch[i]);
      }
      System.out.println();
      char enter;
      System.out.print("✓Enter Choice: ");
      enter = in.next().charAt(0);
      System.out.println();
      
      switch (enter){
         case 'A':
System.out.println("-------------------------------------------------------");
          System.out.println("Balance: Php "+balance);
         System.out.println("-------------------------------------------------------");
         System.out.println();
         System.out.print("Enter 0 to back: ");
      int en = in.nextInt();
      if(en == 0){
         bankMenu();
      }
         break;
         case 'B':
         withdraw();
         break;
         case 'C':
         deposit();
         break;
         case 'D':
         ptran();
         break;
         case 'E':
         System.out.println("-------------------------------------------------------");
         System.out.println("Thank You for using this app!");
         System.out.println("-------------------------------------------------------");

         System.exit(0);
         break;
         default:
System.out.println("-------------------------------------------------------");
         System.out.println("Invalid Choice! Try again.");
         System.out.println("-------------------------------------------------------");

         System.out.println();
         bankMenu();
      }
   }
   
   
   public  void deposit (){
      Scanner in = new Scanner (System.in);
      
      System.out.println();
      System.out.println("--------DEPOSIT OPTION--------");
      System.out.println("\n");
      double amount;
      try{
      System.out.print("Enter an amount to deposit: ");
      amount = in.nextInt();
      System.out.println();
      
      if (amount != 0){
         balance = balance + amount;
         previousTransaction = balance;
         
System.out.println("-------------------------------------------------------");
         System.out.println("You've successfully deposit an amount of Php "+amount+".");
         System.out.println("-------------------------------------------------------");
System.out.println("-------------------------------------------------------");
         System.out.println("Balance: Php "+balance);
         System.out.println("-------------------------------------------------------");

         System.out.println();
         System.out.print("Enter 0 to back: ");
      int en = in.nextInt();
         System.out.println();
      if(en == 0){
         bankMenu();
      }
      }else{
         System.out.println("-------------------------------------------------------");
        System.out.println("Please enter number only!");
         System.out.println("-------------------------------------------------------");

         deposit();
      }   
      }catch(InputMismatchException e){
         System.out.println("Enter number only!");
         deposit(); 
      }  
      
      
   }
   
   
   public void withdraw(){
      Scanner in = new Scanner (System.in);
      
      System.out.println();
      System.out.println("--------WITHDRAWAL OPTION--------");
      System.out.println("\n");
      
      try{
      System.out.println("Enter amount to withdraw: ");
      int amount = in.nextInt();
      if(amount != 0){
         balance = balance - amount;
         previousTransaction = -balance;
         
System.out.println("-------------------------------------------------------");
         System.out.println("You've successfully withdrawn an amount of Php "+amount+".");
         System.out.println("-------------------------------------------------------");
System.out.println("-------------------------------------------------------");
          System.out.println("Balance: Php "+balance);
         System.out.println("-------------------------------------------------------");

         System.out.println();
         System.out.println();
       System.out.print("Enter 0 to back: "); 
       int en = in.nextInt();
         System.out.println();
      if (en == 0){
         bankMenu();
      }
      else if(amount > balance){
         System.out.println();
System.out.println("-------------------------------------------------------");
          System.out.println("Not enough balance!");
         System.out.println("-------------------------------------------------------");

       System.out.println();
       System.out.print("Enter 0 to back: "); 
       int r = in.nextInt();
         System.out.println();
      if (r == 0){
         bankMenu();
      }
      else{
         System.out.println();
         System.out.print("Enter 0 to back: "); 
         int tr = in.nextInt();
         System.out.println();
      if (tr == 0){
         bankMenu();
      }
      }
   }
      }
      }catch(InputMismatchException e){
         System.out.println(" Enter number only!");
      }     
    
   }
   
   
   
  public void ptran(){
      Scanner in = new Scanner(System.in);
      
      
      if(previousTransaction > 0){
System.out.println("-------------------------------------------------------");
         System.out.println("You've deposited an amount of Php"+previousTransaction+".");
         System.out.println("-------------------------------------------------------");

         System.out.println();
         System.out.print("Enter 0 to back: "); 
       int en = in.nextInt();
        System.out.println(); 
      if (en == 0){
       bankMenu();
      }
}else if (previousTransaction < 0){
System.out.println("-------------------------------------------------------");
         System.out.println("You've withdrawn an amount of Php"+Math.abs(previousTransaction)+".");
System.out.println("-------------------------------------------------------");
     
         System.out.println();
         System.out.print("Enter 0 to back: "); 
         int tr = in.nextInt();
     System.out.println();
      if (tr == 0){
         bankMenu();
      }
      }else{
         System.out.println();
System.out.println("-------------------------------------------------------");
      System.out.println("No Transaction occured!");
         System.out.println("-------------------------------------------------------");

      System.out.println();
      System.out.print("Enter 0 to back: "); 
         int tr = in.nextInt();
         System.out.println();
      if (tr == 0){
         bankMenu();
      }
      
   }
   }
   
}
 


