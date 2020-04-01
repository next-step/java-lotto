package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    @DisplayName("로또는 반드시 6개의 번호로 이루어져야 한다")
    public void invalidLottoWhenInputNumbersCountLessThenSix() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Collections.emptyList()));
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다")
    public void invalidLottoWhenInputDuplicatedNumbers() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 3, 4, 5)));
    }
}
