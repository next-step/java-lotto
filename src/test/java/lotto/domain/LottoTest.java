package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @DisplayName("로또 번호 길이가 6이 아닌 경우 예외발생")
    @Test
    void whenLottoNumberSizeNotEqual6ThenException(){

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }
    
    @DisplayName("로또 번호에 1 ~ 45 사이가 아닌 수가 존재할 시 예외 발생")
    @Test
    void whenLottoNumberHasWrongNumberThenException(){

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46))
        );
    }
}
