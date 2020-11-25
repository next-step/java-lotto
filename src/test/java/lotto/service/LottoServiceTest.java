package lotto.service;

import lotto.domain.LottoBalls;
import lotto.domain.Pick;
import lotto.domain.Prize;
import lotto.domain.PrizeInfo;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private final AbstractPrizePackager prizePackager = new DefaultPrizePackager();
    private final LottoService lottoService = new LottoService(1000, prizePackager);
    @Test
    void testGetPrice(){
        assertThat(lottoService.getPrice()).isEqualTo(1000);
    }


    @Test
    void testCheckRank(){
        Rank rank = lottoService.checkRank(new Pick(), new LottoBalls(1, 2, 3, 4, 5, 6));
        assertThat(rank).isEqualTo(Rank.LOSE);
    }

    @Test
    void testGetPrizeMap(){
        PrizeInfo prizeInfo = prizePackager.pack();

        Map<Rank, Prize> prizeMap = lottoService.getPrizeMap();
        assertThat(prizeMap).extractingByKey(Rank.LOSE).isNotNull();
        assertThat(prizeMap).containsAllEntriesOf(prizeInfo.getPrizeMap());
    }
}
