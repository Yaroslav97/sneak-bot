package com.codenjoy.dojo.snakebattle.sneak;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.snakebattle.client.Board;
import com.codenjoy.dojo.snakebattle.model.PointX;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SneakService {

    public static final int SNEAK_MIN_SIZE = 5;
    private static final int MIN = 1;
    private static final int MAX = 28;
    private static final int SNAKE_BASE_SIZE = 3;

    public Direction getRout(Board board) {

        Point sneak = board.getMe();
        PointX location = new PointX(sneak.getX(), sneak.getY());
        PointX appleLocation = findAim(board);

        System.out.println("GOAL - " + board.getAimType(appleLocation));

        RoutService routService = new RoutService();

        if (isDeadLock(board, appleLocation)) {
            return routService.avoidStraitDeadlock(board);
        }

        Direction direction = routService.getDirection(board, sneak, location, appleLocation);

        if (direction != null) {
            return direction;
        }

        Direction safetyWay = routService.findSafetyWay(board);

        System.out.println("exceptional action - " + safetyWay);

        return safetyWay;
    }

    public PointX findAim(Board board) {
        Point sneak = board.getMe();
        PointX location = new PointX(sneak.getX(), sneak.getY());

        Map<Double, PointX> map = new HashMap<>();
        findAllAim(board).forEach(a -> map.put(getPointDist(location, a), a));

        return map.get(map.keySet().stream().mapToDouble(a -> a).min().getAsDouble());
    }

    private List<PointX> findAllAim(Board board) {
        List<PointX> list = new ArrayList<>();

        int mySneakSize = board.getSneakSize();
        int snakeCount = board.getEnemyHeads().size();
        int totalSneakSize = board.getEnemies().size();

        if (snakeCount == 1) {
            System.out.println("Enemy size - " + totalSneakSize);
        }

        for (int x = MIN; x <= MAX; x++) {
            for (int y = MIN; y <= MAX; y++) {
                PointX pointX = new PointX(x, y);

                if (isAimReachable(board, pointX)) {
                    if (board.isApple(x, y) || board.isGold(x, y)) {
                        list.add(pointX);
                    } else if (board.isStone(x, y) && mySneakSize >= SNEAK_MIN_SIZE &&
                            (snakeCount >= 2 || mySneakSize > totalSneakSize * 2)) {
                        list.add(pointX);
                    } else if (board.isStone(x, y) && mySneakSize > SNEAK_MIN_SIZE &&
                            (snakeCount > 2 || mySneakSize > totalSneakSize * 2.5)) {
                        list.add(pointX);
                    } else if (board.isFuryPill(x, y)) {
//                        list.add(pointX);
                    } else if (board.isEnemyHead(x, y)) {
                        if (snakeCount == 1 && mySneakSize - 3 > totalSneakSize) {
                            list.add(pointX);
                        } else if (snakeCount > 1 && mySneakSize - 3 > totalSneakSize - SNAKE_BASE_SIZE * snakeCount) {
                            list.add(pointX);
                        }
                    }
                }
            }
        }
        return list;
    }

    private boolean isDeadLock(Board board, PointX pointX) {
        int wallCount = 0;

        if (board.getDirection() == Direction.UP) {
            if (board.isWall(pointX.getX() + 1, pointX.getY() + 1)
                    && !board.isWall(pointX.getX(), pointX.getY() + 1)) {
                wallCount += 1;
            }
            if (board.isWall(pointX.getX() - 1, pointX.getY() + 1)
                    && !board.isWall(pointX.getX(), pointX.getY() + 1)) {
                wallCount += 1;
            }
        } else if (board.getDirection() == Direction.LEFT) {
            if (board.isWall(pointX.getX() - 1, pointX.getY() + 1)
                    && !board.isWall(pointX.getX() - 1, pointX.getY())) {
                wallCount += 1;
            }
            if (board.isWall(pointX.getX() - 1, pointX.getY() - 1)
                    && !board.isWall(pointX.getX() - 1, pointX.getY())) {
                wallCount += 1;
            }
        } else if (board.getDirection() == Direction.DOWN) {
            if (board.isWall(pointX.getX() - 1, pointX.getY() - 1)
                    && !board.isWall(pointX.getX(), pointX.getY() - 1)) {
                wallCount += 1;
            }
            if (board.isWall(pointX.getX() + 1, pointX.getY() - 1)
                    && !board.isWall(pointX.getX() - 1, pointX.getY() - 1)) {
                wallCount += 1;
            }
        } else if (board.getDirection() == Direction.RIGHT) {
            if (board.isWall(pointX.getX() + 1, pointX.getY() - 1)
                    && !board.isWall(pointX.getX(), pointX.getY() - 1)) {
                wallCount += 1;
            }
            if (board.isWall(pointX.getX(), pointX.getY() - 2)
                    && !board.isWall(pointX.getX(), pointX.getY() - 1)) {
                wallCount += 1;
            }
        }

        return wallCount == 2;
    }

    private boolean isAimReachable(Board board, PointX pointX) {
        int stoneCount = 0;

        if (board.isWall(pointX.getX() + 1, pointX.getY())) {
            stoneCount += 1;
        }
        if (board.isWall(pointX.getX() - 1, pointX.getY())) {
            stoneCount += 1;
        }
        if (board.isWall(pointX.getX(), pointX.getY() + 1)) {
            stoneCount += 1;
        }
        if (board.isWall(pointX.getX(), pointX.getY() - 1)) {
            stoneCount += 1;
        }
        return stoneCount <= 1;
    }

    private double getPointDist(PointX a, PointX b) {
        return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
    }

}
