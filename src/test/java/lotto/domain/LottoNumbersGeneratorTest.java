package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersGeneratorTest {

    @DisplayName("주어진 범위 내에서 로또 번호를 자동으로 생성 할 수 있다.")
    @Test
    public void lottoNumbersGenerateWithNumberRange() {
        LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.rangeClosed(1,6);
        LottoNumbers generated = lottoNumbersGenerator.generate();
        LottoNumbers expected = LottoNumbers.of(createMockLottoNumbers(1,2,3,4,5,6));
        assertThat(generated.countOfMatch(expected)).isEqualTo(6);
    }

    private List<LottoNumber> createMockLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    @DisplayName("입력 받은 수 만큼 로또 숫자를 발행한다.")
    @Test
    public void generateSeveralLottoNumbersTest() {
        LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.rangeClosed(LottoNumber.getLowerBound(), LottoNumber.getUpperBound());
        List<LottoNumbers> lottoNumbers = lottoNumbersGenerator.generate(10);
        assertThat(lottoNumbers)
                .isNotNull()
                .hasSize(10);
    }

}