package lotto.domain;

import java.util.Arrays;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {

    @Test
    public void 로또_10개_발급() {
        LottoList lottoList = new LottoList(10);

        assertThat(lottoList.size()).isEqualTo(10);
    }

    @Test(expected = RuntimeException.class)
    public void 로또_0개_발급() {
        new LottoList(0);
    }

    @Test
    public void 로또_2개_합치기() {
        LottoList lottoList1 = new LottoList(1);
        LottoList lottoList2 = new LottoList(1);

        LottoList mergeList = LottoList.merge(lottoList1, lottoList2);

        assertThat(mergeList.size()).isEqualTo(2);
    }

    @Test
    public void 로또_수동_자동_같이_발급() {
        final LottoList manualLottos = new LottoList(Arrays.asList(
            new Lotto(Arrays.asList( // 4개 일치
                LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3),
                LottoNumber.valueOf(4), LottoNumber.valueOf(44), LottoNumber.valueOf(45)))));

        LottoList lottos = new LottoList(10, manualLottos);

        assertThat(lottos.size()).isEqualTo(10);
    }
}