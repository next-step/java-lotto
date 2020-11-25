package lotto.domain;

import lotto.domain.enums.Currency;
import lotto.domain.enums.PickType;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {

    @Test
    void testGetPicks(){
        Round round = new Round();
        Pick pick = new Pick(PickType.AUTO, new LottoBalls(1,2,3,4,5,6));
        round.addPicks(Arrays.asList(pick));
        Set<Pick> pickSet = round.getMyPicks();
        assertThat(pickSet).isNotEmpty();
    }

    @Test
    void testGenerateReport(){
        Pick losingPick = new Pick(PickType.AUTO, new LottoBalls(1, 2, 3, 4, 5, 6));
        Pick winningPick = new Pick(PickType.AUTO, new LottoBalls(1, 2, 3, 4, 5, 8));
        winningPick.setRank(Rank.FIRST);
        Round round = new Round();
        round.addPicks(Arrays.asList(losingPick,
                losingPick,
                winningPick));

        Map<Rank,Prize> prizeMap = new HashMap<>();
        prizeMap.put(Rank.FIRST, new Prize(Rank.FIRST, new Cash(10000000L, Currency.WON), "6개"));
        LottoReport lottoReport = round.generateReport(new Cash(1000L, Currency.WON), prizeMap);
        assertThat(lottoReport).isNotNull();
        assertThat(lottoReport.getRankMap().get(Rank.FIRST)).isGreaterThanOrEqualTo(1);

    }
}
