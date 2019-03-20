import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LottoMachineTest {
    private static final int LOTTO_PRICE = 1000;

    @Test
    public void 가격만큼_기회생성() {
        int price = 14000;
        LottoMachine lottoMachine = new LottoMachine(price);
        assertThat(lottoMachine.getTryNo()).isEqualTo(price / LOTTO_PRICE);
    }

    @Test
    public void 가격만큼_번호생성() {
        int price = 14000;
        LottoMachine lottoMachine = new LottoMachine(price);
        assertFalse(lottoMachine.isEnd());
        for (int i = 0; i < price / LOTTO_PRICE; i++) {
            lottoMachine.machineStart();
        }
        assertTrue(lottoMachine.isEnd());
    }

    @Test
    public void 번호생성시_기회감소() {
        int price = 14000;
        LottoMachine lottoMachine = new LottoMachine(price);
        int tryNo = lottoMachine.getTryNo();
        assertThat(lottoMachine.getTryNo()).isEqualTo(tryNo);
        lottoMachine.machineStart();
        assertThat(--tryNo);
    }
}