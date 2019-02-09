package com.codenjoy.dojo.snakebattle.client;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.client.WebSocketRunner;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.RandomDice;
import com.codenjoy.dojo.snakebattle.sneak.SneakService;

/**
 * User: your name
 * Это твой алгоритм AI для игры. Реализуй его на свое усмотрение.
 * Обрати внимание на {@see YourSolverTest} - там приготовлен тестовый
 * фреймворк для тебя.
 */
public class YourSolver implements Solver<Board> {

    private static final String URL = "https://game1.epam-bot-challenge.com.ua/codenjoy-contest/board/player/poliakov.yaroslav@gmail.com?code=986626683537736541";

    private Dice dice;
    private Board board;

    public YourSolver(Dice dice) {
        this.dice = dice;
    }

    @Override
    public String get(Board board) {
        this.board = board;
        if (board.isGameOver()) {
            return "GAME OVER";
        }

        SneakService sneakService = new SneakService();

        Point sneak = board.getMe();

        System.out.println("X - " + sneak.getX() + ", Y - " + sneak.getY());
        System.out.println("size - " + board.getSneakSize());
        System.out.println("NEAREST AIM - " + sneakService.findAim(board));
        System.out.println("DIRECTION - " + board.getDirection());

        return sneakService.getRout(board).toString();
    }

    public static void main(String[] args) {
        WebSocketRunner.runClient(
                URL,
                new YourSolver(new RandomDice()),
                new Board());
    }

}
