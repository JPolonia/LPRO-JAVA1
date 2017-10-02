package application;


public class GameScreen {

	private int width, height;
	private char[][] screenMatrix;

	public GameScreen(int width, int height,char[][] screenMatrix) {
		this.width = width;
		this.height = height;
		this.screenMatrix = screenMatrix;
	}

	// Fill array with dots
	public void InitScreen() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				this.screenMatrix[i][j] = '.';
			}
		}
	}

	// Print the screen to console
	public void PrintScreen() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				System.out.print(this.screenMatrix[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public void PrintExitClose(){
		System.out.println("YOU NEED A KEY!!");
	}
	
	//Game Completed
	public void PrintGameCompleted() {
		System.out.println("YOU GOT OUT! ENJOY YOUR FREEDOM!!");
	}
	//Game Over
	public void PrintGameOver() {
		System.out.println("YOU GOT EATEN BY AN HUNGRY DRAGON!!");
	}
	
	//Screen clear location
	public void ClearScreenLocation(int x, int y) {
		this.screenMatrix[y][x] = ' ';
	}

	// Getters
	public int getScreenWidth() {
		return this.width;
	}

	public int getScreenHeight() {
		return this.height;
	}

	public char getObjectOnLocation(int x, int y) {
		return this.screenMatrix[y][x];
	}
	
	//Check if dragon in near
	public boolean nearDragon(int x, int y) {
		if (x>0) if (this.screenMatrix[y][x-1] == 'D') return true;
		if (x<9) if (this.screenMatrix[y][x+1] == 'D') return true;
		if (y<9) if (this.screenMatrix[y+1][x] == 'D') return true;
		if (y>0) if (this.screenMatrix[y-1][x] == 'D') return true;
		return false;
	}
	
	
	public boolean locationIsValid(int x, int y) {
		//Check if there is already an object
		if (this.screenMatrix[y][x] != ' ' ) return false;
		
		//Check if it is near Dragon
		if (nearDragon(x,y)) return false;
		
		return true;
	}

	// Setters
	public void setObjectOnLocation(GameObject object, int x, int y) {
		this.screenMatrix[y][x] = object.getSymbol();
	}
	
	public void clearHero(Hero hero, char newSymbol) {
		this.screenMatrix[hero.getY()][hero.getX()] = newSymbol;
	}
}
