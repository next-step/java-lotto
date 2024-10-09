package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBalls {
    List<Integer> lottoBalls = new ArrayList<>();

    public LottoBalls() {
        for (int i = 1; i < 46; i++) {
            lottoBalls.add(i);
        }
    }

    public List<Integer> getLottoBalls(int lottoBallsCount) {
        Collections.shuffle(lottoBalls);
        List<Integer> selectedBalls = lottoBalls.stream().limit(lottoBallsCount).collect(Collectors.toList());
        Collections.sort(selectedBalls);

        return selectedBalls;
    }

}
