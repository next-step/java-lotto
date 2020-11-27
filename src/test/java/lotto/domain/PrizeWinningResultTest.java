package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeWinningResultTest {

    @DisplayName("구입금액이 0원 이하면 exception 이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void exception(int paidMoney){
        assertThatThrownBy(() -> PrizeWinningResult.builder().paidMoney(paidMoney))
                .isInstanceOf(PrizeWinningResultBulderException.class);
    }

    @DisplayName("동일한 순위의 로또가 하나이상이면 로또 수 만큼 count 가 된다.")
    @Test
    void prizeCount(){
        List<RankedLotto> rankedLottoList = Arrays.asList(
                new RankedLotto(LottoRanking.SECOND, new Lotto("1,2,3,4,5,6") ),
                new RankedLotto(LottoRanking.SECOND, new Lotto("1,2,3,4,6,10") ),
                new RankedLotto(LottoRanking.MISS, new Lotto("10,11,12,13,14,15"))
        );

        PrizeWinningResult result = PrizeWinningResult.builder()
                .paidMoney(2000)
                .rankedLottos(rankedLottoList)
                .build();

        assertThat(result.getRankedLottoCount(LottoRanking.SECOND)).isEqualTo(2);
    }

}