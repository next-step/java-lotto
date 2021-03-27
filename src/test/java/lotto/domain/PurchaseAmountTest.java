package lotto.domain;

import lotto.domain.PurchaseAmount;
import lotto.utils.LottoRandomNumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchaseAmountTest {

    @Test
    @DisplayName("구매 금액 객체 생성")
    public void create() throws Exception {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);
        assertThat(purchaseAmount).isEqualTo(new PurchaseAmount(1000));
        purchaseAmount = new PurchaseAmount("1000");
        assertThat(purchaseAmount).isEqualTo(new PurchaseAmount("1000"));
    }

    @Test
    @DisplayName("구매한 티켓 장수 구하기")
    public void numberOfTicket() throws Exception {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);
        LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(LottoRandomNumberUtil.lottoNumbers()));
        NumberOfTicket numberOfTicket = purchaseAmount.numberOfTicket(lottoTicket.price());
        assertThat(numberOfTicket.count()).isEqualTo(1);
    }

    @Test
    @DisplayName("1000원 미만일 시 예외")
    public void checkMinimum() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchaseAmount(999));
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchaseAmount("999"));
    }

    @Test
    @DisplayName("숫자가 아닐 경우 예외")
    public void checkInteger() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchaseAmount("1000s"));
    }
}
