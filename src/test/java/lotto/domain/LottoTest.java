package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    private Lotto lotto;
    private List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1,2,3,4,5,6);
        lotto = Lotto.of(numbers);
    }

    @DisplayName("로또 개수 유효성 테스트")
    @Test
    void invalidLottoCount() {
        assertThatThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6, 8)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 중복 값 테스트")
    @Test
    void invalidLotto() {
        assertThatThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 로또 번호 매칭 테스트")
    @Test
    void hasWinningNumber() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,8,11);
        assertThat(lotto.getMatchCountByWinningLotto(Lotto.of(winningNumbers))).isEqualTo(4);
    }

    @DisplayName("로또에 해당 번호가 포함되어 있는지 테스트")
    @Test
    void hasNumber() {
        assertThat(lotto.hasNumber(LottoNumber.of(6))).isTrue();
    }
}
