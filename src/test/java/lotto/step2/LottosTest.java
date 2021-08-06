package lotto.step2;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

 class LottosTest {

    @Test
    @DisplayName("로또 구입 금액에 맞는 로또 개수 생성")
     void test() {
        int price = 14000;
        Lottos lottos = new Lottos();
        ArrayList<ArrayList<Integer>> lottoList = lottos.createLottos(price);
        Assertions.assertThat(lottoList.size()).isEqualTo(14);

    }
}
