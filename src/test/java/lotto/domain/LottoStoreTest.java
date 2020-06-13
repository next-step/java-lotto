package lotto.domain;

import lotto.domain.data.Lotto;
import lotto.domain.data.ManualLotto;
import lotto.domain.data.PriceLotto;
import lotto.domain.generator.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStoreTest {

    private static final int PRICE_PER_ONE =  1000;

    @DisplayName("지불금액만큼 로또가 구매된다.")
    @ParameterizedTest
    @ValueSource(ints = {2000, 3000, 4000})
    public void buyTest(int price) {
        LottoStore lottoStore = new LottoStore(new LottoGenerator());
        PriceLotto priceLotto = PriceLotto.of(price);
        List<Lotto> lottos = lottoStore.buy(priceLotto, ManualLotto.list(List.of(List.of(1,2,3,4,5,6), List.of(7,8,9,10,11,12))));

        final int count = (int) Math.floor(price / PRICE_PER_ONE);

        assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("구매된 로또에 수동번호으로 구매 요구한 로또가 생성되어있다.")
    @Test
    public void buyManualLottosTest() {
        LottoStore lottoStore = new LottoStore(new LottoGenerator());
        List<ManualLotto> manualLottos = ManualLotto.list(List.of(List.of(1,2,3,4,5,6), List.of(7,8,9,10,11,12)));

        List<Lotto> lottos = lottoStore.buy(PriceLotto.of(2000), manualLottos);

        assertThat(lottos.size()).isEqualTo(2);
        assertThat(lottos).containsOnly(Lotto.of(manualLottos.get(0).getNumbers()), Lotto.of(manualLottos.get(1).getNumbers()));
    }

    @DisplayName("수동번호가 없어도 정상적으로 구매가 된다.")
    @Test
    public void buyTestNoManual() {
        LottoStore lottoStore = new LottoStore(new LottoGenerator());

        List<Lotto> lottos = lottoStore.buy(PriceLotto.of(3000), new ArrayList<>());

        assertThat(lottos.size()).isEqualTo(3);
    }

    @DisplayName("로또금액으로 구매할 수 있는 로또 수보다 수동으로 생성할 번호가 많으면 IllegalArgument 예외가 발생한다.")
    @Test
    public void buyOverManualLottosTest() {
        LottoStore lottoStore = new LottoStore(new LottoGenerator());
        List<ManualLotto> manualLottos = ManualLotto.list(List.of(List.of(1,2,3,4,5,6), List.of(7,8,9,10,11,12)));

        assertThatThrownBy(() -> {
            lottoStore.buy(PriceLotto.of(1000), manualLottos);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또금액은 1000원 미만으로 입력될 경우 IllegalArgument 예외가 발생한다.")
    @Test
    public void validateBuyTest() {
        LottoStore lottoStore = new LottoStore(new LottoGenerator());
        int price = 500;

        assertThatThrownBy(() -> {
            lottoStore.buy(PriceLotto.of(price), new ArrayList<>());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
