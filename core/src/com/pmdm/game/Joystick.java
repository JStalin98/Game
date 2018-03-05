package com.pmdm.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;

/**
 * Created by JStalin on 05/03/2018.
 */

public class Joystick extends Touchpad {

    private static Skin touchpadSkin;
    private static TouchpadStyle touchpadStyle;

    public Joystick(){
        super(20, Joystick.getTouchPadStyle());
        setBounds(50, 50,50,50);
    }

    private static TouchpadStyle getTouchPadStyle(){
        touchpadSkin = new Skin();
        touchpadSkin.add("touchBackground", new Texture("bg_joystick.png"));
        touchpadSkin.add("touchKnob", new Texture("joystick.png"));

        touchpadStyle = new TouchpadStyle();
        touchpadStyle.background = touchpadSkin.getDrawable("touchBackground");
        touchpadStyle.knob = touchpadSkin.getDrawable("touchKnob");
        return touchpadStyle;
    }


    @Override
    public void act (float delta) {
        super.act(delta);
        if(isTouched()){
            // Mover al personaje o cualquier otra cosa que quieras hacer
        }
    }


}


