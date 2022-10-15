package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("일등 시 수익률")
    void firstProfitRatio() {
        int originAmount = 1000;
        LottoRankRecord lottoRankRecord = new LottoRankRecord(LottoRank.FIRST, 1);
        LottoResult lottoResult = new LottoResult(new LottoRankRecordBox(List.of(lottoRankRecord)));

        double ratio = lottoResult.retrieveProfitRatio(originAmount);
        Assertions.assertThat(ratio).isEqualTo(LottoResult.getTwoDecimalPointResult(LottoRank.FIRST.getWinPrize(), originAmount));
    }

    @Test
    @DisplayName("2등 시 수익률")
    void secondProfitRatio() {
        int originAmount = 1000;
        LottoRankRecord lottoRankRecord = new LottoRankRecord(LottoRank.SECOND, 1);
        LottoResult lottoResult = new LottoResult(new LottoRankRecordBox(List.of(lottoRankRecord)));

        double ratio = lottoResult.retrieveProfitRatio(originAmount);
        Assertions.assertThat(ratio).isEqualTo(LottoResult.getTwoDecimalPointResult(LottoRank.SECOND.getWinPrize(), originAmount));
    }

    @Test
    @DisplayName("복합 등수 수익률")
    void mixedProfitRatio() {
        int originAmount = 1000;
        List<LottoRankRecord> lottoRankRecords = List.of(
                new LottoRankRecord(LottoRank.SECOND, 2),
                new LottoRankRecord(LottoRank.FIRST, 1),
                new LottoRankRecord(LottoRank.THIRD, 2)
        );
        long sum = lottoRankRecords.stream()
                .mapToLong(LottoRankRecord::calculateSum)
                .reduce(0, Long::sum);
        LottoResult lottoResult = new LottoResult(new LottoRankRecordBox(lottoRankRecords));

        double ratio = lottoResult.retrieveProfitRatio(originAmount);

        Assertions.assertThat(ratio).isEqualTo(LottoResult.getTwoDecimalPointResult(sum, originAmount));
    }
}