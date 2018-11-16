package lotto.utils;

import lotto.domain.LottoNo;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoGeneratorTest {

    @Test
    public void 로또숫자를_생성할수있다() {
        List<LottoNo> lottoNumbers = LottoNoGenerator.generate();
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    public void 숫자배열로_로또숫자목록을_생성할수있다() {
        List<LottoNo> lottoNumbers = LottoNoGenerator.generate(1, 2, 3, 4, 5, 6);
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    public void 숫자리스트로_로또숫자목록을_생성할수있다() {
        List<LottoNo> lottoNumbers = LottoNoGenerator.generate(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers).hasSize(6);
    }
}