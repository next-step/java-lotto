package lotto.domain;

import lotto.domain.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoTest {

    @Test
    @DisplayName("로또를 생성한다. 로또 번호는 1 ~ 45사이의 숫자이어여 한다. 아니면 예외가 발생한다")
    public void create(){
        Assertions.assertThatThrownBy(()-> {
            Lotto.from(() -> Arrays.asList(1, 2, 3, 4, 5, 46));
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()-> {
            Lotto.from(() -> Arrays.asList(-1, 2, 3, 4, 5, 45));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}