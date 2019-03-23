import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {
    private static final int LOTTO_PRICE = 1000;

    @Test
    public void 가격만큼_기회생성() {
        int price = 14000;
        assertThat(new LottoMachine(new LottoMoney(price)).getTryNo()).isEqualTo(price / LOTTO_PRICE);
    }

    @Test
    public void 가격만큼_로또생성() {
        int price = 14000;
        assertThat(new LottoMachine(new LottoMoney(price)).generateLotto()).hasSize(price / LOTTO_PRICE);

    }

    @Test
    public void 번호_생성완료시_기회없음() {
        int price = 14000;
        LottoMachine lottoMachine = new LottoMachine(new LottoMoney(price));
        lottoMachine.generateLotto();

        assertThat(lottoMachine.getTryNo()).isEqualTo(0);
    }
}