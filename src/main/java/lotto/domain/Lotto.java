package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<LottoBall> lottoBalls;

    public Lotto() {
        this.lottoBalls = new HashSet<>(LottoBall.lottery());
    }

    public Lotto(Set<Integer> lottoBalls) {
        this.lottoBalls = lottoBalls.stream().map(LottoBall::getLottoBall).collect(Collectors.toSet());
    }

    public List<Integer> getLottoNumbers() {
        return lottoBalls.stream().map(LottoBall::getNumber).sorted().collect(Collectors.toList());
    }

    public String getLottoNumbersForPrint() {
        return "[" + lottoBalls.stream().map(LottoBall::toString).collect(Collectors.joining(", ")) + "]";
    }
}
