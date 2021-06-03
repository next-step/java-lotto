package study.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.domain.*;
import study.lotto.exception.DuplicateBonusBallException;
import study.lotto.view.DummyInputView;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        InputView inputView = new DummyInputView();
        ResultView resultView = new ResultView();
        lottoGame = new LottoGame(inputView, resultView);
    }

    @DisplayName("실행 테스트(1등, 2등 수동 입력)")
    @Test
    void play() {
        lottoGame.play();
    }

    @DisplayName("입력한 금액만큼 구매 가능한 장수를 확인한다")
    @ParameterizedTest
    @CsvSource({"14000,14", "2000,2", "1500,1", "400,0"})
    public void purchaseableLottoTest(BigDecimal purchaseAmount, int expected) {

        assertThat(lottoGame.purchaseableNumber(purchaseAmount)).isEqualTo(expected);
    }


    @DisplayName("수익률 확인")
    @ParameterizedTest
    @CsvSource({"0,0.00", "5000,1.00", "55000,11.00"})
    public void profitRateTest(BigDecimal prizeAmount, BigDecimal expect) {

        assertThat(lottoGame.profitRate(BigDecimal.valueOf(5000),prizeAmount)).isEqualTo(expect);
    }

    @DisplayName("당첨 번호와 보너스 볼 중복시 에러")
    @Test
    public void inputWinningNumber() {
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        LottoNumber bonusNumber = LottoNumber.of(6);
        assertThatThrownBy(() -> lottoGame.validateBonusNumber(winningLotto, bonusNumber))
                .isInstanceOf(DuplicateBonusBallException.class);
    }

}
