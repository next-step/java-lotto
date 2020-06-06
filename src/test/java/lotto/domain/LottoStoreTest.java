package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStoreTest {

    private static final int PRICE_PER_ONE =  1000;

    @DisplayName("지불금액만큼 로또가 구매된다.")
    @ParameterizedTest
    @ValueSource(ints = {2000, 3000, 4000})
    public void buyTest(int price) {
        LottoStore lottoStore = new LottoStore();
        PriceLotto priceLotto = PriceLotto.of(price);
        List<Lotto> lottos = lottoStore.buy(priceLotto, ManualLottoMemo.of(List.of("1,2,3,4,5,6", "7,8,9,10,11,12")));

        final int count = (int) Math.floor(price / PRICE_PER_ONE);

        assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("구매된 로또에 수동번호으로 구매 요구한 로또가 생성되어있다.")
    @Test
    public void buyManualLottosTest() {
        LottoStore lottoStore = new LottoStore();
        ManualLottoMemo lottoMemo = ManualLottoMemo.of(List.of("1,2,3,4,5,6", "7,8,9,10,11,12"));

        List<Lotto> lottos = lottoStore.buy(PriceLotto.of(2000), lottoMemo);

        assertThat(lottos.size()).isEqualTo(2);
        assertThat(lottos).containsOnly(Lotto.of(lottoMemo.getLottoMemo(0)), Lotto.of(lottoMemo.getLottoMemo(1)));
    }

    @DisplayName("수동번호가 없어도 정상적으로 구매가 된다.")
    @Test
    public void buyTestNoManual() {
        LottoStore lottoStore = new LottoStore();

        List<Lotto> lottos = lottoStore.buy(PriceLotto.of(3000), ManualLottoMemo.empty());

        assertThat(lottos.size()).isEqualTo(3);
    }

    @DisplayName("로또금액으로 구매할 수 있는 로또 수보다 수동으로 생성할 번호가 많으면 IllegalArgument 예외가 발생한다.")
    @Test
    public void buyOverManualLottosTest() {
        LottoStore lottoStore = new LottoStore();

        assertThatThrownBy(() -> {
            lottoStore.buy(PriceLotto.of(1000), ManualLottoMemo.of(List.of("1,2,3,4,5,6", "7,8,9,10,11,12")));
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또금액은 1000원 미만으로 입력될 경우 IllegalArgument 예외가 발생한다.")
    @Test
    public void validateBuyTest() {
        LottoStore lottoStore = new LottoStore();
        int price = 500;

        assertThatThrownBy(() -> {
            lottoStore.buy(PriceLotto.of(price), ManualLottoMemo.empty());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
