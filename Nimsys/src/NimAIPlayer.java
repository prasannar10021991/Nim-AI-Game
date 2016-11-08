import java.util.Scanner;
import java.util.StringTokenizer;

/* 
Class Name: NimAIPlayer

Purpose of Class:  NimAIPlayer class contains the advanced gameplay part of the Nim where the AI players and users take turns to remove one or two stones
 from a common stack at a time until all stones are removed and the player who removes the last stone is considered as the winner and the other player
  is the loser.

Authorship Details :
Name : Prasanna Kumar Ravi
Student ID : 667913
Created on : 01-05-2014
*/


public class NimAIPlayer extends NimGame implements Testable {

	
	private static int initStones,opp,move,mark;	
	private boolean[] stones;
	private static boolean check=false;
	public NimAIPlayer() 
	{
		this.initStones=-1;
		this.opp=-1;
		this.move=-1;
		this.stones= new boolean[0];
	}
	
	public NimAIPlayer(int initial,boolean[] b) 
	{
		this.initStones=initial;
		this.opp=-1;
		this.move=-1;
		this.stones= b;
	}
	
	public String advancedMove(boolean[] available,String lastmove)
	{
		StringTokenizer s = new StringTokenizer(lastmove);
		int i,j,l;
		boolean k=false;
		String value;
		i = Integer.parseInt(s.nextToken());
		j = Integer.parseInt(s.nextToken());
		
		if (i==-1&&j==-1)
		{
			i=0;j=0;
		}
			
		while (k!=true)
		{
			if (initStones >0)
			{
				if(initStones==stones.length)
				{
						check=true;
						mark = 0;
						k=true;
				}
				else if(initStones==1)
				{
					for (l=0;l<available.length;l++)
					{
						if(available[l]==true&&k==false)
						{
							mark=l+1;
							check=false;
							k=true;
						}
					}
					
				}
				else if((j==1)&&initStones>=2)
				{
					for (l=0;l<available.length;l++)
					{
						if (available[l]==true && k==false)
						{
							check=false;
							mark = l+1;
							k=true;
						}
						
					}
				}
				else if(j==2 && initStones>=2)
				{
						for (l=0;l<available.length;l++)
						{
							if (available[l]==true && k==false)
							{
								if(l<(available.length-1))
								{
									if(available[l+1]==true)
									{
										check=true;
										mark = l+1;
										k=true;
									}
								}
								else if(l==(available.length-1))
								{
									check=false;
									for (l=0;l<available.length;l++)
									{
										if((available[l]==true)&&k==false)
										{
											mark = l+1;
											k=true;
										}
										
									}
								}
							}
						}
					}
			}//if
		}//while
		value= mark+" "+check;
		return value;
		
	}

 
	public String playGame(int numberOfStones,String player1,String player2,Scanner keyboard,boolean sim1,boolean sim2) throws InvalidMoveException
	{
		initStones=numberOfStones;
		int k = numberOfStones;
		StringTokenizer aimoves;
		for (int i=0;i<numberOfStones;i++)
		{
			stones[i]=true;
		}
		boolean turn = false;
		
		if(sim1==true && sim2==false)
		{
			while(initStones !=0 )
			{
				try{
					System.out.print("\n"+initStones+" stones left:");
					for(int i=0;i<k;i++)
					{
						System.out.print(" <"+(i+1));
						if(stones[i]==true)
						{
							System.out.print(",*>");
						}
						else 
						{
							System.out.print(",x>");
						}
					}
					if(turn==false && initStones==k)
					{
						System.out.print("\n"+player1.substring(0,player1.indexOf(" "))+"'s turn - 	which to remove?\n");
						String s = opp+" "+move,p;
						p=this.advancedMove(stones,s);
						aimoves=new StringTokenizer(p);
						int movepoint = Integer.parseInt(aimoves.nextToken());
						stones[movepoint]=false;
						stones[movepoint+1]=false;
						initStones= initStones-2;
						
						turn=true;
					}
					else if(turn==false)
					{
						System.out.print("\n"+player1.substring(0,player1.indexOf(" "))+"'s turn - 	which to remove?\n");
						String s = opp+" "+move,p;
						p=this.advancedMove(stones,s);
						aimoves=new StringTokenizer(p);
						int movepoint = Integer.parseInt(aimoves.nextToken());
						boolean b = Boolean.parseBoolean(aimoves.nextToken());
						int stops ; 
						if (b==false)
							{stops=1;}
						else
							{stops=2;}
						if(movepoint<=stones.length&&(stones[movepoint-1]==true))
						{
									if((stops==1))
									{
										stones[movepoint-1]=false;
										initStones= initStones-1;
										opp=movepoint;
										move=stops;
										turn = true;
									}
									else if((stops==2)&&stones[movepoint]==true)
									{
										stones[movepoint-1]=false;
										stones[movepoint]=false;
										initStones= initStones-2;
										opp=movepoint;
										move=stops;
										turn = true;
									}
									else
									{
										throw new InvalidMoveException();
									}
						}
						else
						{
							throw new InvalidMoveException();
						}
					}
					else if(turn==true)
					{
						System.out.print("\n"+player2.substring(0,player2.indexOf(" "))+"'s turn - 	which to remove?\n");
						String s = keyboard.nextLine();
						aimoves=new StringTokenizer(s);
						int movepoint = Integer.parseInt(aimoves.nextToken());
						int stops = Integer.parseInt(aimoves.nextToken()) ; 
						
						if(movepoint<=stones.length&&(stones[movepoint-1]==true))
						{
									if((stops==1))
									{
										stones[movepoint-1]=false;
										initStones= initStones-1;
										opp=movepoint;
										move=stops;
										turn = false;
									}
									else if((stops==2)&&stones[movepoint]==true)
									{
										stones[movepoint-1]=false;
										stones[movepoint]=false;
										initStones= initStones-2;
										opp=movepoint;
										move=stops;
										turn = false;
									}
									else
									{
										throw new InvalidMoveException();
									}
						}
						else
						{
							throw new InvalidMoveException();
						}
						
					}
				}//try
				catch(InvalidMoveException e)
				{
					System.out.println("\n"+e.getMessage());
				}
			} //while loop ends
		}//if 
		
		
		else if(sim1==false && sim2==true)
		{
			turn = true;
			while(initStones !=0 )
			{
				try{
					System.out.print("\n"+initStones+" stones left:");
					for(int i=0;i<k;i++)
					{
						System.out.print(" <"+(i+1));
						if(stones[i]==true)
						{
							System.out.print(",*>");
						}
						else 
						{
							System.out.print(",x>");
						}
					}
					if(turn==false && initStones==k)
					{
						System.out.print("\n"+player2.substring(0,player2.indexOf(" "))+"'s turn - 	which to remove?\n");
						String s = opp+" "+move,p;
						p=this.advancedMove(stones,s);
						aimoves=new StringTokenizer(p);
						int movepoint = Integer.parseInt(aimoves.nextToken());
						stones[movepoint]=false;
						stones[movepoint+1]=false;
						initStones= initStones-2;
						
						turn=true;
					}
					else if(turn==false)
					{
						System.out.print("\n"+player2.substring(0,player2.indexOf(" "))+"'s turn - 	which to remove?\n");
						String s = opp+" "+move,p;
						p=this.advancedMove(stones,s);
						aimoves=new StringTokenizer(p);
						int movepoint = Integer.parseInt(aimoves.nextToken());
						boolean b = Boolean.parseBoolean(aimoves.nextToken());
						int stops ; 
						if (b==false)
							{stops=1;}
						else
							{stops=2;}
	
						if(movepoint<=stones.length&&(stones[movepoint-1]==true))
						{
									if((stops==1))
									{
										stones[movepoint-1]=false;
										initStones= initStones-1;
										opp=movepoint;
										move=stops;
										turn = true;
									}
									else if((stops==2)&&stones[movepoint]==true)
									{
										stones[movepoint-1]=false;
										stones[movepoint]=false;
										initStones= initStones-2;
										opp=movepoint;
										move=stops;
										turn = true;
									}
									else
									{
										throw new InvalidMoveException();
									}
						}
						else
						{
							throw new InvalidMoveException();
						}
					}
					else if(turn==true)
					{
						System.out.print("\n"+player1.substring(0,player2.indexOf(" "))+"'s turn - 	which to remove?\n");
						String s = keyboard.nextLine();
						aimoves=new StringTokenizer(s);
						int movepoint = Integer.parseInt(aimoves.nextToken());
						int stops = Integer.parseInt(aimoves.nextToken()) ; 
						
						if(movepoint<=stones.length&&(stones[movepoint-1]==true))
						{
									if((stops==1))
									{
										stones[movepoint-1]=false;
										initStones= initStones-1;
										opp=movepoint;
										move=stops;
										turn = false;

									}
									else if((stops==2)&&stones[movepoint]==true)
									{
										stones[movepoint-1]=false;
										stones[movepoint]=false;
										initStones= initStones-2;
										opp=movepoint;
										move=stops;
										turn = false;
									}
									else
									{
										throw new InvalidMoveException();
										
									}
						}
						else
						{
							throw new InvalidMoveException();
							
						}
						
					}
				}//try
				catch(InvalidMoveException e)
				{
					System.out.println("\n"+e.getMessage());
				}
				
				if(initStones==0)
				{
					if (turn==false)
					{
						turn=true;
					}
					else
					{
						turn=false;
					}
				}
			} //while loop ends
		}//else if

		else if(sim1==true && sim2==true)
		{//Both the players are AI players
			while(initStones !=0 )
			{
				try{
					System.out.print("\n"+initStones+" stones left:");
					for(int i=0;i<k;i++)
					{
						System.out.print(" <"+(i+1));
						if(stones[i]==true)
						{
							System.out.print(",*>");
						}
						else 
						{
							System.out.print(",x>");
						}
					}
					if(turn==false && initStones==k)
					{
						System.out.print("\n"+player1.substring(0,player1.indexOf(" "))+"'s turn - 	which to remove?\n");
						String s = opp+" "+move,p;
						p=this.advancedMove(stones,s);
						aimoves=new StringTokenizer(p);
						int movepoint = Integer.parseInt(aimoves.nextToken());
						opp = movepoint;
						move=2;
						stones[movepoint]=false;
						stones[movepoint+1]=false;
						initStones= initStones-2;
						
						turn=true;
					}
					else if(turn==false)
					{
						System.out.print("\n"+player1.substring(0,player1.indexOf(" "))+"'s turn - 	which to remove?\n");
						String s = opp+" "+move,p;
						p=this.advancedMove(stones,s);
						aimoves=new StringTokenizer(p);
						int movepoint = Integer.parseInt(aimoves.nextToken());
						boolean b = Boolean.parseBoolean(aimoves.nextToken());
						int stops ; 
						if (b==false)
							{stops=1;}
						else
							{stops=2;}
		
						if(movepoint<=stones.length&&(stones[movepoint-1]==true))
						{
									if((stops==1))
									{
										stones[movepoint-1]=false;
										initStones= initStones-1;
										opp=movepoint;
										move=stops;
										turn = true;
									}
									else if((stops==2)&&stones[movepoint]==true)
									{
										stones[movepoint-1]=false;
										stones[movepoint]=false;
										initStones= initStones-2;
										opp=movepoint;
										move=stops;
										turn = true;
									}
									else
									{
										throw new InvalidMoveException();
									}
						}
						else
						{
							throw new InvalidMoveException();
						}
					}
					else if(turn==true)
					{
						System.out.print("\n"+player2.substring(0,player2.indexOf(" "))+"'s turn - 	which to remove?\n");
						String s = opp+" "+move,p;
						p=this.advancedMove(stones,s);
						aimoves=new StringTokenizer(p);
						int movepoint = Integer.parseInt(aimoves.nextToken());
						boolean b = Boolean.parseBoolean(aimoves.nextToken());
						int stops ; 
						if (b==false)
							{stops=1;}
						else
							{stops=2;}
		
						if(movepoint<=stones.length&&(stones[movepoint-1]==true))
						{
									if((stops==1))
									{
										stones[movepoint-1]=false;
										initStones= initStones-1;
										opp=movepoint;
										move=stops;
										turn = false;
									}
									else if((stops==2)&&stones[movepoint]==true)
									{
										stones[movepoint-1]=false;
										stones[movepoint]=false;
										initStones= initStones-2;
										opp=movepoint;
										move=stops;
										turn = false;
									}
									else
									{
										throw new InvalidMoveException();
									}
						}
						else
						{
							throw new InvalidMoveException();
						}
					}
				}//try
				catch(InvalidMoveException e)
				{
					System.out.println("\n"+e.getMessage());
				}
			} //while loop ends
		}
		else if(sim1==false && sim2==false)
		{//Both players are Users
			while(initStones !=0 )
			{
				try{
					System.out.print("\n"+initStones+" stones left:");
					for(int i=0;i<k;i++)
					{
						System.out.print(" <"+(i+1));
						if(stones[i]==true)
						{
							System.out.print(",*>");
						}
						else 
						{
							System.out.print(",x>");
						}
					}
					if(turn==false)
					{
						System.out.print("\n"+player1.substring(0,player1.indexOf(" "))+"'s turn - which to remove?\n");
						String s = keyboard.nextLine();
						aimoves=new StringTokenizer(s);
						int movepoint = Integer.parseInt(aimoves.nextToken());
						int stops = Integer.parseInt(aimoves.nextToken()) ; 
						
						if(movepoint<=stones.length&&(stones[movepoint-1]==true))
						{
									if((stops==1))
									{
										stones[movepoint-1]=false;
										initStones= initStones-1;
										turn = true;
									}
									else if((stops==2)&&stones[movepoint]==true)
									{
										stones[movepoint-1]=false;
										stones[movepoint]=false;
										initStones= initStones-2;
										turn = true;
									}
									else
									{
										throw new InvalidMoveException();
									}
						}
						else
						{
							throw new InvalidMoveException();
						}
						
					}
					else if(turn==true)
					{
						System.out.print("\n"+player2.substring(0,player2.indexOf(" "))+"'s turn - which to remove?\n");
						String s = keyboard.nextLine();
						aimoves=new StringTokenizer(s);
						int movepoint = Integer.parseInt(aimoves.nextToken());
						int stops = Integer.parseInt(aimoves.nextToken()) ; 
						
						if(movepoint<=stones.length&&(stones[movepoint-1]==true))
						{
									if((stops==1))
									{
										stones[movepoint-1]=false;
										initStones= initStones-1;
										turn = false;
									}
									else if((stops==2)&&stones[movepoint]==true)
									{
										stones[movepoint-1]=false;
										stones[movepoint]=false;
										initStones= initStones-2;
										turn = false;
									}
									else
									{
										throw new InvalidMoveException();
									}
						}
						else
						{
							throw new InvalidMoveException();
						}
						
					}
				}//try
				catch(InvalidMoveException e)
				{
					System.out.println("\n"+e.getMessage());
				}
			} //while loop ends
		}//if 
		
		
		if(initStones==0)
		{
			if(turn==true)
			{
				System.out.println("\nGame Over");
				System.out.println(player1+" wins!");
				return player1;
			}
			else
			{
				System.out.println("\nGame Over");
				System.out.println(player2+" wins!");
				return player2;
			}
		}
		
		else
		{
			return "";
		}
	}	//playGame
	
}
