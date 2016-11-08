
/* 
 Class Name: Nimsys
 
 Purpose of Class:  Nimsys class contains the all the implementations of the addition of players to the game and the manipulation
  of player information like editing the player's given and family names,displaying the player informations,updating
  the players wins,sorting the players according to username and calculating the rankings for the players based on 
  the no. of games won and no. of games played by the player. 
 
 Authorship Details :
 Name : Prasanna Kumar Ravi
 Student ID : 667913
 Created on : 01-05-2014
 */



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;



/*
 * Class Nimsys implements Comparable interface which allows to sort the Collection containing players based on a specific 
 * key by over-riding the compareTo function. 
 */

public class Nimsys implements Comparable<Nimsys>{
	private String username,family_name,given_name;
	public int no_Of_Games,wins,length,count=0,percentage;
	private boolean ai = false;
	public static boolean sim1 = false,sim2=false;
	private static ArrayList<Nimsys> players = new ArrayList<Nimsys>();
	public static int mark1=-1,mark2=-1;
	public static String result,playerobj1="",playerobj2="";
	public static PrintWriter filereader = null;
	
	
	
	/*
	 * Default Constructor which initializes the values for class vaiables with default values as in empty string for 
	 * String variables and zero for integer variables.
	 */
	public Nimsys() 
	{
		this.username = "";
		this.family_name = "";
		this.given_name = "";
		this.no_Of_Games = 0;
		this.wins = 0;
		this.percentage = 0;
		this.ai = false;
	}

	/*
	 * Parameterized Constructor which initializes the values for class vaiables with values passed during an object declaration.
	 */
	public Nimsys(String user,String familyname,String givenname,boolean val) 
	{
		this.username = user;
		this.family_name = familyname;
		this.given_name = givenname;
		this.no_Of_Games = 0;
		this.wins = 0;
		this.percentage = 0;
		this.ai = val;
	}
	
	public Nimsys(String user,String familyname,String givenname,int game,int win,boolean val) 
	{
		this.username = user;
		this.family_name = familyname;
		this.given_name = givenname;
		this.no_Of_Games = game;
		this.wins = win;
		this.percentage = 0;
		this.ai = val;
	}

	/*
	 * Function addPlayer adds the player details which are passed as an object of Nimsys class to an Arraylist.
	 * Function also checks whether the player already exists by comparing the usernames of objects in the arraylist 
	 * and if already found does not add the player maintaining consistency.  
	 */
	public void addPlayer(Nimsys obj)
	{
		boolean found = false;
		int i=0;
		length = players.size();
		if(length>0)
		{
			for(i=0;i<length;i++)
			{					
				if(((players.get(i)).username).equalsIgnoreCase(obj.username))
				{
					found = true;
					System.out.println("The player already exists.");	
				}
				else if (i==(length-1) && found==false)
				{					
					players.add(obj);
				}
				
			}
		}
		else 
		{			
			players.add(obj);	//adds player only if username not found in the list.
			
		}
		
	}
	
	public void addAIPlayer(Nimsys obj)
	{
		boolean found = false;
		int i=0;
		length = players.size();
		if(length>0)
		{
			for(i=0;i<length;i++)
			{					
				if(((players.get(i)).username).equalsIgnoreCase(obj.username))
				{
					found = true;
					System.out.println("The player already exists.");	
				}
				else if (i==(length-1) && found==false)
				{					
					players.add(obj);
				}
				
			}
		}
		else 
		{			
			players.add(obj);	//adds player only if username not found in the list.
			
		}
		
	}
	
	/*
	 * removePlayer(String) is an overloaded function removes a specific player from the list of players by getting the username of the player to 
	 * be removed as input. If username is not found in the list no action is taken.
	 */
	public void removePlayer(String user)
	{
		boolean found = false;
		int i=0,mark=-1;
		length = players.size();
		if(length>0)
		{
			for(i=0;i<length;i++)
			{					
				if(((players.get(i)).username).equalsIgnoreCase(user))
				{
					mark=i;
					found = true;
				}
				else if (i==(length-1) && found==false)
				{					
						System.out.println("The player does not exist.");	
				}
				
			}
			if((found==true) && (mark>=0))
			{
				players.remove(mark); // removes player only if a username match is found 
			}
		}
		
		
	}
	
