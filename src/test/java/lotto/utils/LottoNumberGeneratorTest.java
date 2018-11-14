package lotto.utils;

import lotto.utils.LottoNumberGenerator;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    public void 로또숫자를_생성할수있다() {
        List<String> lottoNumbers = LottoNumberGenerator.generate();
        assertThat(lottoNumbers).hasSize(6);
    }
}