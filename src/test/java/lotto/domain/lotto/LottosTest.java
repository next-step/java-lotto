package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.budget.Budget;
import lotto.domain.lottorank.LottoRank;
import lotto.domain.lottorank.LottoRanks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    private static final int PRICE_OF_LOTTO = 1000;

    @DisplayName("구매할 수 있는 개수 만큼 로또가 구매된다.")
    @ValueSource(strings = {"10000", "14500"})
    @ParameterizedTest
    void Given_구매_금액_When_로또자동_생성_Then_구매금액에_맞게_생성(final String budget) {
        final int numberOfLotto = Integer.parseInt(budget) / PRICE_OF_LOTTO;

        final Lottos autoLottos = Lottos.createLottos(new ArrayList<>(), new Budget(budget));

        assertThat(autoLottos.size()).isEqualTo(numberOfLotto);
    }

    @DisplayName("두 개의 객체를 합쳐 새로운 객체를 반환한다.")
    @Test
    void Given_두_개의_로또_리스트_When_합치기_Then_리스트_병합() {
        final Lottos lottos = Lottos.createLottos(Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7"), new Budget("3000"));

        assertThat(lottos.size()).isEqualTo(3);
    }

    @DisplayName("로또 결과 등수 리스트를 반환한다.")
    @Test
    void When_리스트_get_Then_결과_등수_리스트_반환() {
        final List<LottoRank> expected = Arrays.asList(LottoRank.SECOND, LottoRank.FIFTH);
        final LottoRanks lottoRanks = new LottoRanks(expected);

        assertThat(lottoRanks.get()).isEqualTo(expected);
    }

    @DisplayName("로또 결과 당첨금 리스트를 반환한다.")
    @Test
    void When_리스트_당첨금_리스트_얻기_Then_당첨금_리스트_반환() {
        final List<LottoRank> expected = Arrays.asList(LottoRank.SECOND, LottoRank.FIFTH);
        final LottoRanks lottoRanks = new LottoRanks(expected);

        assertThat(lottoRanks.getAmounts()).isEqualTo(
                Arrays.asList(LottoRank.SECOND.getAmount(), LottoRank.FIFTH.getAmount()));
    }
}
