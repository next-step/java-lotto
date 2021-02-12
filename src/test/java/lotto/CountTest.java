package lotto;

import lotto.wrapper.Count;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class CountTest {
    @DisplayName("List.get(i).countUp() 으로 값 증가시킬 수 있는지")
    @Test
    public void listCountUp() {
        List<Count> countList = Arrays.asList(new Count(0));
        countList.get(0).countUp();
        assertThat(countList.get(0))
                .isEqualToComparingFieldByField(new Count(1));
    }

    @DisplayName("Count 인스턴스 생성 시 음수를 넣으면 예외 발생하는지.")
    @Test
    public void exceptWhenNegative() {
        assertThatThrownBy(() -> new Count(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}