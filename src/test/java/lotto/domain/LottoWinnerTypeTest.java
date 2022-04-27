package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinnerTypeTest {
    @ParameterizedTest
    @CsvSource({"6,false,FIRST_PLACE", "5,true,SECOND_PLACE", "5,false,THIRD_PLACE", "4,false,FOURTH_PLACE", "3,false,FIFTH_PLACE", "-2,false,NON_WIN"})
    void 중복개수_및_보너스번호_일치_당첨타입_반환(int countOfDuplicate, boolean isBonus, LottoWinnerType winnerType) {
        assertThat(LottoWinnerType.valueOf(countOfDuplicate, isBonus)).isEqualTo(winnerType);
    }

    @ParameterizedTest
    @CsvSource({"6,false,2_000_000_000", "5,true,30_000_000", "5,false,1_500_000", "4,false,50_000", "3,false,5_000", "-2,false,0"})
    void 중복개수_및_보너스번호_일치_상금_반환(int countOfDuplicate, boolean isBonus, int prize) {
        assertThat(LottoWinnerType.prize(countOfDuplicate, isBonus)).isEqualTo(prize);
    }
}