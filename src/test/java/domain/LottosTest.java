package domain;

import exception.InvalidWinningNumberException;
import exception.LottoCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {
    @DisplayName("buyAmount에 맞추어 로또를 발행")
    @Test
    void lottos() {
        Lottos lottos = Lottos.of(1, 0, Collections.emptyList());

        assertThat(lottos.getLottos()).hasSize(1);
    }

    @DisplayName("수동으로 입력 받은 로또와 buyAmount에 맞추어 로또를 발행")
    @Test
    void lottos_passivityCount() {
        Lottos lottos = Lottos.of(3, 2, Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6"));

        assertThat(lottos.getLottos()).hasSize(5);
    }

    @DisplayName("수동으로 입력 받은 로또가 유효하지 않으면 exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,", "1,2,3,4,5,6,7", "0,1,2,3,4,5", "1,2,3,4,5,47", "t,e,s,t"})
    void lottos_passivityCount(String invalidInput) {
        assertThatThrownBy(() -> Lottos.of(1, 1, Collections.singletonList(invalidInput)))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("저번주 당첨 번호 잘못 입력시 exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4,5,6,7", "1,1,2,3,4,5", "-1,-2,-3,-4,-5,-6"})
    void getPrizes_invalidWinningNumber(String input) {
        Lottos lottos = Lottos.of(1, 0, Collections.emptyList());

        assertThatThrownBy(() -> lottos.getLottoResult(input, 1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void getPrizes_invalidBonusNumber() {
        Lottos lottos = Lottos.of(1, 0, Collections.emptyList());

        assertThatThrownBy(() -> lottos.getLottoResult("1,2,3,4,5,6", 1))
                .isInstanceOf(InvalidWinningNumberException.class);

    }
}
