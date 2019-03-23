package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMoneyTest {
    //TODO : 받은돈 -> 로또발급 장수
    //TODO : 리팩토링 할때는 메서드 에러 안나게 하면서 진행. 중간단계 필요

    @Test
    public void 천원으로_살수있는_로또개수_확인() {
        LottoMoney lottoMoney = new LottoMoney(1_000);
        assertThat(lottoMoney.buy()).isEqualTo(1);
    }

    @Test
    public void 천오백원으로_살수있는_로또개수_확인() {
        LottoMoney lottoMoney = new LottoMoney(1_500);
        assertThat(lottoMoney.buy()).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 오백원으로_로또사면_날강도() {
        //500원으로 500장을 사겠다는 원대한꿈
        LottoMoney lottoMoney = new LottoMoney(500);
        assertThat(lottoMoney.buy()).isEqualTo(500);
    }
}
