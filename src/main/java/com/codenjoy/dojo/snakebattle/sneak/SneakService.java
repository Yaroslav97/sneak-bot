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

    public Direction getRout(Board board) {

        Point sneak = board.getMe();
        PointX location = new PointX(sneak.getX(), sneak.getY());
        PointX appleLocation = findApple(board);

        System.out.println("GOAL - " + board.getAimType(appleLocation));

        RoutService routService = new RoutService();

        Direction direction = routService.getDirection(board, sneak, location, appleLocation);

        if (direction != null) {
            return direction;
        }

        Direction safetyWay = routService.findSafetyWay(board);

        System.out.println("exceptional action - " + safetyWay);

        return safetyWay;
    }

    public PointX findApple(Board board) {
        Point sneak = board.getMe();
        PointX location = new PointX(sneak.getX(), sneak.getY());

        Map<Double, PointX> map = new HashMap<>();
        findAllApple(board).forEach(a -> map.put(getPointDist(location, a), a));

        return map.get(map.keySet().stream().mapToDouble(a -> a).min().getAsDouble());
    }

    private List<PointX> findAllApple(Board board) {
        List<PointX> list = new ArrayList<>();

        int mySneakSize = board.getSneakSize();
        int snakeCount = board.getEnemyHeads().size();
        int totalSneakSize = board.getEnemies().size();

        for (int x = MIN; x < MAX; x++) {
            for (int y = MIN; y < MAX; y++) {
                PointX pointX = new PointX(x, y);

                if (isAimReachable(board, pointX)) {
                    if (board.isApple(x, y) || board.isGold(x, y)) {
                        list.add(pointX);
                    } else if (board.isStone(x, y) && mySneakSize >= SNEAK_MIN_SIZE &&
                            (snakeCount >= 2 || mySneakSize > totalSneakSize * 2)) {
                        list.add(pointX);
                    } else if (board.isEnemyHead(x, y)) {
                        if (snakeCount == 1 && mySneakSize > totalSneakSize) {
                            list.add(pointX);
                        } else if (snakeCount == 2 && mySneakSize - 2 > totalSneakSize - 3) {
                            list.add(pointX);
                        }
                    }
                }
            }
        }
        return list;
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
