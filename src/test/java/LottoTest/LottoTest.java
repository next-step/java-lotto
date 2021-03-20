package LottoTest;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {
    @Test
    @DisplayName("Lotto 인스턴스 생성 테스트")
    void Given_LottoGame_When_Net_Then_NoException() {
        //given
        List<LottoGame> lottoGame = Arrays.asList(
                new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        //when then
        assertDoesNotThrow(() -> new Lotto(lottoGame));
    }

    @Test
    @DisplayName("당첨번호가 주어졌을 때 로또 게임 별 맞은 숫자 계산 테스트")
    void Given_WinningNumbers_When_Result_Then_LottoResult() {
        //given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoGame> lottoGames = Arrays.asList(
                new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoGame(Arrays.asList(7, 2, 3, 4, 5, 6)),
                new LottoGame(Arrays.asList(7, 8, 3, 4, 5, 6)),
                new LottoGame(Arrays.asList(7, 8, 9, 4, 5, 6)),
                new LottoGame(Arrays.asList(7, 8, 9, 10, 5, 6)),
                new LottoGame(Arrays.asList(7, 8, 9, 10, 11, 6))
        );

        Lotto lotto = new Lotto(lottoGames);

        //when
        List<LottoMatchNumbers> result = lotto.result(winningNumber);

        //then
        assertThat(result).contains(new LottoMatchNumbers(6));
        assertThat(result).contains(new LottoMatchNumbers(5));
        assertThat(result).contains(new LottoMatchNumbers(4));
        assertThat(result).contains(new LottoMatchNumbers(3));
        assertThat(result).contains(new LottoMatchNumbers(2));
        assertThat(result).contains(new LottoMatchNumbers(1));
        assertFalse(result.contains(new LottoMatchNumbers(0)));
    }

    @Test
    @DisplayName("로또 구입 금액이 1장 가격보다 작을 경우 예외처리")
    void Given_LittlePurchaseAmount_When_New_Then_Exception() {
        LottoNumber lottoNumber = new FixedLottoNumber();
        int purchaseAmount = 500;

        assertThatExceptionOfType(IllegalArgumentException.class).
                isThrownBy(() -> new Lotto(purchaseAmount, lottoNumber));
    }
}
