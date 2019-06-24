package lotto;

import lotto.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @Test
    @DisplayName("일치하는 갯수 파라미터로 당첨금 정보를 가져올 수 있다.")
    void test() {
        //Given
        int matchCount = 3;
        //When
        Prize prize = Prize.getPrize(matchCount);
        //Then
        Assertions.assertThat(prize).isEqualTo(Prize.THREE_NUMBER_MATCH);
    }

}
