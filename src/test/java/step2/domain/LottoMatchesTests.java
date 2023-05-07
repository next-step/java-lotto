package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;
public class LottoMatchesTests {
    @Test
    @DisplayName("전체 로또에서 몇개의 로또를 맞췄는지 개수별로 확인")
    void getMatchCounts() {
        // Given
        List<List<Integer>> lottos = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12),
                Arrays.asList(1, 3, 5, 7, 9, 11),
                Arrays.asList(1, 2, 3, 11, 12, 13),
                Arrays.asList(7, 8, 9, 10, 11, 12),
                Arrays.asList(10, 20, 30, 40, 41, 42),
                Arrays.asList(1, 2, 3, 4, 5, 7)
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        int[] expectedMatchCounts = {5, 0, 1, 0};

        // When
        int[] actualMatchCounts = LottoMatches.getMatchCounts(lottos, winningNumbers);

        // Then
        assertThat(actualMatchCounts).isEqualTo(expectedMatchCounts);
    }

    @Test
    @DisplayName("로또에서 몇개의 로또를 맞췄는지 확인")
    void countMatchedNumbers() {
        // Given
        List<Integer> numbersToMatch = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> numbersToCompare = Arrays.asList(1, 2, 3, 10, 11, 12);
        int expectedMatchCount = 3;

        // When
        int actualMatchCount = LottoMatches.countMatchedNumbers(numbersToMatch, numbersToCompare);

        // Then
        assertThat(actualMatchCount).isEqualTo(expectedMatchCount);
    }
}
