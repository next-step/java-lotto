package lotto.model.game;

import lotto.model.Money;
import lotto.model.gameresult.GameResult;
import lotto.model.gameresult.MatchingResult;
import lotto.model.lottonumber.LottoNumber;
import lotto.model.lottonumber.LottoNumbers;
import lotto.model.mylottos.MyLottos;
import lotto.model.winninglotto.BonusBall;
import lotto.model.winninglotto.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.MatchResult;

import static lotto.model.Rank.FIRST;
import static lotto.model.Rank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private final Money money = new Money(2000l);
    private final int BONUS_BALL_NUMBER = 9;
    private final BonusBall BONUS_BALL = BonusBall.of(LottoNumber.of(BONUS_BALL_NUMBER));

    private LottoNumbers WINNING_LOTTO_NUMBERS;
    private WinningLotto WINNING_LOTTO;
    private LottoNumbers LOTTO_NUMBERS_1;
    private LottoNumbers LOTTO_NUMBERS_2;

    @BeforeEach
    void setUp() {
        LOTTO_NUMBERS_1 = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        LOTTO_NUMBERS_2 = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(BONUS_BALL_NUMBER)));

        WINNING_LOTTO_NUMBERS = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        WINNING_LOTTO = new WinningLotto(WINNING_LOTTO_NUMBERS, BONUS_BALL);
    }

    @DisplayName("로또 게임의 getResult 메소드를 호출하면, 각각의 Rank에 몇 개의 로또가 당첨되었는지 알 수 있다.")
    @Test
    void getResultTest() {
        //given
        MyLottos myLottos = new MyLottos(Arrays.asList(LOTTO_NUMBERS_1, LOTTO_NUMBERS_2));
        LottoGame lottoGame = new LottoGame(money.findLottoCountToBuy(), myLottos);

        //when
        GameResult result = lottoGame.getResult(WINNING_LOTTO);

        //then
        assertThat(MatchingResult.findRankCount(SECOND)).isEqualTo(1l);
    }

}