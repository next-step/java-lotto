package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumbersTest {
    @ParameterizedTest
    @NullSource
    @DisplayName("LottoWinningNumbers 는 아무런 로또번호가 주어지지 않으면 예외를 던진다")
    void newObject_nullLotto_throwsException(Lotto nullLotto) {
        LottoNumber bonusNumber = new LottoNumber(8);

        assertThatThrownBy(
            () -> new LottoWinningNumbers(nullLotto, bonusNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("matchesLotto 는 5개 번호가 일치하고 보너스 번호가 같으면 보너스 공을 반환한다")
    void matchesLotto_sameFiveNumbersAndBonusNumber_amount() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = new LottoNumber(8);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lotto, bonusNumber);
        Lotto matchesLotto = new Lotto("1, 2, 3, 4, 5, 8");

        LottoMatch lottoMatch = lottoWinningNumbers.matchesLotto(matchesLotto);

        assertThat(lottoMatch).isEqualTo(LottoMatch.SECOND);
    }
}
