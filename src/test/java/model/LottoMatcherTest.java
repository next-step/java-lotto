package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {

    @Test
    public void getMatchingCountTest() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 5, 6, 7);
        Lotto lotto = new Lotto(numbers);
        Lotto lotto2 = new Lotto(numbers);

        // When
        int matchingCount = LottoMatcher.count(lotto, lotto2);

        // Then
        int expectedMatchingCount = 6;
        assertThat(matchingCount).isEqualTo(expectedMatchingCount);
    }

    @Test
    @DisplayName("매칭 카운트 0")
    public void getMatchingCountTest2() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 5, 6, 7);
        List<Integer> numbers2 = List.of(11, 12, 13, 15, 16, 17);
        Lotto lotto = new Lotto(numbers);
        Lotto lotto2 = new Lotto(numbers2);

        // When
        int matchingCount = LottoMatcher.count(lotto, lotto2);

        // Then
        int expectedMatchingCount = 0;
        assertThat(matchingCount).isEqualTo(expectedMatchingCount);
    }
}
