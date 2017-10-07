package application;

//TEst change
public class Hero extends GameObject {

	private boolean hasKey = false;
	public boolean isFree = false;
	public boolean isDead = false;
	
	public Hero(char symbol) {
		setSymbol(symbol);
	}
	
	public void addRandomLocation(GameScreen screen, Hero hero) {
		int x =0,y =0;
		boolean valid = false;
		//check if valid position
		while(!valid){
			//Generate random positions
			x = (int) (Math.random() * (screen.getScreenWidth() - 1));
			y = (int) (Math.random() * (screen.getScreenHeight() - 1));
			//Check if position is valid
			valid = screen.locationIsValid(x,y);
		}
		hero.setX(x);
		hero.setY(y);
		screen.setObjectOnLocation(hero,x,y);
	}
	
	private void moveHero(GameScreen screen, Hero hero, int x, int y, int x_old, int y_old){
		//Check if there is a Dragon waiting...
		if(screen.nearDragon(x,y)){
			//Is eaten by dragon - GAME OVER!
			hero.isDead = true;
			transformHero(screen,hero,'-');
			screen.PrintGameOver();
		}
			switch (screen.getObjectOnLocation(x,y)){
				case 'X':   //Hits a wall!
							break;		
							
				case 'E': 	//If he has the key he can exit - GAME COMPLETED!
							if(hero.hasKey) {hero.isFree = true;screen.PrintGameCompleted();transformHero(screen,hero,'o');}
							else {screen.PrintExitClose();break;}
							
				case 'K':	//Gets the key!
							hero.hasKey = true;
							
				default: 	hero.setX(x);
							hero.setY(y);
							screen.setObjectOnLocation(hero,x,y);
							screen.ClearScreenLocation(x_old, y_old);
							break;
			}
		
	}
	
	public void moveLeft(GameScreen screen, Hero hero) {
		moveHero(screen,hero,hero.getX()-1,hero.getY(),hero.getX(),hero.getY());
	}
	
	public void moveRight(GameScreen screen, Hero hero) {
		moveHero(screen,hero,hero.getX() + 1,hero.getY(),hero.getX(),hero.getY());
	}
	
	public void moveUp(GameScreen screen, Hero hero) {
		moveHero(screen,hero,hero.getX(),hero.getY()-1,hero.getX(),hero.getY());
	}
	
	public void moveDown(GameScreen screen, Hero hero) {
		moveHero(screen,hero,hero.getX(),hero.getY()+1,hero.getX(),hero.getY());
	}
	
	public void transformHero(GameScreen screen,Hero hero, char symbol) {
		screen.clearHero(hero,symbol);
		hero.setSymbol(symbol);
	}
}
