package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BuyLottoTest {
    @ParameterizedTest
    @ValueSource(ints = {900,800,700})
    void 로또금액이_천원_이하로_입력할_경우(int money) {
        assertThatThrownBy(() -> {
            new BuyLotto(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000,2000,3000})
    void 로또금액에_맞게_로또_구매개수가_잘_나오는지_확인(int money) {
        BuyLotto buyLotto = new BuyLotto(money);
        assertThat(buyLotto.buyLottoCount()).isEqualTo(money / 1000);
    }

}