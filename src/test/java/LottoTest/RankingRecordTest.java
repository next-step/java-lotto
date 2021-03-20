package LottoTest;

import lotto.domain.Rank;
import lotto.domain.RankingRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RankingRecordTest {
    @Test
    @DisplayName("RankingRecord 인스턴스 생성 테스트")
    void When_New_Then_NoAssert() {
        assertDoesNotThrow(() -> new RankingRecord(Rank.SECOND, 0));
    }

    @Test
    @DisplayName("당첨자 증가 테스트")
    void When_IncreaseWinner_Then_Increased() {
        //when
        RankingRecord rankingRecord = new RankingRecord(Rank.FORTH, 1);

        //then
        assertThat(rankingRecord.increaseWinner()).isEqualTo(new RankingRecord(Rank.FORTH, 2));
    }

    @Test
    @DisplayName("특정 등수의 총 당첨금 계산 테스트")
    void When_Amount_Then_ReturnTotalAmount() {
        //gvien
        int winners = 2;
        RankingRecord rankingRecord = new RankingRecord(Rank.FORTH, winners);

        //when
        int reward = rankingRecord.amounts();

        //when
        assertThat(reward).isEqualTo(Rank.FORTH.reward() * winners);
    }
}
