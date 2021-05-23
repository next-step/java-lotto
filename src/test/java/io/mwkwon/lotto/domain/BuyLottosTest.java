package io.mwkwon.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyLottosTest {

    @Test
    void 구매_로또_일급_컬렉션_객체_정상_생성_테스트() {
        List<Lotto> lotto = Arrays.asList(new Lotto("1,2,3,4,5,6"));
        BuyLottos buyLottos = new BuyLottos(lotto);
        assertThat(buyLottos).isEqualTo(new BuyLottos(lotto));
    }
}
