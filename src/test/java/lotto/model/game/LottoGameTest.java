package lotto.model.game;

import lotto.model.Money;
import lotto.model.gameresult.GameResult;
import lotto.model.mylottos.LottoNumbers;
import lotto.model.mylottos.MyLottos;
import lotto.model.winninglotto.BonusBall;
import lotto.model.winninglotto.WinningLotto;
import lotto.model.winninglotto.WinningLottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.model.Rank.FIRST;
import static lotto.model.Rank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private final Money money = new Money(2000l);
    private final WinningLottoNumbers WINNING_LOTTO_NUMBERS = new WinningLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
    private final int BONUS_BALL_NUMBER = 9;
    private final WinningLotto WINNING_LOTTO
            = new WinningLotto(WINNING_LOTTO_NUMBERS, new BonusBall(BONUS_BALL_NUMBER));

    private LottoNumbers lottoNumbers1;
    private LottoNumbers lottoNumbers2;

    @BeforeEach
    void setUp() {
        lottoNumbers1 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumbers2 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, BONUS_BALL_NUMBER));
    }

    @DisplayName("로또 게임의 getResult 메소드를 호출하면, 각각의 Rank에 몇 개의 로또가 당첨되었는지 알 수 있다.")
    @Test
    void getResultTest() {
        //given
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers1, lottoNumbers2));
        LottoGame lottoGame = new LottoGame(money.findLottoCountToBuy(), myLottos);

        //when
        GameResult result = lottoGame.getResult(WINNING_LOTTO);

        //then
        assertThat(result.getMatchingResult().findMatchCount(FIRST)).isEqualTo(1l);
        assertThat(result.getMatchingResult().findMatchCount(SECOND)).isEqualTo(1l);
    }

    @DisplayName("로또 게임의 getResult 메소드를 호출하면, earningRate를 알 수 있다.")
    @Test
    void getEarningRateTest() {
        //given
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers1, lottoNumbers2));
        LottoGame lottoGame = new LottoGame(money.findLottoCountToBuy(), myLottos);

        //when
        GameResult result = lottoGame.getResult(WINNING_LOTTO);

        //then
        assertThat(result.getEarningRate().getEarningRate()).isEqualTo(101500000);
    }
}