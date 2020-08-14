package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("번호 숫자가 1에서 45 사이")
    void generate_checkNumberRange() {
        Set<LottoNumber> lottoNumbers = LottoNumberGenerator.shuffleAndGet();
        for (LottoNumber lottoNumber : lottoNumbers) {
            assertThat(lottoNumber.getNumber()).isGreaterThanOrEqualTo(1);
            assertThat(lottoNumber.getNumber()).isLessThanOrEqualTo(45);
        }
    }

    @Test
    @DisplayName("숫자 개수가 6개의 중복없는 로또 번호를 생성")
    void generate_checkNumberCount() {
        Set<LottoNumber> lottoNumbers = LottoNumberGenerator.shuffleAndGet();
        Set<Integer> numberSet = new HashSet<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            numberSet.add(lottoNumber.getNumber());
        }

        assertThat(lottoNumbers.size()).isEqualTo(numberSet.size()).isEqualTo(6);
    }
}
