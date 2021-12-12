package lotto;

import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.domain.factory.LottoFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottosTest {

    @Test
    void 수동_2_자동_2() {
        Price price = Price.of("4000");
        List<String> manualList = new ArrayList<>();
        manualList.add("1,2,3,4,5,6");
        manualList.add("11,12,13,14,15,16");

        Lottos lottos = LottoFactory.lottos(price, manualList);

        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(4);
    }

    @Test
    void 수동_0개_자동_4개() {
        Price price = Price.of("4000");
        List<String> manualList = new ArrayList<>();

        Lottos lottos = LottoFactory.lottos(price, manualList);
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(4);
    }

    @Test
    void 수동_4개_자동_0개() {
        Price price = Price.of("4000");
        List<String> manualList = new ArrayList<>();
        manualList.add("1,2,3,4,5,6");
        manualList.add("11,12,13,14,15,16");
        manualList.add("21,22,23,24,25,26");
        manualList.add("31,32,33,34,35,36");

        Lottos lottos = LottoFactory.lottos(price, manualList);
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(4);
    }
}
