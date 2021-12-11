package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또 구입시 요청에 전달된 파라미터 객체 테스트")
class PurchaseLottosRequestTest {

    @DisplayName("정상적인 로또 구입 요청")
    @ParameterizedTest
    @MethodSource("validPurchasingPriceCases")
    void createValidCaseTest(int purchasingPrice) {
        // when & then
        assertThat(PurchaseLottosRequest.from(purchasingPrice)).isNotNull();
    }

    @DisplayName("비정상적인 로또 구입 요청")
    @ParameterizedTest
    @MethodSource("invalidPurchasingPriceCases")
    void createInvalidCaseTest(int invalidPurchasingPrice) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> PurchaseLottosRequest.from(invalidPurchasingPrice)
        );
    }

    @DisplayName("구입한 로또 갯수 반환")
    @ParameterizedTest
    @MethodSource("validPurchasingPriceCases")
    void purchasingLottoSizeTest(int purchasingPrice) {
        // when
        PurchaseLottosRequest request = PurchaseLottosRequest.from(purchasingPrice);
        // then
        assertThat(request.purchasingLottoSize()).isEqualTo(purchasingPrice / Lotto.PRICE);
    }

    private static Stream<Integer> validPurchasingPriceCases() {
        return Stream.of(Lottos.MIN_LOTTO_PRICE, Lotto.PRICE * 10, Lotto.PRICE * 100, Lotto.PRICE * 1000);
    }

    private static Stream<Integer> invalidPurchasingPriceCases() {
        return Stream.of(Integer.MIN_VALUE, 0, Lottos.MIN_LOTTO_PRICE - 1);
    }
}
