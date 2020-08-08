package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("번호 숫자가 6에서 49 사이")
    void generate_checkNumberRange() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.shuffleAndGet();
        for (LottoNumber lottoNumber : lottoNumbers) {
            assertThat(lottoNumber.getNumber()).isGreaterThanOrEqualTo(6);
            assertThat(lottoNumber.getNumber()).isLessThanOrEqualTo(49);
        }
    }

    @Test
    @DisplayName("숫자 개수가 6개의 중복없는 로또 번호를 생성")
    void generate_checkNumberCount() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.shuffleAndGet();
        Set<Integer> numberSet = new HashSet<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            numberSet.add(lottoNumber.getNumber());
        }

        assertThat(lottoNumbers.size()).isEqualTo(numberSet.size()).isEqualTo(6);
    }
}
