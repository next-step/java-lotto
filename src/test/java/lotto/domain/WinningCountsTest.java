package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * WinningCounts 일급 컬렉션 생성 및 기능 테스트
 */
public class WinningCountsTest {

    @Test
    @DisplayName("저장된 당첨번호 갯수 Set을 반환")
    void get_winningNumberSet() {
        // given
        Map<Integer, Integer> winningCount = new HashMap<>();
        winningCount.put(3, 1);
        winningCount.put(4, 2);
        winningCount.put(5, 3);
        winningCount.put(6, 4);
        WinningCounts winningCounts = new WinningCounts(winningCount);

        // when
        Set<Integer> winningNumbers = winningCounts.getWinningNumberSet();

        // then
        assertThat(winningNumbers.size()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {2,7})
    @DisplayName("당청 인정 갯수 번호 유효성 검증")
    void winningNumber_validate(int winningNumber) {
        // given
        Map<Integer, Integer> winningCount = new HashMap<>();
        winningCount.put(winningNumber, 1);

        // then
        assertThatThrownBy(() -> new WinningCounts(winningCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨을 인정하는 번호 일치 개수는 3~6개 입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,1", "4,2", "5,3", "6,4", "7,0"})
    @DisplayName("입력된 값 호출")
    void get_winningCount(int winningMatchedNumber, int winningMatchedCount) {
        // given
        Map<Integer, Integer> winningCount = new HashMap<>();
        winningCount.put(3, 1);
        winningCount.put(4, 2);
        winningCount.put(5, 3);
        winningCount.put(6, 4);
        WinningCounts winningCounts = new WinningCounts(winningCount);

        // when
        int result = winningCounts.getWinningCount(winningMatchedNumber);

        // then
        assertThat(result).isEqualTo(winningMatchedCount);
    }

    @Test
    @DisplayName("객체 생성")
    void create() {
        // given
        Map<Integer, Integer> winningCount = new HashMap<>();
        winningCount.put(3, 0);
        winningCount.put(4, 0);
        winningCount.put(5, 0);
        winningCount.put(6, 0);
        WinningCounts winningCounts = new WinningCounts(winningCount);

        // when
        boolean result = winningCounts.isEmpty();

        // then
        assertThat(result).isFalse();
    }
}
