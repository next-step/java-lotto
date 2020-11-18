package step02;

import step02.domain.LottoReward;

import java.util.Arrays;
import java.util.List;

public class Mock {
    private Mock() { }

    static final int LOTTO_PRICE = 1000;
    static final int LOTTO_START_NUMBER = 1;
    static final int LOTTO_END_NUMBER = 46;
    static final List<LottoReward> LOTTO_REWARDS = generateLottoRewards();

    static final List<LottoReward> generateLottoRewards() {
        return Arrays.asList(
                LottoReward.of(3, 5_000, 0),
                LottoReward.of(4, 50_000, 0),
                LottoReward.of(5, 1_500_000, 0),
                LottoReward.of(6, 2_000_000_000, 0)
        );
    }

}
