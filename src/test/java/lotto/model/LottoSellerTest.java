package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoSellerTest {

    @Test
    @DisplayName("n개의 티켓 가격 계산")
    public void 티켓_가격_계산() {
        Assertions.assertThat(LottoSeller.price(4))
                .isEqualTo(4000);
    }

    @Test
    @DisplayName("입력된 돈에 따른 로또 티켓 갯수 계산")
    public void 티켓_갯수_계산() {
        Assertions.assertThat(LottoSeller.calculateTicketCount(4000))
                .isEqualTo(4);
    }

    @Test
    @DisplayName("전체 티켓 갯수보다 수동 티켓 갯수가 많을 경우 에러 발생")
    public void validate_수동_티켓_갯수() {
        List<LottoNumbers> manualTicketsNumbers = Arrays.asList(
                LottoNumbers.of(Arrays.asList(1,2,3,4,5,6)),
                LottoNumbers.of(Arrays.asList(7,8,9,10,11,12)),
                LottoNumbers.of(Arrays.asList(13,14,15,16,17,18))
        );
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoSeller.issueLotto(2000, manualTicketsNumbers);
        }).withMessageMatching("Manual tickets cannot exceed 2, which is the total number of tickets.");

    }
}
