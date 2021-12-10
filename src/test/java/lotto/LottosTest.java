package lotto;

import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.factory.LottoAnswerFactory;
import lotto.domain.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottosTest {

    static List<Lotto> manualLottos;
    static Lottos lottos;
    static LottoAnswerFactory factory;

    @BeforeAll
    static void 사전_로또_번호_생성() {
        manualLottos = new ArrayList<>();
        factory = new LottoAnswerFactory();

        manualLottos.add(factory.newInstance("1,2,3,4,5,6"));
        manualLottos.add(factory.newInstance("11,12,13,14,15,16"));

        lottos = new Lottos(manualLottos);
    }

    @Test
    void 구매_개수만큼_로또_반환() {
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(2);
    }

    @Test
    void 로또_수동_자동_합치기() {
        lottos.addAutoLottos(Number.of("2"));
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(4);
    }
}
