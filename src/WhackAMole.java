import java.util.Scanner;

public class WhackAMole {
    int score;
   	int  molesLEft;
   	int attemptsLife;
   	char[][] moleGrid ;
   	

    public WhackAMole(int numAttempts, int gridDimension) {
	// TODO Auto-generated constructor stub
	attemptsLife=numAttempts;
	moleGrid = new char[gridDimension][gridDimension];
	for(int i=0;i<gridDimension;i++) {
	    for(int j=0;j<gridDimension;j++) {
		moleGrid[i][j]= '*';
	    }
	}
	
	
    }
   boolean place(int x, int y) {
       if(moleGrid[x][y]=='*') {
	   moleGrid[x][y]='M';
	   molesLEft++;
	   return true;
       } 
       else {
	   return false;
       }
       
	
    }
   void whack(int x, int y) {
      
       if(moleGrid[x][y]=='M') {
	   moleGrid[x][y]='W';
	   attemptsLife --;
       molesLEft --;
       score++;   
       printGridToUser();
       }
       else if(x==-1&&y==-1
	       ) {
	   attemptsLife=0;
	   printGrid();	   
       }
       else {
	   attemptsLife--;
	       printGridToUser();
	   }
	   
       }

    
   void printGridToUser() {
       for(int i=0;i<=moleGrid.length;i++) {
	   for(int j=0;j<=moleGrid.length;j++) {
	       if(moleGrid[i][j]=='W') {
		   System.out.println("whacked mole"+"W");
	       }
	       else {
		   System.out.println("*");
	       }
	   }
       }
       
       
	
    }
   void printGrid() {
       for(int i=0;i<=moleGrid.length;i++) {
	   for(int j=0;j<=moleGrid.length;j++) {
	       if(moleGrid[i][j]=='M') {
		   System.out.println("moles present"+"M");
	       }
	       else if(moleGrid[i][j]=='W') {
		   System.out.println("W");
	       }
	       else {
		   System.out.println("*");
	       }
	   }
       }
       
	
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	WhackAMole game = new WhackAMole(50,10);
	int placedMoles=0;
	 while(placedMoles < 10)
	        {
	            int randomGuessX = (int)(Math.random()*10);
	            int randomGuessY = (int)(Math.random()*10);
	                if(game.place(randomGuessX, randomGuessY) == true)
	                {
	                    placedMoles++;
	                }
	        }
	        
	        while(game.attemptsLife > 0 && game.molesLEft > 0)
	        {
	        Scanner userInput = new Scanner(System.in);
	        System.out.println("Enter the x and y coordinates of where you would like to take a whack."
	        +"\n"+ 
	        "You have a maximum of 50 attempts to get all the moles."); 
	        System.out.print("x coordinate of the mole: ");
	        int userGuessX = userInput.nextInt();
	        System.out.println("");
	        System.out.print("y coordinate of the mole: ");
	        int userGuessY = userInput.nextInt();
	        game.whack(userGuessX,userGuessY);
	        }
			
	
	
   
   	

    }

}
