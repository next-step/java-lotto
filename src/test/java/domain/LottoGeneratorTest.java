package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoGeneratorTest {
    @Test
    public void 로또_번호는_6개이다() {
        // when
        LottoSet lottoSet = LottoGenerator.getLottoSet();

        // then
        assertThat(lottoSet.getLottoNumbers().size(), is(LottoGenerator.LOTTO_SIZE));
    }
}