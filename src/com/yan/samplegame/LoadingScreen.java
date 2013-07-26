package com.yan.samplegame;

import com.kilobolt.framework.Game;
import com.kilobolt.framework.Graphics;
import com.kilobolt.framework.Screen;
import com.kilobolt.framework.Graphics.ImageFormat;
import com.kilobolt.framework.implementation.AndroidSound;

public class LoadingScreen extends Screen {
	public LoadingScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		Assets.click = game.getAudio().createSound("explode.ogg");
		while(!((AndroidSound)Assets.click).loaded){
			Assets.click.play(50);
		}
		Assets.menu = g.newImage("menu.jpg", ImageFormat.RGB565);

		game.setScreen(new MainMenuScreen(game));

	}

	@Override
	public void paint(float deltaTime) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {

	}
}
