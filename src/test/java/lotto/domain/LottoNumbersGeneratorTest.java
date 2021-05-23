package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

public class LottoNumbersGeneratorTest {

    @RepeatedTest(10)
    @DisplayName("생성된 로또번호 중복 확인")
    void check_duplicate() {
        // given
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        List<LottoNumber> randomLottoNumbers = lottoNumbersGenerator.generateRandomLottoNumbers();

        // when
        Set<LottoNumber> result = new HashSet<>(randomLottoNumbers);

        // then
        assertThat(result.size()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"6,5,4,3,2,1", "5,3,4,1,7,9", "10,23,45,11,34,15"})
    @DisplayName("생성된 로또번호 랜덤 유무 확인")
    void check_random_lottoNumber(String textNumber) {
        // given
        List<LottoNumber> lottoNumbers = toLottoNumbers(textNumber);

        // when
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(lottoNumbers);
        List<LottoNumber> randomLottoNumbers = lottoNumbersGenerator.generateRandomLottoNumbers();

        // then
        boolean result = Arrays.equals(lottoNumbers.toArray(), randomLottoNumbers.toArray());
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("생성된 로또숫자 개수 확인 테스트")
    void check_lottoNumbers_size() {
        // given
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        List<LottoNumber> lottoNumbers = lottoNumbersGenerator.generateRandomLottoNumbers();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    private List<LottoNumber> toLottoNumbers(String textNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : textNumber.split(",")) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
        return lottoNumbers;
    }
}
