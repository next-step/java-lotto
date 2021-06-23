package lotto.core.omr;

import lotto.core.SixBall;
import lotto.core.round.Rank;
import lotto.core.round.Round;
import lotto.core.round.WinSixBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.core.round.Rank.*;

class OmrCardTest {

    @Test
    @DisplayName("OMR 카드 다중 마킹후 당첨번호와 비교")
    public void missTest() {
        //Given
        OmrCard omrCard = new OmrCard(Purchase.valueOf(5000));

        omrCard.marking(SixBall.valueOf(1, 2, 3, 4, 5, 6));
        omrCard.marking(SixBall.valueOf(1, 2, 3, 4, 5, 16));
        omrCard.marking(SixBall.valueOf(11, 12, 13, 14, 15, 16));
        omrCard.marking(SixBall.valueOf(21, 22, 23, 24, 25, 26));
        omrCard.marking(SixBall.valueOf(31, 32, 33, 34, 35, 36));

        //When
        Round round = new Round(WinSixBall.valueOf(1, 2, 3, 4, 5, 6), 7);

        //Then
        Map<Rank, List<Omr>> rankListMap = omrCard.grade(round);

        assertThat(rankListMap).containsKey(FIRST).containsKey(THIRD).containsKeys(MISS);

        assertThat(rankListMap.get(FIRST).size()).isEqualTo(1);
        assertThat(rankListMap.get(THIRD).size()).isEqualTo(1);
        assertThat(rankListMap.get(MISS).size()).isEqualTo(3);
    }

}