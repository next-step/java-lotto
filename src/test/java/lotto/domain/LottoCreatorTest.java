package lotto.domain;

import lotto.exception.InputError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCreatorTest {

    @DisplayName("금액에 따라 로또 생성 수가 다르다.")
    @Test
    void buyLotto() {
        assertThat(new LottoCreator(14000)
                .createLottos(new RandomNumbersCreator()).value().size())
                .isEqualTo(14);
    }

    @DisplayName("로또를 살 수 없는 금액일 경우, InputError(CustomException) 발생")
    @Test
    void buyLottoException() {
        assertThatThrownBy(() -> new LottoCreator(900))
                .isInstanceOf(InputError.class);
    }

    @DisplayName("로또 생성 방법 테스트")
    @Test
    void create() {
        assertThat(new LottoCreator(1000)
                .createLottos(() -> Arrays.asList(1, 2, 3, 4, 5, 6)).value())
                .contains(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}