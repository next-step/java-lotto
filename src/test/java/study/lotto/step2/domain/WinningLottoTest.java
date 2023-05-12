package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {
    @Test
    @DisplayName("CSV 당첨 번호로 WinningLotto 객체 생성")
    void csv_winning_lotto_numbers() {
        // given
        String winningLottoNumbers = "1, 2,3,4, 5,6";

        // when
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        // then
        assertThat(winningLotto).isEqualTo(new WinningLotto(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우, IllegalArgumentException 예외 발생")
    void invalid_winning_lotto_size_then_throw_IllegalArgumentException() {
        Integer[] invalidWinningLottoNumbers = {1, 2, 3, 4, 5, 6, 7};
        assertThatThrownBy(() -> new WinningLotto(invalidWinningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호 갯수는 6개입니다: " + invalidWinningLottoNumbers.length);
    }

    @Test
    @DisplayName("로또 당첨 번호 일치 갯수 확인")
    void numbers_of_match() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(2, 4, 6, 8, 10, 12);

        // when
        int numbersOfMatch = winningLotto.numbersOfMatch(lotto);

        // then
        assertThat(numbersOfMatch).isEqualTo(3);
    }

    @ParameterizedTest(name = "[{index}/2] {displayName}")
    @CsvSource(value = {"1,true", "11,false"})
    @DisplayName("당첨 번호 내 로또 번호가 포함되어 있는지 여부 확인")
    void contains(int lottoNumber, boolean isContains) {
        // given
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);

        // when, then
        assertThat(winningLotto.contains(LottoNumber.of(lottoNumber)))
                .isEqualTo(isContains);
    }
}