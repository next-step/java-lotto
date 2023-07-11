package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinningLottoTest {

    private List<LottoNumber> createLottoNumbers(int... ints) {
        return Arrays.stream(ints)
                .boxed()
                .map(LottoNumber::new)
                .collect(toList());
    }

    @Test
    @DisplayName("당첨 번호와 보너스 볼이 중복되면 예외를 던진다.")
    void 당첨_번호_보너스볼_중복_예외() {
        Assertions.assertThatCode(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 7), 7))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 볼을 입력 받는다.")
    void 당첨_번호_보너스볼_생성() {
        Assertions.assertThatCode(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7))
                .doesNotThrowAnyException();
    }
}
