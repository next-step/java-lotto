package domain;

import exception.InvalidRangeNumberException;
import exception.InvalidWinningNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {
    @DisplayName("buyAmount에 맞추어 로또를 발행")
    @Test
    void lottos() {
        Lottos lottos = Lottos.of(1, () -> Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));

        assertThat(lottos.getLottos()).hasSize(1);
    }

    @DisplayName("저번주 당첨 번호 잘못 입력시 exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4,5,6,7", "1,1,2,3,4,5", "-1,-2,-3,-4,-5,-6"})
    void getPrizes_invalidWinningNumber(String input) {
        Lottos lottos = Lottos.of(1, () -> Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))
        );

        assertThatThrownBy(() -> lottos.getLottoResult(input, 1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void getPrizes_invalidBonusNumber() {
        Lottos lottos = Lottos.of(1, () -> Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))
        );

        assertThatThrownBy(() -> lottos.getLottoResult("1,2,3,4,5,6", 1))
                .isInstanceOf(InvalidWinningNumberException.class);

    }
}
