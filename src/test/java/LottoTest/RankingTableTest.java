package LottoTest;

import lotto.LottoGameResult;
import lotto.Rank;
import lotto.RankingTable;
import lotto.RankingRecord;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RankingTableTest {
    @Test
    void Given_LottoGameResult_When_Record_Then_() {
        //given
        LottoGameResult lottoGameResult = new LottoGameResult(Rank.FORTH.matchCount());
        RankingTable rankingTable = new RankingTable(lottoGameResult);

        //when
        RankingRecord rankingRecord = rankingTable.record(Rank.FORTH);

        //then
        assertThat(rankingRecord.rank()).isEqualTo(Rank.FORTH);
        assertThat(rankingRecord.winners()).isEqualTo(1);
    }
}
