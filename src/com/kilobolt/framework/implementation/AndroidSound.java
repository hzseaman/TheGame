package com.kilobolt.framework.implementation;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

import com.kilobolt.framework.Sound;

public class AndroidSound implements Sound {
    int soundId;
    SoundPool soundPool;
    public boolean loaded = false;

    public AndroidSound(SoundPool soundPool, int soundId) {
        this.soundId = soundId;
        this.soundPool = soundPool;
        this.soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
			
			@Override
			public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
				loaded = true;
			}
		});
    }

    @Override
    public void play(float volume) {
    	System.out.println("sound no sound");
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }

    @Override
    public void dispose() {
        soundPool.unload(soundId);
    }

}
