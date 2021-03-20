package LottoTest;

import lotto.domain.LottoMatchNumbers;
import lotto.domain.Rank;
import lotto.domain.RankingTable;
import lotto.domain.RankingRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RankingTableTest {
    @Test
    @DisplayName("RankingTable에서 특정 등수의 당첨 결과를 가지고 오는 테스트")
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
