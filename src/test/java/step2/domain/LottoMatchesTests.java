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
        List<LottoNumber> lottos = Arrays.asList(
                new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumber(Arrays.asList(11, 12, 13, 14, 15, 16)),
                new LottoNumber(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        int expectedThreeMatchCount = 2;
        // When
        LottoNumber winningNumbers = new LottoNumber(Arrays.asList(4, 5, 6, 7, 8, 9));
        // Then
        assertThat(LottoMatches.getMatchCounts(lottos, winningNumbers).threeMatchCount)
                .isEqualTo(expectedThreeMatchCount);
    }

    @Test
    @DisplayName("로또에서 몇개의 로또를 맞췄는지 확인")
    void countMatchedNumbers() {
        // Given
        LottoNumber numbersToMatch = new LottoNumber(Arrays.asList(1, 3, 5, 7, 9, 11));
        LottoNumber numbersToCompare = new LottoNumber(Arrays.asList(1, 2, 3, 10, 11, 12));

        int expectedMatchCount = 3;

        // When
        int actualMatchCount = LottoMatches.countMatchedNumbers(numbersToMatch, numbersToCompare);

        // Then
        assertThat(actualMatchCount).isEqualTo(expectedMatchCount);
    }
}
