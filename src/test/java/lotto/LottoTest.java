package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LottoTest {

    LottoView lottoView;

    @BeforeEach
    void init() {
        lottoView = new LottoView();
    }

    @DisplayName("로또 숫자는 1~45이다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "4", "12", "45"})
    void lottoNumber(String number) {
        assertThatCode(() -> {
            new LottoNumber(Integer.parseInt(number));
        }).doesNotThrowAnyException();

    }

    @DisplayName("로또 숫자는 1~45이다.")
    @ParameterizedTest
    @ValueSource(strings = {"211", "2a11", "211$", "123", "-1", "0", "46"})
    void lottoNumber2(String number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(number));
    }

    @DisplayName("로또는 6자리 중복불가 숫자로 구성되어있다.")
    @Test
    void lottoSet() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(1, 2, 2, 5, 6, 7));
    }

    @DisplayName("로또 당첨결과 확인 1등")
    @Test
    void lottoWin1() {
        Lotto myLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int result = myLotto.match(
                new Lotto(1, 2, 3, 4, 5, 6).getLotto(),
                new LottoNumber(9)
        );
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("로또 당첨결과 확인 2등")
    @Test
    void lottoWin2() {
        Lotto myLotto = new Lotto(1, 2, 3, 4, 5, 7);
        int result = myLotto.match(
                new Lotto(1, 2, 3, 4, 5, 6).getLotto(),
                new LottoNumber(7)
        );
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("로또 당첨결과 확인 3등")
    @Test
    void lottoWin3() {
        Lotto myLotto = new Lotto(1, 2, 3, 4, 5, 7);
        int result = myLotto.match(
                new Lotto(1, 2, 3, 4, 5, 6).getLotto(),
                new LottoNumber(40)
        );
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("로또 당첨결과 확인 4등")
    @Test
    void lottoWin4() {
        Lotto myLotto = new Lotto(1, 2, 3, 4, 7, 8);
        int result = myLotto.match(
                new Lotto(1, 2, 3, 4, 5, 6).getLotto(),
                new LottoNumber(40)
        );
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("로또 당첨결과 확인 5등")
    @Test
    void lottoWin5() {
        Lotto myLotto = new Lotto(1, 2, 3, 7, 8, 9);
        int result = myLotto.match(
                new Lotto(1, 2, 3, 4, 5, 6).getLotto(),
                new LottoNumber(40)
        );
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("로또 당첨결과 확인 당첨X")
    @Test
    void lottoWinNothing() {
        Lotto myLotto = new Lotto(1, 2, 9, 10, 11, 12);
        int result = myLotto.match(
                new Lotto(1, 2, 3, 4, 5, 6).getLotto(),
                new LottoNumber(40)
        );
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("등수별 금액 구하기")
    @ParameterizedTest
    @CsvSource({
            "1, 2000000000"
            , "2, 30000000"
            , "3, 1500000"
            , "4, 50000"
            , "5, 5000"
            , "0, 0"
    })
    void reward(int rank, int reward) {
        Lotto lotto = new Lotto();
        assertThat(lotto.reward(rank)).isEqualTo(reward);
    }

}
