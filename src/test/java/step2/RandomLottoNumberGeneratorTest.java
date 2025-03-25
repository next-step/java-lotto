package step2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static step2.Lotto.*;
import static step2.LottoNumber.*;

public class RandomLottoNumberGeneratorTest {

    @Test
    void 서로_같지_않은_로또_숫자_6개_생성() {
        RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();
        List<LottoNumber> lottoNumbers = randomLottoNumberGenerator.generate();

        assertThat(lottoNumbers).hasSize(LOTTO_NUMBER_COUNT);
        assertThat(new HashSet<>(lottoNumbers)).hasSize(LOTTO_NUMBER_COUNT);

        assertThat(lottoNumbers).allMatch(lottoNumber ->
                        lottoNumber.getLottoNumber() >= MIN_LOTTO_NUMBER &&
                        lottoNumber.getLottoNumber() <= MAX_LOTTO_NUMBER
        );
    }
}
