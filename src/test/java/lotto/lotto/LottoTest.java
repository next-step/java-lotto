package lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.error.ErrorMessage;

public class LottoTest {

    @Test
    @DisplayName("숫자를 모두 선택하지 않은 경우")
    void testSelectNotComplete() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3)))
                .withMessageContaining(ErrorMessage.INVALID_LOTTO_COUNT);
    }
}