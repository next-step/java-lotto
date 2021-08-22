package lotto.domain;

import lotto.exception.InputError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosCreatorTest {

    @DisplayName("금액에 따라 로또 생성 수가 다르다.")
    @Test
    void buyLotto() {
        assertThat(new LottosCreator(14000)
                .createLottos(RandomNumbersCreator.getInstance()).values().size())
                .isEqualTo(14);
    }

    @DisplayName("로또를 살 수 없는 금액일 경우, InputError(CustomException) 발생")
    @Test
    void buyLottoException() {
        assertThatThrownBy(() -> new LottosCreator(900))
                .isInstanceOf(InputError.class);
    }

}