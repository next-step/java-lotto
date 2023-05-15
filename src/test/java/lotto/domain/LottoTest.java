package lotto.domain;

import lotto.domian.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoTest {

    @DisplayName("로또 숫자가 중복이 되면 예외를 던진다.")
    @Test
    public void lotto_DuplicateNumber_ThrowException() {

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 5)));
    }

}
