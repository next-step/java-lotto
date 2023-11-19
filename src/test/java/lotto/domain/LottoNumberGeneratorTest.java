package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("6개 숫자의 로또 번호가 생성된다.")
    void generated_lotto_numbers_size() {
        LottoNumberGenerator lottoNumberGenerator = new AutoLottoNumberGenerator();

        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    @DisplayName("로또가 다른 숫자로 생성된 게 맞는지 확인한다.")
    void generated_lotto_numbers_randomly() {
        LottoNumberGenerator lottoNumberGenerator = new AutoLottoNumberGenerator();

        List<Integer> numbers1 = lottoNumberGenerator.generate();
        List<Integer> numbers2 = lottoNumberGenerator.generate();

        assertThat(numbers1).isNotEqualTo(numbers2);
    }
}
