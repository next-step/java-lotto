package lotto.domain.lotto.strategy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ManualGeneratingStrategyTest {
    Lotto manualLotto = Lotto.valueOf(Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList()));

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 14})
    @DisplayName("lottos(): totalNumberOfLottoToPurchase(수동: manualLottos.size(), 자동: totalNumberOfLottoToPurchase - 수동 개수) 만큼 Lotto가 생성된다.")
    void testLottos(int totalNumberOfLottoToPurchase) {
        Lottos manualLottos = Lottos.valueOf(List.of(manualLotto));
        Lottos lottos = new ManualGeneratingStrategy().lottos(totalNumberOfLottoToPurchase, manualLottos);
        assertThat(lottos.lottos().size()).isEqualTo(totalNumberOfLottoToPurchase);
    }
}
