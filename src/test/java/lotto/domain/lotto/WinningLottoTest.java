package lotto.domain.lotto;

import lotto.domain.exception.InvalidBonusLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("당첨된 로또 테스트")
public class WinningLottoTest {
    @DisplayName("당첨 번호에 보너스볼이 포함되는 경우")
    @Test
    public void invalidBonusLottoNumber() {
        assertThatThrownBy(() -> {
            WinningLotto.of(Lotto.ofNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(6));
        }).isInstanceOf(InvalidBonusLottoNumberException.class)
                .hasMessageContaining("보너스볼은 당첨번호와 중복되면 안됩니다.");


    }
}