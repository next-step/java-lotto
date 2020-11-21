package lotto;

import lotto.model.Amount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AmountTest {

    @Test
    public void null_또는_빈문자() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Amount(""))
                .withMessageMatching("입력 값이 잘못됐습니다.");
    }

    @Test
    public void Amount_음수_값() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Amount("-1"));
    }

    @Test
    public void Amount_정상적인_값_입력() {
        Amount amount = new Amount("1000");
        assertThat(amount.pay(0)).isEqualTo(1000);
    }

    @Test
    public void pay_음수_값_지불() {
        Amount amount = new Amount("1000");
        assertThatIllegalArgumentException().isThrownBy(() -> amount.pay(-10));
    }

    @Test
    public void pay_잔액부족() {
        Amount amount = new Amount("1000");
        assertThatIllegalArgumentException().isThrownBy(() -> amount.pay(10000));
    }

    @Test
    public void pay_정상적인_값_입력() {
        Amount amount = new Amount("1000");
        assertThat(amount.pay(100)).isEqualTo(900);
    }


}
