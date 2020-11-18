package step02;

import step02.domain.LottoReward;
import step02.domain.LottoSeller;

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
                LottoReward.of(3, 5000, 0),
                LottoReward.of(4, 50000, 0),
                LottoReward.of(5, 1500000, 0),
                LottoReward.of(6, 2000000000, 0)
        );
    }

}
