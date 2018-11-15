package lotto.domain;

import lotto.utils.LottoHelper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WInningLottoTest {

    @Test
    public void 일등로또_생성() {
        WInningLotto lotto = new WInningLotto(Lotto.ofManual(LottoHelper.convertToBalls("1,2,3,4,5,6")), LottoHelper.convertToBall(10));
        assertThat(lotto).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스번호_당첨번호_포함시_에러_검증() {
        WInningLotto lotto = new WInningLotto(Lotto.ofManual(LottoHelper.convertToBalls("1,2,3,4,5,6")), LottoHelper.convertToBall(5));
    }

    @Test
    public void 보너스번호_매칭_확인() {
        WInningLotto ticket1 = new WInningLotto(Lotto.ofManual(LottoHelper.convertToBalls("1,2,3,4,5,6")), LottoHelper.convertToBall(7));
        Lotto ticket2 = Lotto.ofManual(LottoHelper.convertToBalls("1,2,3,4,5,7"));
        assertThat(ticket1.hasBonusBall(ticket2)).isTrue();
    }

    @Test
    public void 보너스번호_낫매칭_확인() {
        WInningLotto ticket1 = new WInningLotto(Lotto.ofManual(LottoHelper.convertToBalls("1,2,3,4,5,6")), LottoHelper.convertToBall(7));
        Lotto ticket2 = Lotto.ofManual(LottoHelper.convertToBalls("1,2,3,4,5,10"));
        assertThat(ticket1.hasBonusBall(ticket2)).isFalse();
    }
}
