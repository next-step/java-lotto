package lotto.domain;

import lotto.domian.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoTest {

    @DisplayName("로또 숫자가 중복이 되면 예외가 발생한다.")
    @Test
    public void lotto_DuplicateNumber_ThrowException() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 5);
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lotto));
    }

    @DisplayName("로또 숫자의 범위가 1 ~ 45가 아니면 에러가 발생한다.")
    @Test
    public void lotto_OutOfRange_ThrowException() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 46);
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lotto));
    }

}
