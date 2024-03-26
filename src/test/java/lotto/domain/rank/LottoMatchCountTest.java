package lotto.domain.rank;

import lotto.domain.rank.LottoMatchCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchCountTest {

    @DisplayName("equals 메서드는 LottoMatchCount의 값과 동일한지 여부를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,2,false"})
    void equals(int matchCount, int targetCount, boolean expectResult) {
        final LottoMatchCount count = new LottoMatchCount(matchCount);
        assertThat(count.equals(targetCount)).isEqualTo(expectResult);
    }

    @DisplayName("smallerThan 메서드는 비교대상보다 LottoMatchCount의 값이 작은지 여부를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,true", "2,2,false", "2,1,false"})
    void smallerThan(int matchCount, int targetCount, boolean expectResult) {
        final LottoMatchCount count = new LottoMatchCount(matchCount);
        final LottoMatchCount target = new LottoMatchCount(targetCount);
        assertThat(count.smallerThan(target)).isEqualTo(expectResult);
    }

}
