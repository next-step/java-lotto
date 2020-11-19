package step02;

import step02.domain.Lotto;
import step02.domain.LottoNumber;
import step02.domain.LottoReward;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mock {
    private Mock() { }

    static final int LOTTO_PRICE = 1000;
    static final int LOTTO_START_NUMBER = 1;
    static final int LOTTO_END_NUMBER = 46;
    static final List<LottoReward> LOTTO_REWARDS = makeLottoRewards();

    public static final List<LottoReward> makeLottoRewards() {
        return Arrays.asList(
                LottoReward.of(3, 5_000, 0),
                LottoReward.of(4, 50_000, 0),
                LottoReward.of(5, 1_500_000, 0),
                LottoReward.of(6, 2_000_000_000, 0)
        );
    }

    public static final List<LottoNumber> makeWinningNumbers() {
        return makeLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    public static final List<LottoNumber> makeLotto(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> LottoNumber.of(number))
                .collect(Collectors.toList());
    }

    public static final List<Lotto> makeLottos() {
        return Arrays.asList(
                Lotto.of(makeLotto(Arrays.asList(8, 21, 23, 41, 42, 43))),
                Lotto.of(makeLotto(Arrays.asList(3, 5, 11, 16, 32, 38))),
                Lotto.of(makeLotto(Arrays.asList(7, 11, 16, 35, 36, 44))),
                Lotto.of(makeLotto(Arrays.asList(1, 8, 11, 31, 41, 42))),
                Lotto.of(makeLotto(Arrays.asList(13, 14, 16, 38, 42, 45))),
                Lotto.of(makeLotto(Arrays.asList(7, 11, 30, 40, 42, 43))),
                Lotto.of(makeLotto(Arrays.asList(2, 13, 22, 32, 38, 45))),
                Lotto.of(makeLotto(Arrays.asList(23, 25, 33, 36, 39, 41))),
                Lotto.of(makeLotto(Arrays.asList(1, 3, 5, 14, 22, 45))),
                Lotto.of(makeLotto(Arrays.asList(5, 9, 38, 41, 43, 44))),
                Lotto.of(makeLotto(Arrays.asList(2, 8, 9, 18, 19, 21))),
                Lotto.of(makeLotto(Arrays.asList(13, 14, 18, 21, 23, 35))),
                Lotto.of(makeLotto(Arrays.asList(17, 21, 29, 37, 42, 45))),
                Lotto.of(makeLotto(Arrays.asList(3, 8, 27, 30, 35, 44)))
        );
    }



}
