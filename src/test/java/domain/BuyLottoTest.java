package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BuyLottoTest {

    @Test
    void 로또금액이_천원_이하로_입력할_경우() {
        assertThatThrownBy(() -> {
            new BuyLotto(900);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또금액에_맞게_로또구매개수가_잘_나오는지_확인() {
        BuyLotto buyLotto = new BuyLotto(3000);
        assertThat(buyLotto.buyLottoCount()).isEqualTo(3);
    }

}