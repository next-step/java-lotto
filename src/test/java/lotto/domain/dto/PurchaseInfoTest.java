package lotto.domain.dto;

import lotto.domain.price.Price;
import lotto.util.LottoTicketsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchaseInfoTest {

    @DisplayName("Price 가 null 이면 예외 발생")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseInfo.valueOf(null, LottoTicketsGenerator.newInstance()));
    }

    @DisplayName("Price 와 수동 로또 번호를 인자로 입력받아 객체를 생성")
    @Test
    void create() {
        assertThatCode(() -> PurchaseInfo.valueOf(Price.of(Price.ONE_TICKET_PRICE), LottoTicketsGenerator.newInstance()))
                .doesNotThrowAnyException();
    }
}