	/*
	 * removePlayer() function removes all the players from the list by getting a confirmation from the user to 
	 * clear the list.
	 */
	public void removePlayer(Scanner keyboard)
	{
		
			int i=0;
			length = players.size();
			
			System.out.println("Are you sure you want to remove all players? (y/n)");
				if((keyboard.next()).equals("y")) //removes players only if user answers yes i.e 'y' to the previous confirmation.
				{
					while(length>0)
					{
						players.remove(i);
						length--;
					}
				}
				else
				{
					return;
				}
		
			

	}
	
	
	public void editPlayer(String user,String familyname,String givenname) 
	{
		boolean found = false;
		int i=0;
		length = players.size();
		if(length>0)
		{
			for(i=0;i<length;i++)
			{					
				if(((players.get(i)).username).equalsIgnoreCase(user))
				{
					(players.get(i)).family_name = familyname;
					(players.get(i)).given_name = givenname;
					found = true;
				}
				else if (i==(length-1) && found==false)
				{					
					System.out.println("The player does not exist.");	
				}
				
			}
		}
		else 
		{
			System.out.println("The player does not exist.");
		}
		
		
	}
	
	/*
	 * resetStats(String) is an overloaded function that reset a specific player from the list of players by 
	 * getting the username of the player whose values are to be reset as input. If username is not found in the list no 
	 * action is taken.
	 */
	
	public void resetStats(String user) 
	{
		boolean found = false;
		int i=0;
		length = players.size();
		if(length>0)
		{
			for(i=0;i<length;i++)
			{					
				if(((players.get(i)).username).equalsIgnoreCase(user))
				{
					(players.get(i)).wins = 0;
					(players.get(i)).no_Of_Games = 0;
					found = true;
				}
				else if (i==(length-1) && found==false)
				{					
						System.out.println("The player does not exist.");	
				}
				
			}
		}
		else 
		{
			System.out.println("The player does not exist.");
		}
	}
	

	/*
	 * resetStats() function resets the no.of games played and the no. of wins obtained all the players in the list by 
	 * getting a confirmation from the user to reset the list.
	 */
	public void resetStats(Scanner keyboard) 
	{
		
		int i=0;
		String in;
		length = players.size();
		if(length>0)
		{
			System.out.println("Are you sure you want to reset all player statistics? (y/n)");
			in=keyboard.next();
			if(in.equals("y"))
			{
				for(i=0;i<length;i++)
				{					
						(players.get(i)).wins = 0;
						(players.get(i)).no_Of_Games = 0;
				}
			}
			
		}
		else 
		{
			System.out.println("The player does not exist.");
		}
	}

	/*
	 * displayPlayer() function displays information of all the players in the list in a sorted.
	 */
	
	public void displayPlayer()
	{
		int i;
		length = players.size();
		for(i=0;i<length;i++)
		{
			System.out.println((players.get(i)).username+","+(players.get(i)).given_name+","+(players.get(i)).family_name+","+
		(players.get(i)).no_Of_Games+" games,"+(players.get(i)).wins+" wins");
		}
		
		
	}
	
	/*
	 * displayPlayer(String) is an overloaded function that displays a specific player from the list of players by 
	 * getting the username of the player whose values are to be displayed. If username is not found in the list no 
	 * action is taken.
	 */
	
