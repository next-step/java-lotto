package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBalls {
    private final List<Integer> lottoBalls;

    public LottoBalls() {
        this.lottoBalls = createLottoBalls();
    }

    private List<Integer> createLottoBalls() {
        List<Integer> balls = new ArrayList<>();
        for (int i = 1; i <= 45; i++) { // 1부터 45까지 추가
            balls.add(i);
        }
        return balls;
    }

    public List<Integer> getLottoBalls(int lottoBallsCount) {
        Collections.shuffle(lottoBalls);
        List<Integer> selectedBalls = lottoBalls.stream()
                .limit(lottoBallsCount)
                .sorted()
                .collect(Collectors.toUnmodifiableList());

        return selectedBalls;
    }

}
