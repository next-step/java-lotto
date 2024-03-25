package domain.lotto;

import controller.lotto.LottoStatistics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserLotto {
    private final List<Lotto> userLotto;

    public static UserLotto from(List<Lotto> userLotto) {
        return new UserLotto(userLotto);
    }

    public UserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLotto userLotto1 = (UserLotto) o;
        return Objects.equals(userLotto, userLotto1.userLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLotto);
    }

    public List<Lotto> lottoList() {
        return this.userLotto;
    }

    public Map<LottoPrize, Integer> createLottoStatistics(WinningLotto winningLotto) {
        Map<LottoPrize, Integer> result = new LinkedHashMap<>();
        userLotto.stream()
                .map(item -> {
                    int count = item.countOfMatch(winningLotto.lotto());
                    boolean isMatchBonusNumber = item.contain(winningLotto.bonusNumber());
                    return LottoPrize.valueOf(count, isMatchBonusNumber);
                })
                .forEach(item -> {
                    Integer count = result.getOrDefault(item, 0);
                    result.put(item, count + 1);
                });
        return result;
    }
}
