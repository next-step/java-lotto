package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoStoreTest {

    private static final LottoStore LOTTO_STORE = new LottoStore((min, max, size) -> List.of(1, 2, 3, 4, 5, 6));

    @Test
    public void 수동로또를_생성한다() {
        List<String> input = List.of("1,2,3,4,5,6", "4,5,6,7,8,45");

        List<Lotto> lottos = LOTTO_STORE.passivityLottos(input);

        List<Lotto> result = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(4, 5, 6, 7, 8, 45)));
        assertThat(lottos).containsExactlyInAnyOrderElementsOf(result);
    }


    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 15000})
    public void 로또는_천원단위로_생선된다(int fee) {
        List<Lotto> result = LOTTO_STORE.autoLottos(new Money(fee));
        assertThat(result).hasSize(fee / 1000);
    }


    @ParameterizedTest
    @MethodSource("provideLottoScenarios")
    public void 로또_결과를_확인한다(List<Integer> userNumbers, LottoRank expectedRank) {
        Lotto userLottos = new Lotto(userNumbers);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        Rank result = LOTTO_STORE.check(userLottos, winningLotto);

        assertThat(result).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideLottoScenarios() {
        return Stream.of(Arguments.of(List.of(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), LottoRank.SECOND),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), LottoRank.FIFTH));
    }

}
