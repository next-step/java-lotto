package lottoauto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    @DisplayName("입력받은 숫자를 갖는지 확인해서 겹치는 개수를 반환해줍니다.")
    void matchCount() {
        // given
        int result = 0;
        int winnerNumber = 1;

        Numbers numbers = new Numbers(List.of(1, 2));
        // when
        result = numbers.checkMatchCount(result, winnerNumber);
        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("일치하는 수가 업다면 입력받은 count를 그대로 반환합니다.")
    void notMatchCount() {
        // given
        int result = 0;
        int winnerNumber = 1;

        Numbers numbers = new Numbers(List.of(3, 2));
        // when
        result = numbers.checkMatchCount(result, winnerNumber);
        // then
        assertThat(result).isEqualTo(0);

    }
}