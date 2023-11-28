package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCollectionTest {

    static class AlwaysReturn_1_2_3_4_5_6 extends RandomGenerator {

        @Override
        public List<Integer> generate() {
            return Arrays.asList(1, 2, 3, 4, 5, 6);
        }
    }

    @Test
    @DisplayName("로또 1등 당첨")
    void FIRST() {
        LottoCollection lottoCollection = new LottoCollection(1, new AlwaysReturn_1_2_3_4_5_6());

        List<LottoRank> lottoRanks = lottoCollection.getLottoRanks(
            new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7));

        assertThat(lottoRanks).hasSize(1)
            .contains(LottoRank.FIRST);
    }

    @Test
    @DisplayName("로또 2등 당첨")
    void SECOND() {
        LottoCollection lottoCollection = new LottoCollection(1, new AlwaysReturn_1_2_3_4_5_6());

        List<LottoRank> lottoRanks = lottoCollection.getLottoRanks(
            new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 10), 6));

        assertThat(lottoRanks).hasSize(1)
            .contains(LottoRank.SECOND);
    }

    @Test
    @DisplayName("로또 3등 당첨")
    void THIRD() {
        LottoCollection lottoCollection = new LottoCollection(1, new AlwaysReturn_1_2_3_4_5_6());

        List<LottoRank> lottoRanks = lottoCollection.getLottoRanks(
            new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 10), 11));

        assertThat(lottoRanks).hasSize(1)
            .contains(LottoRank.THIRD);
    }


}