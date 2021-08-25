package lotto.domain;

import lotto.exception.InputError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosCreatorTest {

    @DisplayName("금액에 따라 로또 생성 수가 다르다.")
    @Test
    void buyLotto() {
        assertThat(new LottosCreator(new Money(14000), 1)
                .createLottos(Arrays.asList("1,2,3,4,5,6"), RandomNumbersCreator.getInstance()).values().size())
                .isEqualTo(14);
    }

    @DisplayName("로또를 살 수 없는 금액일 경우, InputError(CustomException) 발생")
    @Test
    void buyLottoException() {
        assertThatThrownBy(() -> new LottosCreator(new Money(900), 0))
                .isInstanceOf(InputError.class);
        assertThatThrownBy(() -> new LottosCreator(new Money(1000), 2))
                .isInstanceOf(InputError.class);
    }

}