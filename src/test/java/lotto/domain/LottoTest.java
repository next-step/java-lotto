package lotto.domain;

import lotto.vo.LottoNo;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 지난주당첨번호개수안맞음() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5)));
    }

    @Test
    public void 당첨숫자_카운트증가() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        lotto.incrementMatchCount(new LottoNo(3));
        assertThat(lotto.getMatchCount()).isEqualTo(1);
    }
}