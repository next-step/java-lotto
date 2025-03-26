package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryTest {
    @Test
    @DisplayName("중복된 숫자가 있는 경우, 예외를 반환한다")
    void duplicateNumberTest() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> {
            new Lottery(numbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("로또 번호와 일치하는 숫자가 몇개인지 확인한다")
    void matchTest() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 8));
        Lottery lotto = new Lottery(lottoNumbers);
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.match(numbers)).isEqualTo(5);
    }
}
