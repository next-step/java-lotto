package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "로또 번호 테스트")
class GameResultTest {

    @Test
    void 등수_리스트를_입력받아서_등수_와_카운트로_구성되는_맵을_생성() {
        List<LottoRank> ranks = List.of(LottoRank.values());

        GameResult gameResult = new GameResult(ranks);

        assertThat(gameResult.getResult()).containsExactly(
                entry(LottoRank.ETC, 1),
                entry(LottoRank.FIFTH, 1),
                entry(LottoRank.FOURTH, 1),
                entry(LottoRank.THIRD, 1),
                entry(LottoRank.SECOND, 1),
                entry(LottoRank.FIRST, 1)
        );
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : 5000 / {0}  = {2}")
    @CsvSource(
            value = {
                    "5000:FIFTH:1",
                    "2000:FIFTH:2.5",
                    "1000:FIFTH:5"
            },
            delimiter = ':'
    )
    void 구매금액을_입력받아서_수익률을_계산(int purchaseAmount, LottoRank rank, double returnRate) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(purchaseAmount);
        List<LottoRank> input = List.of(rank);
        GameResult gameResult = new GameResult(input);

        ReturnRate result = gameResult.calculateReturnRate(purchaseMoney);

        assertThat(result).isEqualTo(new ReturnRate(returnRate));
    }
}