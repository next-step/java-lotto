package lotto.utils;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    public void 로또숫자를_생성할수있다() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();
        assertThat(lottoNumbers).hasSize(6);
    }
}