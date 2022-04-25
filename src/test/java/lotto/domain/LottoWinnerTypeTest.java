package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinnerTypeTest {
    @ParameterizedTest
    @CsvSource({"6,FIRST_PLACE", "5,SECOND_PLACE", "4,THIRD_PLACE", "3,FOURTH_PLACE", "-2,NON_WIN"})
    void 중복개수_일치_당첨타입_반환(int countOfDuplicate, LottoWinnerType winnerType) {
        assertThat(LottoWinnerType.valueOf(countOfDuplicate)).isEqualTo(winnerType);
    }

    @ParameterizedTest
    @CsvSource({"6,2000000000", "5,1500000", "4,50000", "3,5000", "-2,0"})
    void 중복개수_일치_상금_반환(int countOfDuplicate, int prize) {
        assertThat(LottoWinnerType.prize(countOfDuplicate)).isEqualTo(prize);
    }
}