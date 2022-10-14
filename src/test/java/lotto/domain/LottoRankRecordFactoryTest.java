package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankRecordFactoryTest {

    @Test
    @DisplayName("당첨정보에 따른 LottoRankRecord(등수) 생성")
    void createLottoRankRecord() {
        List<CorrectInfo> correctInfos = List.of(
                new CorrectInfo(2),
                new CorrectInfo(3),
                new CorrectInfo(4),
                new CorrectInfo(5),
                new CorrectInfo(5, true),
                new CorrectInfo(6, false)
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