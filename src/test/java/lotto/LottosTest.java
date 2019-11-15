package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        List<LottoNo> numbers = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3),
                new LottoNo(4), new LottoNo(5), new LottoNo(6));

        lotto = new Lotto(numbers);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);
        this.lottos = new Lottos(() -> lottos);
    }

    @Test
    void 로또_수동_테스트() {
        List<String> manualLottos = Arrays.asList("1, 2, 3, 4, 5, 6", "10, 11, 12, 13, 14, 15", "5, 6, 7, 8, 9, 10");
        Lottos lottos = new Lottos(new ManualLottosGenerator(manualLottos));
        assertThat(lottos.getLottos()).hasSize(3);
    }

    @Test
    void 수동_자동_로또_리스트_합치기() {
        Money money = new Money(10000);
        money.purchased(3);
        List<String> manualLottosNumber = Arrays.asList("1, 2, 3, 4, 5, 6", "10, 11, 12, 13, 14, 15", "5, 6, 7, 8, 9, 10");
        Lottos manualLottos = new Lottos(new ManualLottosGenerator(manualLottosNumber));
        Lottos autoLottos = new Lottos(new AutoLottosGenerator(money));
        assertThat(autoLottos.getLottos()).hasSize(7);
        assertThat(autoLottos.addManualLottos(manualLottos.getLottos())).hasSize(10);
    }
}
