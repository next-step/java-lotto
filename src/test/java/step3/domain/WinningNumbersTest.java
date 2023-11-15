package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.domain.TestUtil.lottoFixture;

public class WinningNumbersTest {

    @Test
    @DisplayName("당첨번호는 로또한개와 보너스볼로 만들어진다.")
    void create() {
        assertThat(WinningNumbers.of(lottoFixture(1,2,3,4,5,6), LottoNumber.of(7)))
                .isInstanceOf(WinningNumbers.class);
    }

    @Test
    @DisplayName("당첨번호를 만들때 로또넘버가 7개가 아닌 경우 예외 처리")
    void createNumberCountCheck() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumbers.of(lottoFixture(1,2,3,4,5,6,7), LottoNumber.of(7)));
    }


    @Test
    @DisplayName("당첨번호를 만들때 중복되는 번호가 있는 경우 예외 처리")
    void createSameNumberCheck() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumbers.of(lottoFixture(1,2,3,4,5,6), LottoNumber.of(6)));
    }

    @Test
    @DisplayName("로또를 입력으로 받아서 몇개의 숫자가 일치하는지 확인한다.")
    void matchCount(){
        WinningNumbers winningNumbers = WinningNumbers.of(lottoFixture(1,2,3,4,5,6), LottoNumber.of(7));
        assertThat(winningNumbers.matchCount(lottoFixture(1,2,3,4,5,6))).isEqualTo(6);
        assertThat(winningNumbers.matchCount(lottoFixture(1,2,3,4,5,7))).isEqualTo(6);
        assertThat(winningNumbers.matchCount(lottoFixture(1,10,11,12,13,14))).isEqualTo(1);
    }

    @Test
    @DisplayName("로또를 입력으로 받아서 일치하는 숫자중에 보너스볼이 있는지 확인한다.")
    void matchBonus(){
        WinningNumbers winningNumbers = WinningNumbers.of(lottoFixture(1,2,3,4,5,6), LottoNumber.of(7));
        assertThat(winningNumbers.containBonus(lottoFixture(1,2,3,4,5,6))).isFalse();
        assertThat(winningNumbers.containBonus(lottoFixture(1,2,3,4,5,7))).isTrue();
    }

}
