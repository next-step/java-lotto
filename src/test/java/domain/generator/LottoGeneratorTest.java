package domain.generator;

import domain.LottoNo;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    public void 로또_자동생성() {
        new AutoLotto();
    }

    @Test
    public void 로또_수동생성() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5),new LottoNo(6));
        ManualLotto manualLotto = new ManualLotto(lottoNos);
        assertThat(manualLotto.generate().isContains(new LottoNo(1))).isTrue();
    }
}