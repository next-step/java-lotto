package lotto.domain;

import lotto.LottoWinCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinPrizeTest {

    @Test
    @DisplayName("일치하는 숫자들을 넣어서 경우의 수 별로 값이 잘 들어갔는지 테스트")
    void addCount() {
        // given
        List<Integer> matchedCounts = Arrays.asList(3, 3, 4, 5, 5, 5);

        // when
        for (int matchedCount : matchedCounts) {
            LottoWinPrize.addCount(matchedCount);
        }
        List<Integer> prizeCounts = Arrays.stream(LottoWinPrize.values()).map(LottoWinPrize::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(prizeCounts).isEqualTo(Arrays.asList(2, 1, 3, 0));
    }
}