package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoBall> lottoBalls;

    public Lotto() {
        this.lottoBalls = LottoBall.lottery();
    }

    public List<Integer> getNumbers() {
        return lottoBalls.stream().map(LottoBall::getNumber).collect(Collectors.toList());
    }
}
