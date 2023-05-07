package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private static final int MATCH_COUNT_MIN = 3;
    private static final int MATCH_COUNT_MAX = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new RuntimeException("로또 번호의 개수는 6개여야 합니다.");
        }
        this.numbers = numbers;
    }

    public Lotto(String[] before) {
        this(changeDataType(before));
    }

    public Lotto(List<Integer> before) {
        this(changeDataType(before));
    }

    private static Set<LottoNumber> changeDataType(String[] before) {
        Set<LottoNumber> numbers = new HashSet<>();

        for (String s : before) {
            numbers.add(new LottoNumber(s));
        }
        return numbers;
    }

    private static Set<LottoNumber> changeDataType(List<Integer> before) {
        Set<LottoNumber> numbers = new HashSet<>();

        for (int i : before) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }

    public void increaseLottoRewardCount(LottoRewards lottoRewards, WinningLotto winningLotto) {
        if (isNotWinningMatchCountWith(winningLotto.numbers())) {
            return;
        }
        int matchCount = matchCount(winningLotto.numbers());
        boolean isMatchWithBonus = isMatchWith(winningLotto.bonusNumber());
        RewardType rewardType = RewardType.of(matchCount, isMatchWithBonus);

        lottoRewards.increaseCountOf(rewardType);
    }

    private boolean isNotWinningMatchCountWith(Lotto numbers) {
        return MATCH_COUNT_MIN > matchCount(numbers) || MATCH_COUNT_MAX < matchCount(numbers);
    }

    int matchCount(Lotto numbers) {
        List<LottoNumber> matchLotto = new ArrayList<>(this.numbers);
        matchLotto.retainAll(numbers.value());

        return matchLotto.size();
    }

    boolean isMatchWith(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public Set<LottoNumber> value() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
