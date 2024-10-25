package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoStoreTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 15000})
    public void 로또는_천원단위로_생선된다(int fee) {
        LottoStore lottoStore = new LottoStore();

        List<Lotto> result = lottoStore.buy(new Money(fee));
        assertThat(result).hasSize(fee / 1000);
    }

    @Test
    public void 로또는_천원단위가_아니면_예외가_발생한다() {
        LottoStore lottoStore = new LottoStore();
        assertThatIllegalArgumentException().isThrownBy(() -> lottoStore.buy(new Money(999)));
    }

    @ParameterizedTest
    @MethodSource("provideLottoScenarios")
    public void 로또_결과를_확인한다(List<Integer> userNumbers, LottoRank expectedRank) {
        LottoStore lottoStore = new LottoStore();
        Lotto userLottos = new Lotto(userNumbers);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Rank result = lottoStore.check(userLottos, winningLotto);

        assertThat(result).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideLottoScenarios() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), LottoRank.SIX_MATCH),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), LottoRank.FIVE_MATCH),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), LottoRank.THREE_MATCH)
        );
    }

}
