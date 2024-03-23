package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.ErrorMessage;
import lotto.error.SizeExceedLottoException;
import lotto.error.SizeExceedLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("Lotto는 6개의 LottoNumber만 가질수 있다.")
    public void Lotto_Can_Only_Have_6_Lotto_Number() {
        Lotto lotto = Lotto.fromValues(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("Lotto는 7개 이상의 LottoNumber를 가질 경우 Exception이 발생한다.")
    public void If_Lotto_Has_More_Than_7_LottoNumbers_Occurs_Exception() {
        assertThatThrownBy(() -> Lotto.fromValues(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(SizeExceedLottoException.class)
            .hasMessage("로또의 사이즈는 최대 6입니다. 입력값: 7");
    }
}
