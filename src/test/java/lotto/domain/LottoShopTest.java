package lotto.domain;

import lotto.domain.exception.InvalidLottoMoneyException;
import lotto.domain.exception.InvalidLottoShopManualCountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoShopTest {
    @ParameterizedTest(name = "{0}원으로 {1}장의 로또를 구매할 수 있다")
    @CsvSource(value = {"14000:14", "1000:1", "2500:2", "12345:12"}, delimiter = ':')
    void 로또를_장당_천원에_구매할_수_있다(int money, int count) {
        assertThat(LottoShop.sell(money).getCombinedLottos().getLottoQuantity()).isEqualTo(count);
    }

    @Test
    void 로또를_구매할_떄_0_미만의_돈을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoShop.sell(-2000))
                .isInstanceOf(InvalidLottoMoneyException.class);
    }

    @Test
    void 로또_구매_시_수동_로또_갯수가_금액보다_크면_예외가_발생한다() {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");
        Lottos lottos = new Lottos(List.of(lotto, lotto));
        assertThatThrownBy(() -> LottoShop.sell(1000, lottos))
                .isInstanceOf(InvalidLottoShopManualCountException.class);
    }

    @Test
    void 로또를_수동으로_구매할_수_있다() {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");
        Lottos lottos = new Lottos(List.of(lotto));
        assertThat(LottoShop.sell(1000, lottos).getCombinedLottos().getLottoList().contains(lotto)).isTrue();
    }

    @Test
    void 로또_여러_장을_구매할_경우_금액만큼_자동과_수동을_나누어_구매할_수_있다() {
        Lotto lotto1 = Lotto.from("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = Lotto.from("1, 2, 3, 4, 5, 7");
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        Lottos result = LottoShop.sell(4000, lottos).getCombinedLottos();
        assertThat(result.getLottoQuantity()).isEqualTo(4);
        assertThat(result.getLottoList().containsAll(lottos.getLottoList())).isTrue();
    }
}
