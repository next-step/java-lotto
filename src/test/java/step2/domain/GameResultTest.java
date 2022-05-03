package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "로또 번호 테스트")
class GameResultTest {

    @Test
    void 맞춘_개수를_입력_받아서_등수_와_카운트로_구성되는_맵을_생성() {
        List<Long> hitCounts = Arrays.asList(3L, 4L, 5L, 6L);

        GameResult gameResult = new GameResult(hitCounts);

        assertThat(gameResult.getRankCount()).containsExactly(
                entry(LottoRank.FOURTH, 1),
                entry(LottoRank.THIRD, 1),
                entry(LottoRank.SECOND, 1),
                entry(LottoRank.FIRST, 1)
        );
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : 5000 / {0}  = {2}")
    @CsvSource(
            value = {
                    "5000:3:1",
                    "2000:3:2.5",
                    "1000:3:5"
            },
            delimiter = ':'
    )
    void 구매금액을_입력받아서_수익률을_계산(int purchaseAmount, Long hitCount, double returnRate) {
        List<Long> hitCounts = List.of(hitCount);

        GameResult gameResult = new GameResult(hitCounts);

        assertThat(gameResult.calculateReturnRate(purchaseAmount)).isEqualTo(returnRate);
    }
}