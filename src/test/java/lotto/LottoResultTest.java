package lotto;

import lotto.dto.LottoResult;
import lotto.model.Money;
import lotto.model.Rank;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 결과 반환 DTO 테스트")
public class LottoResultTest {

    @Test
    @DisplayName("로또 결과와 구매 금액으로 수익률을 계산한다.")
    void getYieldTest() {
        List<Rank> ranks = Lists.newArrayList(Rank.FOURTH, Rank.OTHER);
        Money buyingMoney = new Money(14000);

        LottoResult lottoResult = new LottoResult(ranks);

        assertThat(String.format("%.2f", lottoResult.getYield(buyingMoney))).isEqualTo("0.36");
    }
}
