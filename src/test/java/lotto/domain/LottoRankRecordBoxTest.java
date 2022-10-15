package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoRankRecordBoxTest {

    @Test
    void getSum() {
        List<LottoRankRecord> lottoRankRecords = List.of(
                new LottoRankRecord(LottoRank.FIRST, 3),
                new LottoRankRecord(LottoRank.SECOND, 2),
                new LottoRankRecord(LottoRank.NONE, 10)
        );
        LottoRankRecordBox lottoRankRecordBox = new LottoRankRecordBox(lottoRankRecords);

        long first3 = LottoRank.FIRST.getWinPrize() * 3;
        long second2 = LottoRank.SECOND.getWinPrize() * 2;
        assertThat(lottoRankRecordBox.retrieveWinPrizeSum()).isEqualTo(first3 + second2);
    }


}