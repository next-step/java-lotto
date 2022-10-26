package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import service.LottoIssueMachine;
import service.RandomLottoGenerator;

class LottoResultTest {

    private static final int MATCH_FOUND_COUNT = 1;

    private static final double EXPECT_SECOND_RANK_EARNING_RATE = 1500.0;

    private static final Lotto WINNER_NUMBER = Lotto.from("1, 2, 3, 4, 5, 6");

    private static final String BONUS_NUMBER = "7";

    private static final Lotto EXPECT_SECOND_RANKED_NUMBER = Lotto.from("1, 2, 3, 4, 5, 8");

    private BonusNumber bonusNumber;

    private LottoResult lottoResult;

    private Lottos lottos;

    private RandomLottoGenerator randomLottoGenerator;

    private LottoIssueMachine lottoIssueMachine;

    private Money purchaseMoney;

    @BeforeEach
    void setUp() {
        lottos = new Lottos();
        randomLottoGenerator = new RandomLottoGenerator();
        lottoIssueMachine = new LottoIssueMachine(randomLottoGenerator);
        lottoResult = new LottoResult();
        bonusNumber = new BonusNumber(BONUS_NUMBER);

        purchaseMoney = Money.from(1000);

        lottos.getLottoNumbers().add(EXPECT_SECOND_RANKED_NUMBER);
    }

    @Test
    @DisplayName("일치하는 로또번호를 제대로 갱신하는지 확인하는 테스트")
    void 일치하는_로또번호를_제대로_갱신하는지_확인하는_테스트() {

        lottoResult.findMatchLottoCount(WINNER_NUMBER, lottos, bonusNumber);

        assertThat(lottoResult.getMatchFoundCount().size()).isEqualTo(MATCH_FOUND_COUNT);

    }

    @Test
    @DisplayName("기대수익금을 제대로 계산하는지 테스트")
    void 기대수익금을_제대로_계산하는지_테스트() {

        lottoResult.findMatchLottoCount(WINNER_NUMBER, lottos, bonusNumber);

        double expectExpectMoney = lottoResult.calculateEarningRate(purchaseMoney);

        assertThat(expectExpectMoney).isEqualTo(EXPECT_SECOND_RANK_EARNING_RATE);

    }

}