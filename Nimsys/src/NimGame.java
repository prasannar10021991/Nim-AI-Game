
import java.util.Scanner;



/* 
Class Name: NimGame

Purpose of Class:  NimGame class contains the gameplay part of the Nim where the players take turns to remove stones from a common
 stack until all stones are removed and the player who removes the last stone is considered as the loser and the other player
  is the winner.

Authorship Details :
Name : Prasanna Kumar Ravi
Student ID : 667913
Created on : 01-05-2014
*/


public class NimGame {

	private static int initStones=-1,opp=-1;
	public static int opp2=-1;
	public String playGame(int numberOfStones,int maxStones,String player1,String player2,Scanner keyboard) throws InvalidMoveException
	{
		initStones=numberOfStones;
		int removeCount=-1;
		boolean turn = false;
		
		while(initStones !=0 )
		{
			try{
				System.out.print("\n"+initStones+" stones left:");
				for(int i=0;i<initStones;i++)
				{
					System.out.print(" *");
				}
				if(turn==false)
				{
					System.out.print("\n"+player1.substring(0,player1.indexOf(" "))+"'s turn - remove how many?\n");
					removeCount = keyboard.nextInt();
					if((removeCount <= maxStones) && (removeCount>0)){
						
						if(removeCount<=initStones)
						{
							initStones = initStones-removeCount;
							turn=true;
						}
						else if(removeCount>initStones&&initStones<=maxStones)
						{
							throw new InvalidMoveException(initStones);
							
						}
					}
					
					else
					{
						if(initStones>maxStones)
						{
							throw new InvalidMoveException(maxStones);
						}
						else
						{
							throw new InvalidMoveException(initStones);
						}
						
					}
				}
				else
				{

					System.out.print("\n"+player2.substring(0,player2.indexOf(" "))+"'s turn - remove how many?\n");
					removeCount = keyboard.nextInt();
					if((removeCount <= maxStones) && (removeCount>0)){
						
						if(removeCount<=initStones)
						{
							initStones = initStones-removeCount;
							turn=false;
						}
						else if(removeCount>initStones&&initStones<=maxStones)
						{
							throw new InvalidMoveException(initStones);
							
						}
						
					}
					
					else
					{
						if(initStones>maxStones)
						{
							throw new InvalidMoveException(maxStones);
						}
						else if(initStones<maxStones)
						{
							throw new InvalidMoveException(initStones);
						}
						
					}
				}
			}//try
			catch(InvalidMoveException e)
			{
				System.out.println("\n"+e.getMessage());
			}
		} //while loop ends
		if(initStones==0)
		{
			if(turn==true)
			{
				System.out.println("\nGame Over");
				System.out.println(player2+" wins!");
				return player2;
			}
			else
			{
				System.out.println("\nGame Over");
				System.out.println(player1+" wins!");
				return player1;
			}
		}
		
		else
		{
			return "";
		}
	}	//playGame


