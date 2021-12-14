package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또 구입시 요청에 전달된 파라미터 객체 테스트")
class PurchaseLottosRequestTest {

    @DisplayName("정상적인 로또 구입 요청")
    @ParameterizedTest
    @MethodSource("validRequestParameterCases")
    void createValidCaseTest(int purchasingPrice, int manualPurchasingSize) {
        // when & then
        assertThat(PurchaseLottosRequest.of(purchasingPrice, manualPurchasingSize)).isNotNull();
    }

    @DisplayName("비정상적인 로또 구입 요청")
    @ParameterizedTest
    @MethodSource("invalidRequestParameterCases")
    void createInvalidCaseTest(int invalidPurchasingPrice, int invalidManualPurchasingSize) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> PurchaseLottosRequest.of(invalidPurchasingPrice, invalidManualPurchasingSize)
        );
    }

    @DisplayName("구입한 로또 갯수 반환")
    @ParameterizedTest
    @MethodSource("validRequestParameterCases")
    void purchasingLottoSizeTest(int purchasingPrice, int manualPurchasingSize) {
        // when
        PurchaseLottosRequest request = PurchaseLottosRequest.of(purchasingPrice, manualPurchasingSize);
        // then
        assertThat(request.purchasingLottoSize()).isEqualTo(purchasingPrice / Lotto.PRICE);
    }

    private static Stream<Arguments> validRequestParameterCases() {
        return Stream.of(
                Arguments.of(Lottos.MIN_LOTTO_PRICE, 1),
                Arguments.of(Lotto.PRICE * 10, 5),
                Arguments.of(Lotto.PRICE * 100, 50),
                Arguments.of(Lotto.PRICE * 1000, 500)
        );
    }

    private static Stream<Arguments> invalidRequestParameterCases() {
        return Stream.concat(Stream.of(invalidPurchasingPriceCases()), Stream.of(invalidManualPurchasingSizeCases()));
    }

    private static Arguments[] invalidPurchasingPriceCases() {
        return new Arguments[]{Arguments.of(Integer.MIN_VALUE, 0),
                Arguments.of(0, 0),
                Arguments.of(Lottos.MIN_LOTTO_PRICE - 1, 0)};
    }

    private static Arguments[] invalidManualPurchasingSizeCases() {
        return new Arguments[]{Arguments.of(Integer.MIN_VALUE, 0),
                Arguments.of(0, 0),
                Arguments.of(Lottos.MIN_LOTTO_PRICE - 1, 0)};
    }
}
