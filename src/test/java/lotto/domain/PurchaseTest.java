package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest {

    private Purchase purchase;

    @Test
    void 로또_구매_갯수() {
        // given
        List<Lotto> lottos = List.of(new Lotto(1, 2, 3, 4, 5, 6));
        purchase = new Purchase(lottos);
        // when
        int lottoCount = purchase.lottosSize();
        // then
        assertThat(lottoCount).isEqualTo(1);
    }


}
