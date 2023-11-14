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
        assertThat(WinningNumbers.of(lottoFixture(1,2,3,4,5,6), LottoNumber.of(7, true)))
                .isInstanceOf(WinningNumbers.class);
    }

    @Test
    @DisplayName("당첨번호를 만들때 로또넘버가 7개가 아닌 경우 예외")
    void createException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumbers.of(lottoFixture(1,2,3,4,5,6,7), LottoNumber.of(8, true)));
    }
}
