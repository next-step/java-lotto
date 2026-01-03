package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    
    @Test
    void 일치_개수로_등수를_찾을_수_있다() {
        assertThat(LottoRank.fromMatchCount(6)).isEqualTo(FIRST);
        assertThat(LottoRank.fromMatchCount(5)).isEqualTo(SECOND);
        assertThat(LottoRank.fromMatchCount(4)).isEqualTo(THIRD);
        assertThat(LottoRank.fromMatchCount(3)).isEqualTo(FOURTH);
        assertThat(LottoRank.fromMatchCount(2)).isEqualTo(UNRANK);
    }
    
    @Test
    void 당첨_개수가_3개_미만일_경우_0원을_반환한다() {
        assertThat(LottoRank.fromMatchCount(2).prizeMoney()).isEqualTo(0);
    }
}
