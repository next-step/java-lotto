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
        return this.lottoBalls.stream().map(LottoBall::getNumber).sorted().collect(Collectors.toList());
    }

    public int matchWinningCount(Set<LottoBall> winningNumbers) {
        Set<LottoBall> matchCheckSet = new HashSet<>(winningNumbers);
        matchCheckSet.retainAll(this.lottoBalls);
        return matchCheckSet.size();
    }

    public boolean isMatchBonus(LottoBall bonusNumber) {
        return this.lottoBalls.stream().anyMatch(lottoBall -> lottoBall.isSameBall(bonusNumber));
    }
}
