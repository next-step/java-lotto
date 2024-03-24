package lotto.domain.lotto;

import lotto.domain.lotto.strategy.LottoGeneratingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {
    LottoGeneratingStrategy lottoGeneratingStrategyStub = () -> {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        return Lotto.valueOf(lottoNumbers);
    };

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 14})
    @DisplayName("numberOfLottoToPurchase 만큼 로또를 생성한다.")
    void testPurchaseLotto(int numberOfLottoToPurchase) {
        Lottos lottos = LottoStore.purchaseLotto(lottoGeneratingStrategyStub, numberOfLottoToPurchase);
        assertThat(lottos.lottos().size()).isEqualTo(numberOfLottoToPurchase);
    }
}
