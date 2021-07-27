package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("출력")
class ResultViewTest {

    public static Stream<Arguments> validLotto() {
        return Stream.of(
            Arguments.of(Arrays.asList(LottoFactory.createRandom(),
                LottoFactory.createRandom(),
                LottoFactory.createRandom(),
                LottoFactory.createRandom()
            )));
    }

    @DisplayName("구매한 로또 출력")
    @ParameterizedTest
    @MethodSource("validLotto")
    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        // given

        // when
        ResultView.printPurchasedLottos(purchasedLottos);

        // then

    }
}
