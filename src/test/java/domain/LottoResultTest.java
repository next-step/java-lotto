package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import view.ResultView;

class LottoResultTest {

    private static final int MATCH_FOUND_COUNT = 1;

    private static final double FULL_MATCH_EARNING_RATE = 2000000.0;

    private static final Lotto WINNER_NUMBER = Lotto.from("1, 2, 3, 4, 5, 6");

    private static final Lotto NO_MATCH_NUMBER = Lotto.from("13, 14, 15, 16, 17, 18");

    private LottoResult lottoResult;

    private Lottos randomLottoList = new Lottos();

    private Money purchaseMoney;

    private ResultView resultView;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        resultView = new ResultView();

        Lotto randomLotto1 = Lotto.from("1, 2, 3, 4, 5, 6");
        Lotto randomLotto2 = Lotto.from("7, 8, 9, 10, 11, 12");

        purchaseMoney = Money.from(1000);

        randomLottoList.addLotto(randomLotto1);
        randomLottoList.addLotto(randomLotto2);

    }

    @Test
    @DisplayName("맞는 로또의 갯수를 카운트 하는 테스트")
    void 당첨번호와_맞는_로또의_갯수가_몇개인지_확인하는_테스트() {

        lottoResult.findMatchLottoCount(WINNER_NUMBER, randomLottoList);

        assertThat(lottoResult.getMatchFoundCount()[WINNER_NUMBER.getLotto().size()]).isEqualTo(MATCH_FOUND_COUNT);
    }

    @Test
    @DisplayName("당첨금과 비교하여 수익률 계산하는 테스트")
    void 당첨금과_비교하여_수익률_계산하는_테스트() {

        lottoResult.findMatchLottoCount(WINNER_NUMBER, randomLottoList);

        double result = lottoResult.calculateEarningRate(purchaseMoney);

        assertThat(result).isEqualTo(FULL_MATCH_EARNING_RATE);
    }

    @Test
    @DisplayName("수익률이 1 미만일시 손실 메시지 출력하는지 테스트")
    void 수익률이_1_미만일시_손실_메시지_출력하는지_테스트() {

        lottoResult.findMatchLottoCount(NO_MATCH_NUMBER, randomLottoList);

        double result = lottoResult.calculateEarningRate(purchaseMoney);

        String message = ResultView.lossMessageFormat(result);

        assertThat(message).isNotEmpty();
    }
}