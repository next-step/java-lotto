package domain;

import java.util.Arrays;
import java.util.List;

public class Score {
    private static List<Integer> point = Arrays.asList(0, 0, 0, 0, 0, 0, 0);

    public static void plus(int index) {
        point.set(index, point.get(index) + 1);
    }

    public static List<Integer> getPoint() {
        return point;
    }
}
