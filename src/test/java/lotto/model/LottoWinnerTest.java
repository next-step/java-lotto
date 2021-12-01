package lotto.model;

import common.model.Number;
import lotto.application.Constant;
import lotto.factory.LottoNumberFactory;
import lotto.factory.LottoNumbersFactory;
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
            temps.add(LottoNumberFactory.createByNumber(7 * i + 3));
        }
        lottoNumbers = LottoNumbersFactory.create(temps);
        LottoNumber bonus = LottoNumberFactory.createByString("45");
        winnerNumbers = LottoNumbersFactory.createWinner("3, 10, 17, 24, 31, 44", bonus);
    }

    @Test
    @DisplayName("당첨번호 여부 확인 테스트")
    void contains() {
        assertThat(winnerNumbers.contains(LottoNumberFactory.createByNumber(10))).isTrue();
    }

    @Test
    @DisplayName("당첨시 matchCount 증가 테스트")
    void matchCount() {
        Number matchCount = new Number();
        winnerNumbers.match(LottoNumberFactory.createByNumber(10), matchCount);
        assertThat(matchCount).isEqualTo(new Number(1));
    }

    @Test
    @DisplayName("문자열 변환 테스트")
    void convert() {
        LottoWinner winner = LottoNumbersFactory.createWinner("1, 2, 3, 4, 5, 6", LottoNumberFactory.createByString("7"));
        assertThat(winner.contains(LottoNumberFactory.createByNumber(1))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
    @DisplayName("6개 외의 숫자를 입력시 IllegalArgumentException 발생")
    void splitValidation(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbersFactory.createWinner(input, LottoNumberFactory.createByString("45")));
    }

    @Test
    @DisplayName("숫자가 아닌 문자를 입력시 IllegalArgumentException 발생")
    void convertValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbersFactory.createWinner("q, w, e, r, t, y", LottoNumberFactory.createByString("45")));
    }

    @Test
    @DisplayName("당첨 번호가 중복될 경우")
    void duplicateValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbersFactory.createWinner("1, 2, 3, 4, 5, 1", LottoNumberFactory.createByString("45")));
    }

    @Test
    @DisplayName("2등 당첨 테스트")
    void secondMatch() {
        LottoNumbers lottoNumbers = LottoNumbersFactory.createByInput("1, 2, 3, 4, 5, 6");
        LottoWinner winnerNumbers = LottoNumbersFactory.createWinner("1, 2, 3, 4, 5, 10", LottoNumberFactory.createByNumber(6));

        assertThat(winnerNumbers.match(lottoNumbers)).isEqualTo(LottoRank.SECOND);
    }
}