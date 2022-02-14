package lotto.domain.correctnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.lottonumber.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CorrectNumbersTest {

    @DisplayName("당첨 번호와 보너스 번호를 받아 객체를 생성한다.")
    @Test
    void Given_당첨번호_보너스_번호_When_객체_생성_Then_당첨번호와_보너스_번호를_가짐() {
        final CorrectNumbers correctNumbers = new CorrectNumbers("1,2,3,4,5,6", "7");

        assertThat(correctNumbers.getWinningNumbers().size()).isEqualTo(6);
        assertThat(correctNumbers.getBonusNumber()).isEqualTo(LottoNumber.from(7));
    }

    @DisplayName("당첨 번호들과 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void 당첨번호_보너스_번호_When_객체_생성_Then_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> new CorrectNumbers("1,2,3,4,5,6", "6"));
    }

    @DisplayName("숫자가 아닌 보너스 넘버를 인자로 객체를 생성하면 예외가 발생한다.")
    @Test
    void Given_숫자가_아닌_값_When_객체_생성_Then_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> new CorrectNumbers("1,2,3,4,5,6", "aaa"));
    }

    @DisplayName("보너스 넘버 인자에 숫자가 여러개 포함되어 있으면 예외가 발생한다.")
    @Test
    void Given_숫자가_여러개_포함됨_When_객체_생성_Then_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new CorrectNumbers("1,2,3,4,5,6", "1 2"));
    }
}