	public String playGame(int numberOfStones,int maxStones,String player1,String player2,Scanner keyboard,boolean sim1,boolean sim2) throws InvalidMoveException
	{
		initStones=numberOfStones;
		int k = numberOfStones;
		
		boolean turn = false;
		
		int removeCount=-1;
		
		if(sim1==true && sim2==false)
		{
			
			while(initStones !=0 )
			{
				
				
				try{
					System.out.print("\n"+initStones+" stones left:");
					for(int i=0;i<initStones;i++)
					{
						System.out.print(" *");
					}
					if(turn==false && initStones==k)
					{
						System.out.print("\n"+player1.substring(0,player1.indexOf(" "))+"'s turn - remove how many?\n");
						removeCount=maxStones;
						
						if((removeCount <= maxStones) && (removeCount>0)){
							
							if(removeCount<=initStones)
							{
								initStones = initStones-removeCount;
								turn=true;
							}
							else if(removeCount>initStones&&initStones<=maxStones)
							{
								throw new InvalidMoveException(initStones);
								
							}
						}
						
						else
						{
							if(initStones>maxStones)
							{
								throw new InvalidMoveException(maxStones);
							}
							else
							{
								throw new InvalidMoveException(initStones);
							}
							
						}
					}
					else if(turn==false)
					{
						System.out.print("\n"+player1.substring(0,player1.indexOf(" "))+"'s turn - remove how many?\n");
						
						removeCount=maxStones+1-opp;
						
						if((removeCount <= maxStones) && (removeCount>0)){
							
							if(removeCount<=initStones)
							{
								initStones = initStones-removeCount;
								turn=true;
							}
							else if(removeCount>initStones&&initStones<=maxStones)
							{
								throw new InvalidMoveException(initStones);
								
							}
						}
						
						else
						{
							if(initStones>maxStones)
							{
								throw new InvalidMoveException(maxStones);
							}
							else
							{
								throw new InvalidMoveException(initStones);
							}
							
						}
					}
					else
					{

						System.out.print("\n"+player2.substring(0,player2.indexOf(" "))+"'s turn - remove how many?\n");
						removeCount = keyboard.nextInt();
						opp=removeCount;
						if((removeCount <= maxStones) && (removeCount>0)){
							
							if(removeCount<=initStones)
							{
								initStones = initStones-removeCount;
								turn=false;
							}
							else if(removeCount>initStones&&initStones<=maxStones)
							{
								throw new InvalidMoveException(initStones);
								
							}
							
						}
						
						else
						{
							if(initStones>maxStones)
							{
								throw new InvalidMoveException(maxStones);
							}
							else if(initStones<maxStones)
							{
								throw new InvalidMoveException(initStones);
							}
							
						}
					}
				}//try
				catch(InvalidMoveException e)
				{
					System.out.println("\n"+e.getMessage());
				}
			} //while loop ends
		}
		else if(sim1==false && sim2==true)
		{
			while(initStones !=0 )
			{
				
				
				try{
					System.out.print("\n"+initStones+" stones left:");
					for(int i=0;i<initStones;i++)
					{
						System.out.print(" *");
					}
					if(turn==false)
					{
						System.out.print("\n"+player1.substring(0,player1.indexOf(" "))+"'s turn - remove how many?\n");
						removeCount = keyboard.nextInt();
						
						if((removeCount <= maxStones) && (removeCount>0)){
							
							if(removeCount<=initStones)
							{
								initStones = initStones-removeCount;
								turn=true;
							}
							else if(removeCount>initStones&&initStones<=maxStones)
							{
								throw new InvalidMoveException(initStones);
								
							}
						}
						
						else
						{
							if(initStones>maxStones)
							{
								throw new InvalidMoveException(maxStones);
							}
							else
							{
								throw new InvalidMoveException(initStones);
							}
							
						}
					}
					else
					{

						System.out.print("\n"+player2.substring(0,player2.indexOf(" "))+"'s turn - remove how many?\n");
						removeCount=(int) (1+(Math.random()*((maxStones+1)-1)));
					
						if((removeCount <= maxStones) && (removeCount>0)){
							
							if(removeCount<=initStones)
							{
								initStones = initStones-removeCount;
								turn=false;
							}
							else if(removeCount>initStones&&initStones<=maxStones)
							{
								throw new InvalidMoveException(initStones);
								
							}
							
						}
						
						else
						{
							if(initStones>maxStones)
							{
								throw new InvalidMoveException(maxStones);
							}
							else if(initStones<maxStones)
							{
								throw new InvalidMoveException(initStones);
							}
							
						}
					}
				}//try
				catch(InvalidMoveException e)
				{
					System.out.println("\n"+e.getMessage());
				}
			} //while loop ends
		}
		else
			
		{
			opp2=-1;
			while(initStones !=0 )
			{
				
				
				try{
					System.out.print("\n"+initStones+" stones left:");
					for(int i=0;i<initStones;i++)
					{
						System.out.print(" *");
					}
					if(turn==false&&opp2==-1)
					{
						System.out.print("\n"+player1.substring(0,player1.indexOf(" "))+"'s turn - remove how many?\n");
						removeCount=(int) (1+(Math.random()*((maxStones+1)-1)));
						opp2 =removeCount;
						if((removeCount <= maxStones) && (removeCount>0)){
							
							if(removeCount<=initStones)
							{
								initStones = initStones-removeCount;
								turn=true;
							}
							else if(removeCount>initStones&&initStones<=maxStones)
							{
								throw new InvalidMoveException(initStones);
								
							}
						}
						
						else
						{
							if(initStones>maxStones)
							{
								throw new InvalidMoveException(maxStones);
							}
							else
							{
								throw new InvalidMoveException(initStones);
							}
							
						}
					}
					else if(turn==false &&opp2!=1)
					{
						System.out.print("\n"+player1.substring(0,player1.indexOf(" "))+"'s turn - remove how many?\n");
						removeCount=opp2;
						
						if((removeCount <= maxStones) && (removeCount>0)){
							
							if(removeCount<=initStones)
							{
								initStones = initStones-removeCount;
								turn=true;
							}
							else if(removeCount>initStones&&initStones<=maxStones)
							{
								throw new InvalidMoveException(initStones);
								
							}
						}
						
						else
						{
							if(initStones>maxStones)
							{
								throw new InvalidMoveException(maxStones);
							}
							else
							{
								throw new InvalidMoveException(initStones);
							}
							
						}
					}
					else
					{

						System.out.print("\n"+player2.substring(0,player2.indexOf(" "))+"'s turn - remove how many?\n");
						removeCount=opp2+1;
					
						if((removeCount <= maxStones) && (removeCount>0)){
							
							if(removeCount<=initStones)
							{
								initStones = initStones-removeCount;
								opp2=removeCount;
								turn=false;
							}
							else if(removeCount>initStones&&initStones<=maxStones)
							{
								throw new InvalidMoveException(initStones);
								
							}
							
						}
						
						else
						{
							if(initStones>maxStones)
							{
								throw new InvalidMoveException(maxStones);
							}
							else if(initStones<maxStones)
							{
								throw new InvalidMoveException(initStones);
							}
							
						}
					}
				}//try
				catch(InvalidMoveException e)
				{
					System.out.println("\n"+e.getMessage());
				}
			} //while loop ends
		}
			
		
		if(initStones==0)
		{
			if(turn==true)
			{
				System.out.println("\nGame Over");
				System.out.println(player2+" wins!");
				return player2;
			}
			else
			{
				System.out.println("\nGame Over");
				System.out.println(player1+" wins!");
				return player1;
			}
		}
		
		else
		{
			return "";
		}
	}	//playGame

}	//class 
