package lotto.domain.dto;

import lotto.util.LottoTicketsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchaseInfoTest {

    @DisplayName("Price 가 null 이면 예외 발생")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseInfo.valueOf(null, LottoTicketsGenerator.newInstance()));
    }
}
