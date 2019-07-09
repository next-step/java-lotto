package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("랭크를 제대로 가지고 오는 지 확인한다.")
    @Test
    void getRank() {
        Lotteries lotteries = new Lotteries(Arrays.asList(
                new LottoNumbers(
                        new LinkedHashSet<>(Arrays.asList(
                                Number.of(4),
                                Number.of(5),
                                Number.of(6),
                                Number.of(7),
                                Number.of(8),
                                Number.of(9))))));

        WinningNumber winningNumber = new WinningNumber(new LottoNumbers(
                new LinkedHashSet<>(Arrays.asList(
                        Number.of(4),
                        Number.of(5),
                        Number.of(6),
                        Number.of(7),
                        Number.of(8),
                        Number.of(20)))), Number.of(9));

        LottoResult lottoResult = new LottoResult(lotteries, winningNumber);

        assertThat(lottoResult.getRankResult().size()).isEqualTo(1);
        assertThat(lottoResult.getRankResult().get(0)).isEqualTo(Rank.SECOND);
    }
}
