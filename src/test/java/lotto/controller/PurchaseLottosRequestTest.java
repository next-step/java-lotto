package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("로또 구입시 요청에 전달된 파라미터 객체 테스트")
class PurchaseLottosRequestTest {

    @DisplayName("정상적인 로또 구입 요청")
    @ParameterizedTest
    @MethodSource("validRequestParameterCases")
    void createValidCaseTest(int purchasingSize, List<ManualLottoRequest> manualPurchasingLottos) {
        // when & then
        assertThat(PurchaseLottosRequest.of(Lotto.PRICE * purchasingSize, manualPurchasingLottos)).isNotNull();
    }

    @DisplayName("비정상적인 로또 구입 요청")
    @ParameterizedTest
    @MethodSource("invalidRequestParameterCases")
    void createInvalidCaseTest(int invalidPurchasingPrice, List<ManualLottoRequest> invalidManualPurchasingLottos) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> PurchaseLottosRequest.of(invalidPurchasingPrice, invalidManualPurchasingLottos)
        );
    }

    @DisplayName("수동으로 입력된 로또 정보 반환")
    @ParameterizedTest
    @MethodSource("validRequestParameterCases")
    void manualLottosTest(int purchasingSize, List<ManualLottoRequest> manualPurchasingLottos) {
        // given
        PurchaseLottosRequest request = PurchaseLottosRequest.of(Lotto.PRICE * purchasingSize, manualPurchasingLottos);
        int automatedLottoSize = request.automatedLottoSize();
        // when
        List<Lotto> manualLottos = request.manualLottos();
        int manualLottoSize = manualLottos.size();
        // then
        assertAll(
                () -> assertThat(manualLottos).isNotNull(),
                () -> assertThat(automatedLottoSize + manualLottoSize).isEqualTo(purchasingSize)
        );
    }

    @DisplayName("구입한 로또 갯수 반환")
    @ParameterizedTest
    @MethodSource("validRequestParameterCases")
    void automatedLottoSizeTest(int purchasingSize, List<ManualLottoRequest> manualPurchasingLottos) {
        // when
        PurchaseLottosRequest request = PurchaseLottosRequest.of(Lotto.PRICE * purchasingSize, manualPurchasingLottos);
        // then
        assertThat(request.automatedLottoSize())
                .isEqualTo(Lotto.PRICE * purchasingSize / Lotto.PRICE - manualPurchasingLottos.size());
    }

    private static Stream<Arguments> validRequestParameterCases() {
        return Stream.of(
                Arguments.of(1, Collections.emptyList()),
                Arguments.of(10, Collections.singletonList(ManualLottoRequest.from(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                Arguments.of(100, Arrays.asList(ManualLottoRequest.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        ManualLottoRequest.from(Arrays.asList(7, 8, 9, 10, 11, 12))))
        );
    }

    private static Stream<Arguments> invalidRequestParameterCases() {
        return Stream.concat(Stream.of(invalidPurchasingPriceCases()), Stream.of(invalidManualPurchasingSizeCases()));
    }

    private static Arguments[] invalidPurchasingPriceCases() {
        return new Arguments[]{Arguments.of(Integer.MIN_VALUE, Collections.emptyList()),
                Arguments.of(0, Collections.singletonList(ManualLottoRequest.from(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                Arguments.of(Lottos.MIN_LOTTO_PRICE - 1, Arrays.asList(ManualLottoRequest.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        ManualLottoRequest.from(Arrays.asList(7, 8, 9, 10, 11, 12))))};
    }

    private static Arguments[] invalidManualPurchasingSizeCases() {
        return new Arguments[]{Arguments.of(Lotto.PRICE, Arrays.asList(ManualLottoRequest.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
                ManualLottoRequest.from(Arrays.asList(7, 8, 9, 10, 11, 12))))};
    }
}
