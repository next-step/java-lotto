package lotto.data;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.Lotto;
import lotto.Wallet;

class LottosTest {
    private Wallet wallet;

    @DisplayName("create_with_manual_lotto")
    @ParameterizedTest
    @MethodSource("getManualLottos")
    void manual_lotto(List<Lotto> manualLottos) {
        wallet = new Wallet((manualLottos.size() + 1) * 1000, manualLottos.size());
        assertThat(new Lottos(wallet, manualLottos).getCount()).isEqualTo(1 + manualLottos.size());
    }

    private static Stream<Arguments> getManualLottos() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                                           new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                                           new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                                           new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                                           new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))))),
                Arguments.of(Arrays.asList(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                                           new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                                           new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                                           new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))))),
                Arguments.of(Arrays.asList(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                                           new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                                           new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)))))
        );
    }
}
