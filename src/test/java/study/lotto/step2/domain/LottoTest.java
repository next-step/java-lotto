package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    @DisplayName("선택한 로또 번호가 6개가 아닐 경우, IllegalArgumentException 예외 발생")
    void invalid_numbers_of_select_then_throw_IllegalArgumentException() {
        // given
        List<Integer> illegalNumbersOfSelect = IntStream.rangeClosed(1, 7)
                .boxed()
                .collect(Collectors.toList());

        // when, then
        assertThatThrownBy(() -> new Lotto(illegalNumbersOfSelect))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호 선택 갯수는 6개입니다: " + illegalNumbersOfSelect.size());
    }

    @Test
    @DisplayName("범위(1 이상 45 이하의 정수)를 넘어서는 로또 번호 선택 시, IllegalArgumentException 예외 발생")
    void select_out_of_range_number_then_throw_IllegalArgumentException() {
        // given
        int outOfRangeNumber = 46;
        List<Integer> selectedNumbers = List.of(1, 2, 3, 4, 5, outOfRangeNumber);

        // when, then
        assertThatThrownBy(() -> new Lotto(selectedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상 45 이하의 정수입니다: " + outOfRangeNumber);
    }
}