package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseRequestTest {

    private static final Money LOTTO_PRICE = Money.of(1000);

    private LottoNumbers manualNumber1;
    private LottoNumbers manualNumber2;

    @BeforeEach
    public void setUp(){
        manualNumber1 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        manualNumber2 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
    }

    @Test
    public void 생성() {
        Money money = Money.of(14000);
        LottoPurchaseRequest request = new LottoPurchaseRequest(money, manualNumber1, manualNumber2);
        assertThat(request).isEqualTo(new LottoPurchaseRequest(Money.of(14000), manualNumber1, manualNumber2));
    }

    @Test
    public void 유효성확인() {
        Money money = Money.of(1000);
        LottoPurchaseRequest request = new LottoPurchaseRequest(money, manualNumber1, manualNumber2);
        assertThat(request.valid(LOTTO_PRICE)).isFalse();
    }

    @Test
    public void 유효성확인2() {
        Money money = Money.of(2000);
        LottoPurchaseRequest request = new LottoPurchaseRequest(money, manualNumber1, manualNumber2);
        assertThat(request.valid(LOTTO_PRICE)).isTrue();
    }

    @Test
    public void 자동_구매_갯수확인() {
        Money money = Money.of(2000);
        LottoPurchaseRequest request = new LottoPurchaseRequest(money, manualNumber1, manualNumber2);
        assertThat(request.getAutoCount(LOTTO_PRICE)).isEqualTo(0);
    }

    @Test
    public void 자동_구매_갯수확인1() {
        Money money = Money.of(3000);
        LottoPurchaseRequest request = new LottoPurchaseRequest(money, manualNumber1, manualNumber2);
        assertThat(request.getAutoCount(LOTTO_PRICE)).isEqualTo(1);
    }

    @Test
    public void 자동_구매_갯수확인2() {
        Money money = Money.of(4000);
        LottoPurchaseRequest request = new LottoPurchaseRequest(money);
        assertThat(request.getAutoCount(LOTTO_PRICE)).isEqualTo(4);
    }

}
