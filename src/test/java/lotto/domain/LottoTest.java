package lotto.domain;

import lotto.vo.LottoNo;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void 로또번호생성() {
        List<LottoNo> numbers = Lotto.createNumbers();
        assertThat(numbers).hasSize(6);
    }

    @Test
    public void 로또번호검증() {
        List<LottoNo> numbers = Lotto.createNumbers();
        Collections.sort(numbers);
        assertThat(numbers.get(0).getNumber()).isGreaterThan(0);
        assertThat(numbers.get(5).getNumber()).isLessThanOrEqualTo(45);
    }
}