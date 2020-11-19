package lotto.domain;

import lotto.domain.enums.PickType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {

    @Test
    void testGetPicks(){
        Round round = new Round();
        Pick pick = new Pick(PickType.AUTO, Arrays.asList(1,2,3,4,5,6));
        round.addPicks(Arrays.asList(pick));
        Set<Pick> pickSet = round.getMyPicks();
        assertThat(pickSet).isNotEmpty();
    }

    @Test
    void testGetReports(){
        Round round = new Round();
        LottoReport lottoReport = new LottoReport();
        round.setReport(lottoReport);

        assertThat(round.getReport()).isNotNull();
    }

    @Test
    void testGetWinningNumber(){
        Round round = new Round();
        round.setWinningBalls(Arrays.asList(1,2,3,4,5,6));
        assertThat(round.getWinningBalls()).containsExactly(1,2,3,4,5,6);
    }
}
