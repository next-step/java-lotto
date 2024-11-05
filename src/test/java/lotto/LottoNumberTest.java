package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호는 [1-45] 사이의 값을 갖는다.")
    void testLottoNumberValidation() {
        assertThatThrownBy(() -> {
            new LottoNumber(0);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 비교가 가능하다.")
    void testLottoNumberCompare() {
        assertThat(new LottoNumber(1).compareTo(new LottoNumber(2))).isEqualTo(-1);
        assertThat(new LottoNumber(1).compareTo(new LottoNumber(1))).isEqualTo(0);
        assertThat(new LottoNumber(2).compareTo(new LottoNumber(1))).isEqualTo(1);
        assertThat(new LottoNumber(1).equals(new LottoNumber(1))).isEqualTo(true);
    }
}
