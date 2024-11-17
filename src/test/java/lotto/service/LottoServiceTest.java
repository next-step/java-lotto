package lotto.service;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    void 수동금액이_구매금액보다_많으면_예외가_발생한다() {
        LottoService lottoService = new LottoService();
        assertThatIllegalArgumentException().isThrownBy(
                () -> lottoService.buyLottos(List.of("1,2,3,4,5,6"), new Money(0)));
    }
}
