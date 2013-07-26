package com.yan.snakegame.model;

public class Snake {

	enum SnakeState {
		moveLeft, moveRight, moveUp, moveDown
	}

//	double centerX, centerY; // the centerX and centerY of the head
	double speedX, speedY;
	double width, height;
	SnakeSeg[] snake;
	int snakeSize;
	
	SnakeState state = SnakeState.moveLeft;

	/**
	 * (x, y) is the head position of the head
	 * @param x
	 * @param y
	 * @param snakeSize
	 */
	public Snake(double x, double y, double width, double height ,int snakeSize) {
//		this.centerX = x;
//		this.centerY = y;
		this.snake = new SnakeSeg[snakeSize];
		this.width = width;
		this.height = height;
		this.snakeSize = snakeSize;
		// TODO: currently only allow have the snake on horizontal
		for(int i = 0; i < this.snake.length; i++){
			this.snake[i] = new SnakeSeg(x += width, y, width, height);
		}
		//TODO: the speed should be able to be customized
		this.speedX = width;
		this.speedY = height;
	}
	
	
	private boolean checkState(SnakeState s){		
		return s == this.state;
	}
	
	public SnakeSeg[] updateSnakeBy(int size){
		
		SnakeSeg curTail = this.snake[this.snakeSize - 1];
		this.snakeSize += size;
		SnakeSeg[] tails = new SnakeSeg[size];
		double x = curTail.centerX, 
				y = curTail.centerY, 
				w = curTail.width, 
				h = curTail.height;
		for(int i = 0; i < tails.length; i++){
			// TODO: only horizontal what if not enough space?
			tails[i] = new SnakeSeg(x += w, y, w, h);
			
		}
		SnakeSeg[] newSnake = new SnakeSeg[snakeSize];
		System.arraycopy(this.snake, 0, newSnake, 0, this.snake.length);
		System.arraycopy(tails, 0, newSnake, this.snakeSize, tails.length);
		this.snake = newSnake;		
		return this.snake;
	}
	
	/**
	 * when the snake change its direction
	 * @return
	 */
	private SnakeSeg[] redrawSnake(){
		for(int i = this.snake.length - 1; i >= 0; i++){
			this.snake[i] = this.snake[i - 1];
		}		
		return this.snake;
	}
	
	
	public void move(){
		SnakeSeg head = new SnakeSeg(this.snake[0].centerX, this.snake[0].centerY, 
				this.snake[0].width, this.snake[0].height);
		switch(state){
			case moveLeft:
				head.centerX -= speedX;		
				break;
			
			case moveRight:
				head.centerX += speedX;
				break;
				
			case moveUp:
				head.centerY -= speedY;
				break;
				
			case moveDown:
				head.centerY += speedY;
				break;
				
			//TODO: error?	
		}
		redrawSnake()[0] = head;
	}
	
	public void moveUp(){
		redrawSnake()[0].centerY += this.snake[0].height;
		this.state = SnakeState.moveUp;
	}
	
	public void moveDown(){
		redrawSnake()[0].centerY -= this.snake[0].height;
		this.state = SnakeState.moveDown;
	}	
	
	public void moveLeft(){
		redrawSnake()[0].centerX += this.snake[0].width;
		this.state = SnakeState.moveLeft;
	}
	
	public void moveRight(){
		redrawSnake()[0].centerX -= this.snake[0].width;
		this.state = SnakeState.moveRight;
	}
	
	class SnakeSeg {

		double centerX, centerY, width, height;
		
		public SnakeSeg(double x, double y, double width, double height){
			this.centerX = x;
			this.centerY = y;
			this.width = width;
			this.height = height;
		}
	}
	
}