	public void displayPlayer(String user)
	{
		boolean found = false;
		int i;
		length = players.size();
		if(length>0)
		{
			for(i=0;i<length;i++)
			{					
				if(((players.get(i)).username).equalsIgnoreCase(user))
				{
					System.out.println((players.get(i)).username+","+(players.get(i)).given_name+","+(players.get(i)).family_name+","+
				(players.get(i)).no_Of_Games+" games,"+(players.get(i)).wins+" wins");
					found = true;
				}
				else if (i==(length-1) && found==false)
				{					
						System.out.println("The player does not exist.");	
				}
				
			}
		}
		else 
		{
			System.out.println("The player does not exist.");
		}
		
	}
	/*
	 *startGame function that gets the initial no.of stones and maximum stones that can be removed by the player 
	 *and the players' usernames between which the game has to be simulated.
	 */
	
		
	public boolean startGame(int initialstones,int max,String player1,String player2)
	{
	
		boolean found1 = false,found2 = false;
		int i,j;
		
		length = players.size();
		if(length>0)				//Checks if there are players available in the list
		{
			
		
			for(i=0;i<length;i++)
			{					
				if((((players.get(i)).username).equalsIgnoreCase(player1)))
				{
					playerobj1 = ((players.get(i)).given_name)+" "+((players.get(i)).family_name);
					found1 = true;
					mark1=i;
					if((players.get(i)).ai==true)
					{
						sim1=true;
					}
					else
					{
						sim1=false;
					}
				}			
				else if ((i==(length-1) && found1==false))
				{					
						System.out.println("One of the players does not exist.");	
				}
				
			}
			for(j=0;j<length;j++)
			{					
				if((((players.get(j)).username).equalsIgnoreCase(player2)))
				{
					playerobj2 = ((players.get(j)).given_name)+" "+((players.get(j)).family_name);
					found2 = true;
					mark2=j;
					if((players.get(j)).ai==true)
					{
						sim2=true;
					}
					else
					{
						sim2=false;
					}
				}			
				else if ((j==(length-1) && found2==false))
				{					
						System.out.println("One of the players does not exist.");	
				}
				
			}
		}
		else 
		{
			System.out.println("One of the players does not exist.");
		}
		
				
		
		if((found1==true) && (found2==true))
		{
			System.out.println();
			System.out.println("Initial stone count: "+initialstones);
			System.out.println("Maximum stone removal: "+max);
			System.out.println("Player 1: "+playerobj1);
			System.out.println("Player 2: "+playerobj2);
			
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	public boolean startGame(int initialstones,String player1,String player2)
	{
	
		boolean found1 = false,found2 = false;
		int i,j;
		
		length = players.size();
		if(length>0)				//Checks if there are players available in the list
		{
			
		
			for(i=0;i<length;i++)
			{					
				if((((players.get(i)).username).equalsIgnoreCase(player1)))
				{
					playerobj1 = ((players.get(i)).given_name)+" "+((players.get(i)).family_name);
					found1 = true;
					mark1=i;
					if((players.get(i)).ai==true)
					{
						sim1=true;
					}
					else
					{
						sim1=false;
					}
				}			
				else if ((i==(length-1) && found1==false))
				{					
						System.out.println("One of the players does not exist.");	
				}
				
			}
			for(j=0;j<length;j++)
			{					
				if((((players.get(j)).username).equalsIgnoreCase(player2)))
				{
					playerobj2 = ((players.get(j)).given_name)+" "+((players.get(j)).family_name);
					found2 = true;
					mark2=j;
					if((players.get(j)).ai==true)
					{
						sim2=true;
					}
					else
					{
						sim2=false;
					}
				}			
				else if ((j==(length-1) && found2==false))
				{					
						System.out.println("One of the players does not exist.");	
				}
				
			}
		}
		else 
		{
			System.out.println("One of the players does not exist.");
		}
		
				
		
		if((found1==true) && (found2==true))
		{
			
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	
	/*
	 * displayRankings() function displays information of all the players with the rankings which is calculated as percentage
	 * by the no. of games played and the no. of games won by the player and the list in a sorted based on the percentage. A tie 
	 * is broke between the players by comparing the usernames of the players
	 */
	public void displayRankings()
	{
		int i;
		float wins=-1,games=-1;
		DecimalFormat number = new DecimalFormat ("00") ;
		length = players.size();
		
		for(i=0;i<length;i++)
		{
			wins=(float)(players.get(i)).wins;
			games=(float)(players.get(i)).no_Of_Games;
			(players.get(i)).percentage=(Math.round(((wins/games)*100)));
		}
		
		Collections.sort(players);
		
		for(i=0;i<length;i++)
		{			
			System.out.printf("%-5s",(players.get(i)).percentage+"%");
			System.out.print("| "+number.format((players.get(i)).no_Of_Games)+" games "+"| "+(players.get(i)).given_name+" "+
			(players.get(i)).family_name+"\n");
		}
		
	}
	
	/*
	 * getPlayer function just sorts the arraylist of player objects based on their usernames. 
	 */
	public void getPlayer(ArrayList<Nimsys> object) {

		int i,j;
		Nimsys temp;
		length = object.size();
		for(i=0;i<length;i++)
		{
			for(j=i+1;j<length;j++)
			{
				Nimsys obj1=object.get(i);
				Nimsys obj2=object.get(j);
				
				if(((object.get(i)).username).compareTo((object.get(j)).username)>1)
				{
					temp=obj1;
					object.set(i,obj2);
					object.set(j,temp);
				}
					
			}
		}
		
	}
	
	public void writeToFile()
	{
		int i;
		length = players.size();
		for(i=0;i<length;i++)
		{
			filereader.println((players.get(i)).username+","+(players.get(i)).given_name+","+(players.get(i)).family_name+","+
		(players.get(i)).no_Of_Games+","+(players.get(i)).wins+","+(players.get(i)).ai);
		}
		filereader.close();
	}
	
	public static void main(String[] args) throws InvalidDataException,InvalidInputException, InvalidMoveException {
		// TODO Auto-generated method stub

		int initStones=-1,maxStones=-1;
		int end=-1,error=-1,win=-1,games=-1;
		String user,familyname,givenname,player1,player2;
		boolean gamecheck= false,v=false,u=false;
		Nimsys player = new Nimsys();
		NimGame game = new NimGame();
		
		String type="";
		
		
		File file = new File("players.dat");
		if(file.exists())
			{
				try {
					Scanner streamerObject = new Scanner (new FileInputStream("players.dat"));
					
					while(streamerObject.hasNextLine())
					{
						String prevInputs = streamerObject.nextLine();
						
						StringTokenizer tokens2 = new StringTokenizer(prevInputs,",");
						
						user = tokens2.nextToken();
						givenname = tokens2.nextToken();
						familyname = tokens2.nextToken();
						games = Integer.parseInt(tokens2.nextToken());
						win = Integer.parseInt(tokens2.nextToken());
						u = Boolean.parseBoolean(tokens2.nextToken());
						if(u==false)
						{
							player.addPlayer(new Nimsys(user,familyname,givenname,games,win,u));
						}
						else
						{
							player.addAIPlayer(new Nimsys(user,familyname,givenname,games,win,u));
						}
																
					}
					streamerObject.close();
					
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		try {
			filereader = new PrintWriter(new FileOutputStream("players.dat"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Scanner keyboard = new Scanner(System.in);
		
		
		

		System.out.println("Welcome to Nim");
		while (end < 0)
		{
			try{
				System.out.print("\n>");
				
				String command = keyboard.nextLine();
				
				if(command.equals(""))
				{
					command = keyboard.nextLine();
				}
				
				// StringTokenizer is used to separate the input string and process the inputs to perform various operations.
				
				StringTokenizer tokens = new StringTokenizer(command," ,");
				
				if(tokens.hasMoreTokens())
				{
					type = tokens.nextToken();
				}
				
				if(tokens.hasMoreTokens())
				{
					try{
					
						if(type.equalsIgnoreCase("addplayer"))
						{
																									
							error=tokens.countTokens();
							if(error<3)
							{
								throw new InvalidInputException();
							}
							else
							{
								user = tokens.nextToken();
								familyname = tokens.nextToken();
								givenname = tokens.nextToken();
								player.addPlayer(new Nimsys(user,familyname,givenname,v));
							}
										
						}
						
						else if(type.equalsIgnoreCase("addaiplayer"))
						{
							error=tokens.countTokens();
							if(error<3)
							{
								throw new InvalidInputException();
							}
							else
							{
								user = tokens.nextToken();
								familyname = tokens.nextToken();
								givenname = tokens.nextToken();
								v = true;
								player.addAIPlayer(new Nimsys(user,familyname,givenname,v));
							}
										
						}
						
						else if(type.equalsIgnoreCase("removeplayer"))
						{
							error=tokens.countTokens();
							if(error<1)
							{
								throw new InvalidInputException();
							}
							else
							{
								user = tokens.nextToken();
								player.removePlayer(user);
							}
							
						}
						else if(type.equalsIgnoreCase("editplayer"))
						{
							error=tokens.countTokens();
							if(error<3)
							{
								throw new InvalidInputException();
							}
							else
							{
								user = tokens.nextToken();
								familyname = tokens.nextToken();
								givenname = tokens.nextToken();
								player.editPlayer(user,familyname,givenname);
							}
								
						}
						else if(type.equalsIgnoreCase("resetstats"))
						{
							error=tokens.countTokens();
							if(error<1)
							{
								throw new InvalidInputException();
							}
							else
							{
								user = tokens.nextToken();
								player.resetStats(user);
							}
							
						}
						else if(type.equalsIgnoreCase("displayplayer"))
						{
							error=tokens.countTokens();
							if(error<1)
							{
								throw new InvalidInputException();
							}
							else
							{
								user = tokens.nextToken();
								player.displayPlayer(user);
							}
							
						}
						else if(type.equalsIgnoreCase("startgame"))
						{
							error=tokens.countTokens();
							if(error<4)
							{
								throw new InvalidInputException();
							}
							else
							{
								initStones = Integer.parseInt(tokens.nextToken());
								maxStones = Integer.parseInt(tokens.nextToken());
								player1 = tokens.nextToken();
								player2 = tokens.nextToken();
								gamecheck=player.startGame(initStones,maxStones,player1,player2);
								if (gamecheck==true)
								{
									
									if(sim1==true)
									{
										result=game.playGame(initStones,maxStones,playerobj1,playerobj2,keyboard,sim1,sim2);
									}
									else if(sim2==true)
									{
										result=game.playGame(initStones,maxStones,playerobj1,playerobj2,keyboard,sim1,sim2);
									}
									else
									{
										result=game.playGame(initStones,maxStones,playerobj1,playerobj2,keyboard);
									}
									
									if(result.equalsIgnoreCase(playerobj1))
									{
										((players.get(mark1)).no_Of_Games)++;
										((players.get(mark2)).no_Of_Games)++;
										((players.get(mark1)).wins)++;
									}
									else if(result.equalsIgnoreCase(playerobj2))
									{
										((players.get(mark1)).no_Of_Games)++;
										((players.get(mark2)).no_Of_Games)++;
										((players.get(mark2)).wins)++;
									}
									
								}
							}
							
						}
						
						else if(type.equalsIgnoreCase("startadvancedgame"))
						{
							error=tokens.countTokens();
							if(error<3)
							{
								throw new InvalidInputException();
							}
							else
							{
								initStones = Integer.parseInt(tokens.nextToken());
								
								player1 = tokens.nextToken();
								player2 = tokens.nextToken();
								boolean[] stones = new boolean[initStones];
								NimAIPlayer aiPlayer = new NimAIPlayer(initStones,stones);
								
								gamecheck=player.startGame(initStones,player1,player2);
								System.out.println();
								System.out.println("Initial stone count: "+initStones);
								System.out.print("Stones display:");
								for(int x=0;x<initStones;x++)
								{
										System.out.print(" <"+ (x+1) +",*>");
								}
								
								System.out.println("\nPlayer 1: "+playerobj1);
								System.out.println("Player 2: "+playerobj2);
								
								if (gamecheck==true)
								{
									
									if(sim1==true&&sim2==false)
									{
										result=aiPlayer.playGame(initStones,playerobj1,playerobj2,keyboard,sim1,sim2);
									}
									else if(sim1==false&&sim2==true)
									{
										result=aiPlayer.playGame(initStones,playerobj1,playerobj2,keyboard,sim1,sim2);
									}
									else if(sim1==false&&sim2==false)
									{
										result=aiPlayer.playGame(initStones,playerobj1,playerobj2,keyboard,sim1,sim2);
									}
									else
									{
										result=aiPlayer.playGame(initStones,playerobj1,playerobj2,keyboard,sim1,sim2);
									}
									if(result.equalsIgnoreCase(playerobj1))
									{
										((players.get(mark1)).no_Of_Games)++;
										((players.get(mark2)).no_Of_Games)++;
										((players.get(mark1)).wins)++;
									}
									else if(result.equalsIgnoreCase(playerobj2))
									{
										((players.get(mark1)).no_Of_Games)++;
										((players.get(mark2)).no_Of_Games)++;
										((players.get(mark2)).wins)++;
									}
									
								}
							}
							
						}
						else 
						{
							throw new InvalidDataException(type);
						}
					}
					catch(InvalidInputException e)
					{
						System.out.println(e.getMessage());
					}
										
				}
				else 
				{
					if(type.equalsIgnoreCase("removeplayer"))
					{
						player.removePlayer(keyboard);
					}
					else if(type.equalsIgnoreCase("resetstats"))
					{
						player.getPlayer(players);
						player.resetStats(keyboard);
					}
					else if(type.equalsIgnoreCase("displayplayer"))
					{
						player.getPlayer(players);
						player.displayPlayer();
					}
					else if(type.equalsIgnoreCase("rankings"))
					{
						player.getPlayer(players);
						player.displayRankings();
					}
					else if(type.equalsIgnoreCase("exit"))
					{
						player.writeToFile();
						System.out.println();
						end=0;
					}
					else
					{
						throw new InvalidDataException(type);
					}
				}
				

			}
			catch(InvalidDataException e)
			{
				System.out.println(e.getMessage());
			}
								
		}//while loop
		
	}//main
/*
 *compareTo() function is over-rided to sort the players according to the percentage values.
 * 
 */
	@Override
	public int compareTo(Nimsys n) {
		int comparePercentage = ((Nimsys) n).percentage; 
		 
		//ascending order
		return  comparePercentage - this.percentage ;
 
		//descending order
		//return compareQuantity - this.quantity;
	}
	
}//class

