package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {10, 1, 15})
    void 로또_갯수_만큼_로또_생성_확인_객체로_생성(int purchaseLottoCount) {
        final int LOTTO_PRICE = 1000;
        assertThat(new Lottos(new PurchaseLottoCount(purchaseLottoCount, LOTTO_PRICE)).getLottoAmount()).isEqualTo(purchaseLottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 1, 15})
    void 로또_갯수_만큼_로또_생성_확인_숫자로_생성(int purchaseLottoCount) {
        assertThat(new Lottos(purchaseLottoCount).getLottoAmount()).isEqualTo(purchaseLottoCount);
    }
}
