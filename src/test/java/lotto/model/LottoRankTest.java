package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    void rank() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        assertThat(LottoRank.rankByMatchCountAndBonusNumber(new LottoNumbers(lottoNumbers), new WinningNumbers(winningNumbers, 6))).isEqualTo(LottoRank.SECOND);
    }
}