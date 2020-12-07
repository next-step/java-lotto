package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {
    @DisplayName("Rank 컬렉션을 인자로 받아 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        List<Rank> ranks = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.FIRST);
        Map<Rank, Long> expected = new Hashtable<>();
        expected.put(Rank.FIRST, 2L);
        expected.put(Rank.SECOND, 1L);

        LottoPrize lottoPrize = LottoPrize.of(ranks);

        assertThat(lottoPrize).isEqualTo(new LottoPrize(expected));
    }
}
