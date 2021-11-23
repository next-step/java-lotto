package lotto.model;

import common.model.Number;
import lotto.application.Constant;
import lotto.factory.LottoNumberFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoWinnerTest {
    LottoNumbers lottoNumbers;
    LottoWinner winnerNumbers;

    @BeforeEach
    void setUp() {
        List<LottoNumber> temps = new ArrayList<>();
        for (int i = 0; i < Constant.LOTTO_NUMBERS_SIZE; i++) {
            temps.add(LottoNumberFactory.manualCreateNumber(7 * i + 3));
        }
        lottoNumbers = LottoNumberFactory.manualCreateNumbers(temps);
        winnerNumbers = new LottoWinner("3, 10, 17, 24, 31, 45");
    }

    @Test
    @DisplayName("당첨번호 여부 확인 테스트")
    void contains() {
        assertThat(winnerNumbers.contains(LottoNumberFactory.manualCreateNumber(10))).isTrue();
    }

    @Test
    @DisplayName("당첨시 matchCount 증가 테스트")
    void matchCount() {
        Number matchCount = new Number();
        winnerNumbers.match(LottoNumberFactory.manualCreateNumber(10), matchCount);
        assertThat(matchCount).isEqualTo(new Number(1));
    }

    @Test
    @DisplayName("로또 당첨금 확인 테스트")
    void matchAmount() {
        winnerNumbers.match(lottoNumbers);
        assertThat(lottoNumbers.getLottoRank()).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("문자열 변환 테스트")
    void convert() {
        LottoWinner winner = new LottoWinner("1, 2, 3, 4, 5, 6");
        assertThat(winner.getWinnerNumbers())
                .contains(LottoNumberFactory.manualCreateNumber(1),
                        LottoNumberFactory.manualCreateNumber(2),
                        LottoNumberFactory.manualCreateNumber(3),
                        LottoNumberFactory.manualCreateNumber(4),
                        LottoNumberFactory.manualCreateNumber(5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
    @DisplayName("6개 외의 숫자를 입력시 IllegalArgumentException 발생")
    void splitValidation(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoWinner(input));
    }

    @Test
    @DisplayName("숫자가 아닌 문자를 입력시 IllegalArgumentException 발생")
    void convertValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoWinner("q, w, e, r, t, y"));
    }

    @Test
    @DisplayName("당첨 번호가 중복될 경우")
    void duplicateValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoWinner("1, 2, 3, 4, 5, 1"));
    }
}