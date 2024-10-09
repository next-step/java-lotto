package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final List<Integer> LottoBalls;
    private final int LOTTO_BALLS_COUNT = 6;
    public LottoGenerator() {
        LottoBalls = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            LottoBalls.add(i);
        }
    }
    public List<Integer> generate() {
        List<Integer> lottoBalls = getLottoBalls(LOTTO_BALLS_COUNT);
        System.out.println(lottoBalls.toString());
        return lottoBalls;
    }


    private List<Integer> getLottoBalls(int lottoBallsCount) {
        Collections.shuffle(LottoBalls);
        List<Integer> selectedBalls = LottoBalls.stream().limit(lottoBallsCount).collect(Collectors.toList());
        Collections.sort(selectedBalls);

        return selectedBalls;
    }
}
