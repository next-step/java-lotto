package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = LottoResult.from(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("drawLottoResult Test")
    @Test
    void drawLottoResult_return_prize_and_prize_matchCount() {
        List<LottoNumbers> allLottoNumbers = Arrays.asList(
            LottoNumbers.from(Arrays.asList(1, 2, 3)),
            LottoNumbers.from(Arrays.asList(4, 5, 6)),
            LottoNumbers.from(Arrays.asList(1, 2, 3, 4)),
            LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5))
        );

        Map<Prize, Integer> drawLottoResult =
            lottoResult.drawLottoResult(allLottoNumbers, 8);

        Assertions.assertAll(
            () -> assertThat(drawLottoResult.get(Prize.FIFTH)).isEqualTo(2),
            () -> assertThat(drawLottoResult.get(Prize.FOURTH)).isEqualTo(1),
            () -> assertThat(drawLottoResult.get(Prize.THIRD)).isEqualTo(1)
        );
    }
}
