package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersGeneratorTest {

    @DisplayName("로또 숫자를 자동으로 생성 할 수 있다.")
    @Test
    public void lottoNumbersGenerateTest() {
        List<LottoNumber> sourceLottoNumbers = createMockLottoNumbers(1,2,3,4,5,6);
        LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.of(sourceLottoNumbers);
        LottoNumbers generatedLottoNumbers = lottoNumbersGenerator.generate();
        LottoNumbers expectedLottoNumbers = LottoNumbers.of(sourceLottoNumbers);
        assertThat(generatedLottoNumbers.hit(expectedLottoNumbers))
                .isEqualTo(6);
    }

    private List<LottoNumber> createMockLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    @DisplayName("입력 받은 수 만큼 로또 숫자를 발행한다.")
    @Test
    public void generateSeveralLottoNumbersTest() {
        LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.of(createLottoNumbers());
        List<LottoNumbers> lottoNumbers = lottoNumbersGenerator.generate(10);
        assertThat(lottoNumbers)
                .isNotNull()
                .hasSize(10);
    }

    private static List<LottoNumber> createLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.getLowerBound(), LottoNumber.getUpperBound())
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

}