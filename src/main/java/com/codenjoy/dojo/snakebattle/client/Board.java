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


import com.codenjoy.dojo.client.AbstractBoard;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.snakebattle.model.Elements;

import java.util.List;

import static com.codenjoy.dojo.snakebattle.model.Elements.APPLE;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_HORIZONTAL;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_LEFT_DOWN;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_LEFT_UP;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_RIGHT_DOWN;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_RIGHT_UP;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_VERTICAL;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_HEAD_SLEEP;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_TAIL_INACTIVE;
import static com.codenjoy.dojo.snakebattle.model.Elements.FLYING_PILL;
import static com.codenjoy.dojo.snakebattle.model.Elements.FURY_PILL;
import static com.codenjoy.dojo.snakebattle.model.Elements.GOLD;
import static com.codenjoy.dojo.snakebattle.model.Elements.HEAD_DOWN;
import static com.codenjoy.dojo.snakebattle.model.Elements.HEAD_EVIL;
import static com.codenjoy.dojo.snakebattle.model.Elements.HEAD_FLY;
import static com.codenjoy.dojo.snakebattle.model.Elements.HEAD_LEFT;
import static com.codenjoy.dojo.snakebattle.model.Elements.HEAD_RIGHT;
import static com.codenjoy.dojo.snakebattle.model.Elements.HEAD_SLEEP;
import static com.codenjoy.dojo.snakebattle.model.Elements.HEAD_UP;
import static com.codenjoy.dojo.snakebattle.model.Elements.START_FLOOR;
import static com.codenjoy.dojo.snakebattle.model.Elements.STONE;
import static com.codenjoy.dojo.snakebattle.model.Elements.TAIL_END_DOWN;
import static com.codenjoy.dojo.snakebattle.model.Elements.TAIL_END_RIGHT;
import static com.codenjoy.dojo.snakebattle.model.Elements.TAIL_END_UP;
import static com.codenjoy.dojo.snakebattle.model.Elements.TAIL_INACTIVE;
import static com.codenjoy.dojo.snakebattle.model.Elements.WALL;

/**
 * Класс, обрабатывающий строковое представление доски.
 * Содержит ряд унаследованных методов {@see AbstractBoard},
 * но ты можешь добавить сюда любые свои методы на их основе.
 */
public class Board extends AbstractBoard<Elements> {

    @Override
    public Elements valueOf(char ch) {
        return Elements.valueOf(ch);
    }

    public boolean isBarrierAt(int x, int y) {
        return isAt(x, y, WALL, START_FLOOR, ENEMY_HEAD_SLEEP, ENEMY_TAIL_INACTIVE, TAIL_INACTIVE);
    }

    public boolean isApple(int x, int y) {
        return isAt(x, y, APPLE);
    }

    public boolean isGold(int x, int y) {
        return isAt(x, y, GOLD);
    }

    public boolean isPill(int x, int y) {
        return isAt(x, y, FURY_PILL, FLYING_PILL);
    }

    public boolean isStone(int x, int y) {
        return isAt(x, y, STONE);
    }

    @Override
    protected int inversionY(int y) {
        return size - 1 - y;
    }

    public Point getMe() {
        return getMyHead().get(0);
    }

    public boolean isGameOver() {
        return getMyHead().isEmpty();
    }

    public Direction getDirection() {
        if (!get(HEAD_DOWN).isEmpty()) {
            return Direction.DOWN;
        } else if (!get(HEAD_UP).isEmpty()) {
            return Direction.UP;
        } else if (!get(HEAD_RIGHT).isEmpty()) {
            return Direction.RIGHT;
        } else if (!get(HEAD_LEFT).isEmpty()) {
            return Direction.LEFT;
        }
        return Direction.STOP;
    }

    private List<Point> getMyHead() {
        return get(HEAD_DOWN, HEAD_LEFT, HEAD_RIGHT, HEAD_UP, HEAD_SLEEP, HEAD_EVIL, HEAD_FLY);
    }

    public int getSneakSize() {
        return get(HEAD_DOWN, HEAD_LEFT, HEAD_RIGHT, HEAD_UP, HEAD_SLEEP, HEAD_EVIL, HEAD_FLY,
                TAIL_END_DOWN, TAIL_END_UP, TAIL_END_RIGHT, TAIL_END_UP, TAIL_INACTIVE,
                BODY_HORIZONTAL, BODY_VERTICAL, BODY_RIGHT_UP, BODY_RIGHT_DOWN, BODY_LEFT_UP, BODY_LEFT_DOWN).size();
    }

    public boolean isStoneAt(int x, int y) {
        return isAt(x, y, STONE);
    }
}
