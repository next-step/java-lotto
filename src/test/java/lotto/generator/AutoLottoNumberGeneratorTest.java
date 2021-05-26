package lotto.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.LottoNumber;
import lotto.LottoNumbers;

public class AutoLottoNumberGeneratorTest {

    @Test
    @DisplayName(value = "로또 번호 생성기가 만들어주는 번호의 개수는 6개이다")
    void generateLottoNum() {
        Generator autoLottoNumberGenerator = new AutoLottoNumberGenerator();
        LottoNumbers lottoNumbers = autoLottoNumberGenerator.generate();
        assertThat(lottoNumbers.isComplete()).isTrue();
    }

    @Test
    @DisplayName(value = "생성된 숫자와 동일한 LottoNumber 가 만들어진다")
    void sameValueLotto() {
        List<Integer> sample = Arrays.asList(1, 2, 3, 4, 5, 6);
        Generator lottoNumberGenerator = new AutoLottoNumberGenerator(sample);
        LottoNumbers result = lottoNumberGenerator.generate();
        assertThat(result.hasWinLottoNumber(new LottoNumber(1))).isTrue();
        assertThat(result.hasWinLottoNumber(new LottoNumber(2))).isTrue();
        assertThat(result.hasWinLottoNumber(new LottoNumber(3))).isTrue();
        assertThat(result.hasWinLottoNumber(new LottoNumber(4))).isTrue();
        assertThat(result.hasWinLottoNumber(new LottoNumber(5))).isTrue();
        assertThat(result.hasWinLottoNumber(new LottoNumber(6))).isTrue();
    }

}
