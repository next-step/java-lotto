package lotto.domain;

import lotto.domain.exception.InvalidLottoMoneyException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoShopTest {
    @ParameterizedTest(name = "{0}원으로 {1}장의 로또를 구매할 수 있다")
    @CsvSource(value = {"14000:14", "1000:1", "2500:2", "12345:12"}, delimiter = ':')
    void 로또를_장당_천원에_구매할_수_있다(int money, int count) {
        assertThat(LottoShop.sellLotto(money).getLottoQuantity()).isEqualTo(count);
    }

    @Test
    void 로또를_구매할_떄_0_미만의_돈을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoShop.sellLotto(-2000))
                .isInstanceOf(InvalidLottoMoneyException.class);
    }
}
