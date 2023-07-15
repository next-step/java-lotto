package lottogame.domain;

import lottogame.service.LottoService;
import lottogame.service.response.LottoCheckResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoResult 클래스")
class LottoResultTest {

    @Nested
    @DisplayName("new 생성자는")
    class Describe_Constructor {

        @Nested
        @DisplayName("로또 순위들을 받으면 ")
        class Context_Input_Lotto_Ranks {

            private static final int PURCHASE_COUNT = 3;
            private final List<LottoRank> lottoRanks = List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.NONE);

            private final LottoResult lottoResult = new LottoResult(lottoRanks);
            private final Double expectedEarningRate = getExpectedEarningRate();
            private final Map<LottoRank, Long> expectedLottoRankCounts = Map.of(LottoRank.FIRST, 1L, LottoRank.SECOND, 1L, LottoRank.NONE, 1L);

            @Test
            @DisplayName("순위 집계와 수익률을 생성한다")
            void It_Calculate_Count_By_Rank_And_Earning_Rate() {

                Assertions.assertThat(lottoResult.getEarningRate()).isEqualTo(expectedEarningRate);
                Assertions.assertThat(lottoResult.getLottoRankCounts()).isEqualTo(expectedLottoRankCounts);
            }

            private Double getExpectedEarningRate() {
                double totalMoney = PURCHASE_COUNT * LottoTicket.PURCHASABLE_UNIT;
                double earnMoney = LottoRank.FIRST.getMoney() + LottoRank.SECOND.getMoney();
                return earnMoney / totalMoney;
            }
        }
    }
}
