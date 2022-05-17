package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottosTest {

    @ParameterizedTest
    @MethodSource("로또_갯수_만큼_로또_생성_확인_객체로_생성_매개변수")
    void 로또_갯수_만큼_로또_생성_확인_객체로_생성(int purchaseAmount, int purchaseLottoCount) {
        final int LOTTO_PRICE = 1000;
        assertThat(new Lottos(new PurchaseLottoCount(purchaseAmount, LOTTO_PRICE)).getLottoAmount()).isEqualTo(purchaseLottoCount);
    }

    static Stream<Arguments> 로또_갯수_만큼_로또_생성_확인_객체로_생성_매개변수() {
        return Stream.of(
                arguments(10000, 10),
                arguments(1000, 1),
                arguments(15000, 15)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 1, 15})
    void 로또_갯수_만큼_로또_생성_확인_숫자로_생성(int purchaseLottoCount) {
        assertThat(new Lottos(purchaseLottoCount).getLottoAmount()).isEqualTo(purchaseLottoCount);
    }
}
