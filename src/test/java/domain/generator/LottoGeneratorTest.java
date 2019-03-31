package domain.generator;

import domain.LottoNo;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    public void 로또_자동생성() {
        new AutoLotto();
    }

    @Test
    public void 로또_수동생성() {
        ManualLotto manualLotto = new ManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(manualLotto.generate().isContains(LottoNo.of(1))).isTrue();
    }
}