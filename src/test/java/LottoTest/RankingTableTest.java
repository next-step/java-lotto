package LottoTest;

import lotto.domain.LottoMatchNumbers;
import lotto.domain.Rank;
import lotto.domain.RankingTable;
import lotto.domain.RankingRecord;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RankingTableTest {
    @Test
    void Given_LottoGameResult_When_Record_Then_() {
        //given
        LottoMatchNumbers lottoMatchNumbers = new LottoMatchNumbers(Rank.FORTH.matchCount());
        RankingTable rankingTable = new RankingTable(lottoMatchNumbers);

        //when
        RankingRecord rankingRecord = rankingTable.record(Rank.FORTH);

        //then
        assertThat(rankingRecord.rank()).isEqualTo(Rank.FORTH);
        assertThat(rankingRecord.winners()).isEqualTo(1);
    }
}
