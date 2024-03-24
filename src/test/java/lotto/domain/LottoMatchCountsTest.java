package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchCountsTest {

    @DisplayName("ranks 메서드는 로또 당첨번호 갯수에 따른 등수 목록을 반환한다.")
    @Test
    void ranks() {
        final List<LottoMatchCount> counts = IntStream.rangeClosed(2, 6)
                .mapToObj(LottoMatchCount::new)
                .collect(Collectors.toList());

        assertThat(new LottoMatchCounts(counts).ranks())
                .contains(Rank.FIRST, Rank.SECOND, Rank.FOURTH, Rank.FIFTH, Rank.NEXT_CHANCE);
    }

}
