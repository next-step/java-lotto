package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusLottoNumberTest {
    @Test
    @DisplayName("BonusLottoNumber 생성자 테스트")
    public void constructor() {
        assertThat(new BonusLottoNumber(1)).isEqualTo(new BonusLottoNumber(1));
    }

    @Test
    @DisplayName("입력받은 보너스 볼이 당첨번호 6개와 다른지 체크")
    public void validateDifferentNumberFromWinningNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> {
            new BonusLottoNumber(1, lottoNumbers);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("보너스 번호가 지난 주 당첨중에 있습니다.");
    }
}
