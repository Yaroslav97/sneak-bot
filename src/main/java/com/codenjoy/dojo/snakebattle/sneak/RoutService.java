package com.codenjoy.dojo.snakebattle.sneak;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.snakebattle.client.Board;
import com.codenjoy.dojo.snakebattle.model.PointX;

import static com.codenjoy.dojo.snakebattle.sneak.SneakService.SNEAK_MIN_SIZE;

public class RoutService {

    public Direction getDirection(Board board, Point sneak, PointX location, PointX appleLocation) {
        if (location.getX() < appleLocation.getX() && location.getY() < appleLocation.getY()) {
            if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1)) && board.getDirection() == Direction.UP) {
                System.out.println("action - a1");
                return Direction.UP;
            } else if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY())) && board.getDirection() == Direction.RIGHT) {
                System.out.println("action - a2");
                return Direction.RIGHT;
            } else if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY())) && board.getDirection() == Direction.DOWN) {
                System.out.println("action - a3");
                return Direction.RIGHT;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1)) && board.getDirection() == Direction.LEFT) {
                System.out.println("action - a4");
                return Direction.UP;
            }
        }
        if (location.getX() < appleLocation.getX() && location.getY() > appleLocation.getY()) {
            if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY())) && board.getDirection() == Direction.UP) {
                System.out.println("action - b1");
                return Direction.RIGHT;
            } else if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY())) && board.getDirection() == Direction.RIGHT) {
                System.out.println("action - b2");
                return Direction.RIGHT;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1)) && board.getDirection() == Direction.DOWN) {
                System.out.println("action - b3");
                return Direction.DOWN;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1)) && board.getDirection() == Direction.LEFT) {
                System.out.println("action - b4");
                return Direction.DOWN;
            }
        }
        if (location.getX() > appleLocation.getX() && location.getY() < appleLocation.getY()) {
            if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1)) && board.getDirection() == Direction.UP) {
                System.out.println("action - c1");
                return Direction.UP;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1)) && board.getDirection() == Direction.RIGHT) {
                System.out.println("action - c2");
                return Direction.UP;
            } else if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY())) && board.getDirection() == Direction.DOWN) {
                System.out.println("action - c3");
                return Direction.LEFT;
            } else if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY())) && board.getDirection() == Direction.LEFT) {
                System.out.println("action - c4");
                return Direction.LEFT;
            }
        }
        if (location.getX() > appleLocation.getX() && location.getY() > appleLocation.getY()) {
            if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY())) && board.getDirection() == Direction.UP) {
                System.out.println("action - d1");
                return Direction.LEFT;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1)) && board.getDirection() == Direction.RIGHT) {
                System.out.println("action - d2");
                return Direction.DOWN;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1)) && board.getDirection() == Direction.DOWN) {
                System.out.println("action - d3");
                return Direction.DOWN;
            } else if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY())) && board.getDirection() == Direction.LEFT) {
                System.out.println("action - d4");
                return Direction.LEFT;
            }
        }
        if (location.getX() == appleLocation.getX() && location.getY() > appleLocation.getY()) {
            if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY())) && board.getDirection() == Direction.UP) {
                System.out.println("action - e1");
                return Direction.RIGHT;
            } else if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY())) && board.getDirection() == Direction.UP) {
                System.out.println("action - e2");
                return Direction.LEFT;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1)) && board.getDirection() == Direction.RIGHT) {
                System.out.println("action - e3");
                return Direction.DOWN;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1)) && board.getDirection() == Direction.DOWN) {
                System.out.println("action - e4");
                return Direction.DOWN;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1)) && board.getDirection() == Direction.LEFT) {
                System.out.println("action - e5");
                return Direction.DOWN;
            }
        }
        if (location.getX() == appleLocation.getX() && location.getY() < appleLocation.getY()) {
            if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1)) && board.getDirection() == Direction.UP) {
                System.out.println("action - f1");
                return Direction.UP;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1)) && board.getDirection() == Direction.RIGHT) {
                System.out.println("action - f2");
                return Direction.UP;
            } else if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY())) && board.getDirection() == Direction.DOWN) {
                System.out.println("action - f3");
                return Direction.RIGHT;
            } else if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY())) && board.getDirection() == Direction.DOWN) {
                System.out.println("action - f4");
                return Direction.LEFT;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1)) && board.getDirection() == Direction.LEFT) {
                System.out.println("action - f5");
                return Direction.UP;
            }
        }
        if (location.getX() > appleLocation.getX() && location.getY() == appleLocation.getY()) {
            if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY())) && board.getDirection() == Direction.UP) {
                System.out.println("action - g1");
                return Direction.LEFT;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1)) && board.getDirection() == Direction.RIGHT) {
                System.out.println("action - g2");
                return Direction.UP;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1)) && board.getDirection() == Direction.RIGHT) {
                System.out.println("action - g3");
                return Direction.DOWN;
            } else if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY())) && board.getDirection() == Direction.DOWN) {
                System.out.println("action - g4");
                return Direction.LEFT;
            } else if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY())) && board.getDirection() == Direction.LEFT) {
                System.out.println("action - g5");
                return Direction.LEFT;
            }
        }
        if (location.getX() < appleLocation.getX() && location.getY() == appleLocation.getY()) {
            if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY())) && board.getDirection() == Direction.UP) {
                System.out.println("action - j1");
                return Direction.RIGHT;
            } else if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY())) && board.getDirection() == Direction.RIGHT) {
                System.out.println("action - j2");
                return Direction.RIGHT;
            } else if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY())) && board.getDirection() == Direction.DOWN) {
                System.out.println("action - j3");
                return Direction.RIGHT;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1)) && board.getDirection() == Direction.LEFT) {
                System.out.println("action - j4");
                return Direction.UP;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1)) && board.getDirection() == Direction.LEFT) {
                System.out.println("action - j5");
                return Direction.DOWN;
            }
        }
        return null;
    }

    public Direction findSafetyWay(Board board) {
        Point sneak = board.getMe();

        if (board.getDirection() == Direction.RIGHT) {
            if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY()))) {
                return Direction.RIGHT;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1))) {
                return Direction.DOWN;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1))) {
                return Direction.UP;
            }
        } else if (board.getDirection() == Direction.UP) {
            if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1))) {
                return Direction.UP;
            } else if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY()))) {
                return Direction.RIGHT;
            } else if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY()))) {
                return Direction.LEFT;
            }
        } else if (board.getDirection() == Direction.DOWN) {
            if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1))) {
                return Direction.DOWN;
            } else if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY()))) {
                return Direction.LEFT;
            } else if (isSafety(board, new PointX(sneak.getX() + 1, sneak.getY()))) {
                return Direction.RIGHT;
            }
        } else if (board.getDirection() == Direction.LEFT) {
            if (isSafety(board, new PointX(sneak.getX() - 1, sneak.getY()))) {
                return Direction.LEFT;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() + 1))) {
                return Direction.UP;
            } else if (isSafety(board, new PointX(sneak.getX(), sneak.getY() - 1))) {
                return Direction.DOWN;
            }
        }

        System.out.println("action - NO SAFETY WAY");

        return Direction.RIGHT;
    }

    private boolean isSafety(Board board, PointX pointX) {
        if (board.isStone(pointX.getX(), pointX.getY()) && board.getSneakSize() < SNEAK_MIN_SIZE) {
            return false;
        }
        return !board.isBarrierAt(pointX.getX(), pointX.getY());
    }

}
