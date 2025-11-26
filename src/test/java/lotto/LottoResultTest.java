package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("당첨 통계를 계산한다")
    @ParameterizedTest
    @CsvSource({
            "6, 1",
            "5, 1",
            "0, 1",
            "4, 0",
            "3, 0",
            "2, 0",
            "1, 0",
    })
    void lottoResult(int matchCount, int expectedCount) {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7)), new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult result = new LottoResult(lottos, winningNumbers);
        assertThat(result.matchCounts().getOrDefault(matchCount, 0)).isEqualTo(expectedCount);
    }

    @DisplayName("당첨금 수익률을 계산한다")
    @Test
    void calculateProfitRate() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 7, 8, 9)), new Lotto(List.of(1, 2, 3, 10, 11, 12)), new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = new LottoResult(lottos, winningNumbers);
        double rounded = Math.round(lottoResult.profitRate() * 10) / 10.0;
        assertThat(rounded).isEqualTo(3.3);
    }
}
