package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호가 1~45 사이의 숫자가 아닌 다른 숫자일 때 IllegalArgumentException 발생")
    void lotto_number_범위() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(50);
        });
    }

    @Test
    @DisplayName("로또 번호 생성시 6개가 아니면 IllegalArgumentException 발생")
    void lotto_number_갯수() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        });
    }

    @Test
    @DisplayName("로또 번호 생성시 중복으로 6개가 아니면 IllegalArgumentException 발생")
    void lotto_number_중복() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 4, 6));
        });
    }

    @Test
    @DisplayName("로또 번호 일치하는 갯수 테스트 (3개 일치)")
    void lotto_number_MatchNumber_count_3() {
       assertThat(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)).countMatchingNumbers(new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9)))).isEqualTo(3);
    }
}
