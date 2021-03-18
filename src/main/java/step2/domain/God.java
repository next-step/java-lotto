package step2.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class God {
    public static Random random = new Random();

    public static List<Integer> issueNumbers(int upperbound, int count) {
        if (count > upperbound) throw new IllegalArgumentException();
        if (count < 0) throw new IllegalArgumentException();
        HashSet<Integer> hashSet = new HashSet<>();
        while (hashSet.size() != count) {
            hashSet.add(random.nextInt(upperbound));
        }
        return new ArrayList<>(hashSet);
    }
}
