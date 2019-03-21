package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 지난주당첨번호개수안맞음() {
        Lotto lotto = new Lotto(Arrays.asList(LottoMachine.getLottoNoInstance(1), LottoMachine.getLottoNoInstance(2), LottoMachine.getLottoNoInstance(3),
                LottoMachine.getLottoNoInstance(4), LottoMachine.getLottoNoInstance(5)));
    }

    @Test
    public void 당첨숫자_카운트증가() {
        Lotto lotto = new Lotto(Arrays.asList(LottoMachine.getLottoNoInstance(1), LottoMachine.getLottoNoInstance(2), LottoMachine.getLottoNoInstance(3),
                LottoMachine.getLottoNoInstance(4), LottoMachine.getLottoNoInstance(5), LottoMachine.getLottoNoInstance(6)));
        lotto.incrementMatchCount(LottoMachine.getLottoNoInstance(3));
        assertThat(lotto.getMatchCount()).isEqualTo(1);
    }
}