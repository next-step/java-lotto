package lotto.service;

import lotto.domain.LottoReport;
import lotto.domain.Pick;
import lotto.domain.Round;
import lotto.domain.enums.PickType;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundServiceTest {

    private RoundService roundService;
    private LottoService lottoService;

    @BeforeEach
    void makeTestRoundService(){
        AbstractPrizePackager prizePackager = new DefaultPrizePackager();
        lottoService = new LottoService(1000, prizePackager);
        roundService = new RoundService(new AutoPickService(), lottoService);
    }

    @Test
    void testBuy(){
        Set<Pick> myPicks = new HashSet<>();
        myPicks.add(new Pick(PickType.AUTO, Arrays.asList(3,5,6,7,8,9)));
        Round round = roundService.buy(myPicks);

        assertThat(round).isNotNull();
        assertThat(round.getMyPicks()).containsAll(myPicks);
    }

    @Test
    void testAutoBuy(){
        Round round = roundService.autoBuy(14);

        assertThat(round).isNotNull();
        assertThat(round.getMyPicks()).hasSize(14);
    }

    @Test
    void checkWinning(){
        Round round = roundService.autoBuy(14);
        Pick winningBallPick = round.getMyPicks().stream().findFirst().get();
        roundService.checkWinning(winningBallPick.getBalls());
        assertThat(round.getMyPicks()).allSatisfy(pick -> {
            assertThat(pick.getRank()).isEqualTo(Rank.LOSE);
        });
    }

    @Test
    void testGenerateReport(){
        Round round = roundService.autoBuy(14);
        Pick winningBallPick = round.getMyPicks().stream().findFirst().get();
        roundService.checkWinning(winningBallPick.getBalls());
        LottoReport lottoReport = roundService.generateReport();
        assertThat(lottoReport).isNotNull();
        assertThat(lottoReport.getRankMap()).extractingByKey(Rank.LOSE).isEqualTo(14);
    }
}
