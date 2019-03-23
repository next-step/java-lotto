package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMoneyTest {
    //TODO : 받은돈 -> 로또발급 장수

    @Test
    public void 천원으로_살수있는_로또개수_확인() {
        assertThat(LottoMoney.buy(1_000)).isEqualTo(1);
    }

    @Test
    public void 천오백원으로_살수있는_로또개수_확인() {
        assertThat(LottoMoney.buy(1_500)).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 오백원으로_로또사면_날강도() {
        //500원으로 500장을 사겠다는 원대한꿈
        assertThat(LottoMoney.buy(500)).isEqualTo(500);
    }
}
