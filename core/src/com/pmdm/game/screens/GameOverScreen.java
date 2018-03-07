/*
 * This file is part of Jump Don't Die
 * Copyright (C) 2015 Dani Rodríguez <danirod@outlook.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.pmdm.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.pmdm.game.MyGame;


/**
 * Clase que muestra una pantalla indicando que ha terminado el juego
 */
public class GameOverScreen extends BaseScreen {


    // Escenario de la pantalla
    private Stage stage;


    // Skin que contiene la apariencia
    private Skin skin;


    // Botones
    private TextButton retry, menu;

    public GameOverScreen(final MyGame game) {
        super(game);


        stage = new Stage(new FitViewport(640, 360));


        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));


        retry = new TextButton("Retry", skin);
        menu = new TextButton("Menu", skin);


        retry.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                game.setScreen(game.gameScreen);
            }
        });

        menu.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                game.setScreen(game.menuScreen);
            }
        });


        retry.setSize(200, 80);
        menu.setSize(200, 80);
        retry.setPosition(60, 50);
        menu.setPosition(380, 50);


        stage.addActor(retry);
        stage.addActor(menu);
    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {

        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {

        skin.dispose();
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}
