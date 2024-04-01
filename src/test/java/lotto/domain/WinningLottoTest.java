package lotto.domain;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    private final List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    void create() {
        int bonusNumber = 7;
        assertThat(new WinningLotto(winNumbers, bonusNumber)).isEqualTo(new WinningLotto(winNumbers, bonusNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스번호_범위(int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(winNumbers, bonusNumber))
                .withMessageMatching("보너스 번호는 1~45 사이의 값이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 보너스번호_당첨번호_중복(int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(winNumbers, bonusNumber))
                .withMessageMatching("당첨번호와 보너스 번호가 중복됩니다.");
    }
}
