package application;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Maze Layout		
		char[][] maze ={{'X','X','X','X','X','X','X','X','X','X'},
				  		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
				  		{'X',' ','X','X',' ','X',' ','X',' ','X'},  
				  		{'X',' ','X','X',' ','X',' ','X',' ','X'},  
				  		{'X',' ','X','X',' ','X',' ','X',' ','X'},
				  		{'X',' ',' ',' ',' ',' ',' ','X',' ','X'},  
				  		{'X',' ','X','X',' ','X',' ','X',' ','X'},  
				  		{'X',' ','X','X',' ','X',' ','X',' ','X'},  
				  		{'X',' ','X','X',' ',' ',' ',' ',' ','X'},  
				  		{'X','X','X','X','X','X','X','X','X','X'}
				  	   };

		// Init screen
		GameScreen screen = new GameScreen(maze.length, maze[0].length,maze);

		// Init elements
		GameElement key = new GameElement('K');
		key.addRandomGameElement(screen, key);
		
		GameElement exit = new GameElement('E');
		screen.setObjectOnLocation(exit,9,5);
		
		GameElement dragon = new GameElement('D');
		dragon.addRandomGameElement(screen, dragon);
		
		// Init player
		Hero hero = new Hero('H');
		hero.addRandomLocation(screen, hero);
		
		// Input from player
		Scanner scanner = new Scanner(System.in);
		char input;

		// The game logic starts here
		boolean isRunning = true;

		while (isRunning) {
			screen.PrintScreen();
			// Get input from player and do something
			input = scanner.nextLine().charAt(0);
			switch (input) {
				case 'a':
					hero.moveLeft(screen, hero);
					break;
				case 'd':
					hero.moveRight(screen, hero);
					break;
				case 'w':
					hero.moveUp(screen, hero);
					break;
				case 's':
					hero.moveDown(screen, hero);
					break;
				default: break;
			}
			isRunning = (hero.isFree || hero.isDead) ? false:true;
		}
	}
	
	

}
