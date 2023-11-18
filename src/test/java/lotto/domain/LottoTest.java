package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("6자리 테스트")
    @Test
    void numberDigitTest() {
        assertThatThrownBy(() -> new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자 범위 테스트")
    @Test
    void numberRangeTest() {
        assertThatThrownBy(() -> new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6, 46)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
