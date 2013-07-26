package com.yan.samplegame;

import com.kilobolt.framework.Screen;
import com.kilobolt.framework.implementation.AndroidGame;

public class SampleGame extends AndroidGame {

	@Override
	public Screen getInitScreen() {
		// TODO Auto-generated method stub
		return new LoadingScreen(this); 
	}

}
