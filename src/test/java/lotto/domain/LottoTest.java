package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또에 숫자가 몇 개 포함되었는지 카운트한다.")
    @Test
    void compareCount() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> other = new ArrayList<>(List.of(1, 2, 3, 10, 11, 12));
        Lotto lotto = new Lotto(numbers);
        Assertions.assertThat(lotto.findWinningType(other, 0)).isEqualTo(WinningType.HIT_COUNT_3);
    }

    @DisplayName("로또가 7자리 이상이면 오류이다.")
    @Test
    void lengthExceedException() {

        assertThatThrownBy(() -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또에 중복되는 숫자가 있으면 오류이다.")
    @Test
    void duplicatedExceltion() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 7)));
    }
}