package com.yan.snakegame;

import com.kilobolt.framework.Screen;
import com.kilobolt.framework.implementation.AndroidGame;

public class StartingClass extends AndroidGame {

	@Override
	public Screen getInitScreen() {
		// TODO Auto-generated method stub
		return new LoadingScreen(this);
	}

}
