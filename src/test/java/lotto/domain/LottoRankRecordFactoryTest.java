package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankRecordFactoryTest {

    @Test
    @DisplayName("당첨정보에 따른 LottoRankRecord(등수) 생성")
    void createLottoRankRecord() {
        List<WinningResult> correctInfos = List.of(
                new WinningResult(2),
                new WinningResult(3),
                new WinningResult(4),
                new WinningResult(5),
                new WinningResult(5, true),
                new WinningResult(6, false)
        );
        assertThat(LottoRankRecordFactory.createLottoRankRecords(correctInfos))
                .containsExactly(
                        new LottoRankRecord(LottoRank.NONE, 1),
                        new LottoRankRecord(LottoRank.FOURTH, 1),
                        new LottoRankRecord(LottoRank.THIRD, 1),
                        new LottoRankRecord(LottoRank.SECOND, 1),
                        new LottoRankRecord(LottoRank.BONUS, 1),
                        new LottoRankRecord(LottoRank.FIRST, 1)
                );
    }

}