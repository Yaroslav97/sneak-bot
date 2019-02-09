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
import com.codenjoy.dojo.snakebattle.model.PointX;

import java.util.List;

import static com.codenjoy.dojo.snakebattle.model.Elements.APPLE;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_HORIZONTAL;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_LEFT_DOWN;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_LEFT_UP;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_RIGHT_DOWN;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_RIGHT_UP;
import static com.codenjoy.dojo.snakebattle.model.Elements.BODY_VERTICAL;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_BODY_HORIZONTAL;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_BODY_LEFT_DOWN;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_BODY_LEFT_UP;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_BODY_RIGHT_DOWN;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_BODY_RIGHT_UP;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_BODY_VERTICAL;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_HEAD_DOWN;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_HEAD_LEFT;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_HEAD_RIGHT;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_HEAD_SLEEP;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_HEAD_UP;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_TAIL_END_DOWN;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_TAIL_END_LEFT;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_TAIL_END_RIGHT;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_TAIL_END_UP;
import static com.codenjoy.dojo.snakebattle.model.Elements.ENEMY_TAIL_INACTIVE;
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

    public boolean isEnemyHead(int x, int y) {
        return isAt(x, y, ENEMY_HEAD_DOWN, ENEMY_HEAD_UP, ENEMY_HEAD_RIGHT, ENEMY_HEAD_LEFT);
    }

    public List<Point> getEnemyHeads() {
        return get(ENEMY_HEAD_DOWN, ENEMY_HEAD_UP, ENEMY_HEAD_RIGHT, ENEMY_HEAD_LEFT);
    }

    public List<Point> getEnemies() {
        return get(ENEMY_HEAD_DOWN, ENEMY_HEAD_UP, ENEMY_HEAD_RIGHT, ENEMY_HEAD_LEFT,
                ENEMY_TAIL_END_DOWN, ENEMY_TAIL_END_LEFT, ENEMY_TAIL_END_UP, ENEMY_TAIL_END_RIGHT, ENEMY_TAIL_INACTIVE,
                ENEMY_BODY_HORIZONTAL, ENEMY_BODY_VERTICAL, ENEMY_BODY_LEFT_DOWN,
                ENEMY_BODY_LEFT_UP, ENEMY_BODY_RIGHT_DOWN, ENEMY_BODY_RIGHT_UP);
    }

    public boolean isGold(int x, int y) {
        return isAt(x, y, GOLD);
    }

    public boolean isFuryPill(int x, int y) {
        return isAt(x, y, FURY_PILL);
    }

    public boolean isStone(int x, int y) {
        return isAt(x, y, STONE);
    }

    public boolean isWall(int x, int y) {
        return isAt(x, y, WALL);
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

    public Direction getEnemyDirection(PointX pointX) {

        List<Point> up = get(ENEMY_HEAD_UP);
        List<Point> down = get(ENEMY_HEAD_DOWN);
        List<Point> right = get(ENEMY_HEAD_RIGHT);
        List<Point> left = get(ENEMY_HEAD_LEFT);

        if (!up.isEmpty()) {
            Point point = up.get(0);
            PointX sneak = new PointX(point.getX(), point.getY());

            if (pointX.equals(sneak) && isAt(point.getX(), point.getY(), ENEMY_HEAD_UP)) {
                return Direction.UP;
            }
        } else if (!down.isEmpty()) {
            Point point = down.get(0);
            PointX sneak = new PointX(point.getX(), point.getY());

            if (pointX.equals(sneak) && isAt(point.getX(), point.getY(), ENEMY_HEAD_DOWN)) {
                return Direction.DOWN;
            }
        } else if (!right.isEmpty()) {
            Point point = right.get(0);
            PointX sneak = new PointX(point.getX(), point.getY());

            if (pointX.equals(sneak) && isAt(point.getX(), point.getY(), ENEMY_HEAD_RIGHT)) {
                return Direction.RIGHT;
            }
        } else if (!left.isEmpty()) {
            Point point = left.get(0);
            PointX sneak = new PointX(point.getX(), point.getY());

            if (pointX.equals(sneak) && isAt(point.getX(), point.getY(), ENEMY_HEAD_LEFT)) {
                return Direction.LEFT;
            }
        }
        return Direction.STOP;
    }

    private List<Point> getMyHead() {
        return get(HEAD_DOWN, HEAD_LEFT, HEAD_RIGHT, HEAD_UP, HEAD_SLEEP, HEAD_EVIL, HEAD_FLY);
    }

    public boolean isFuryActive() {
        return !get(HEAD_EVIL).isEmpty();
    }

    public int getSneakSize() {
        return getMySneak().size();
    }

    public List<Point> getMySneak() {
        return get(HEAD_DOWN, HEAD_LEFT, HEAD_RIGHT, HEAD_UP, HEAD_SLEEP, HEAD_EVIL, HEAD_FLY,
                TAIL_END_DOWN, TAIL_END_UP, TAIL_END_RIGHT, TAIL_END_UP, TAIL_INACTIVE,
                BODY_HORIZONTAL, BODY_VERTICAL, BODY_RIGHT_UP, BODY_RIGHT_DOWN, BODY_LEFT_UP, BODY_LEFT_DOWN);
    }

    public String getAimType(PointX pointX) {

        if (isApple(pointX.getX(), pointX.getY())) {
            return "APPLE";
        } else if (isStone(pointX.getX(), pointX.getY())) {
            return "STONE";
        } else if (isGold(pointX.getX(), pointX.getY())) {
            return "GOLD";
        } else if (isEnemyHead(pointX.getX(), pointX.getY())) {
            return "ENEMY_HEAD";
        } else if (isFuryPill(pointX.getX(), pointX.getY())) {
            return "FURY_PILL";
        }

        return "undefined";
    }

}
