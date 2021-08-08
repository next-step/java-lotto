package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersGeneratorTest {

    @DisplayName("로또 숫자를 자동으로 생성 할 수 있다.")
    @Test
    public void lottoTicketGenerateTest() {
        List<LottoNumber> sourceLottoNumbers = convertToLottoNumbers(1,2,3,4,5,6);
        LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.of(sourceLottoNumbers);
        LottoNumbers generatedLottoNumbers = lottoNumbersGenerator.generate();
        LottoNumbers expectedLottoNumbers = LottoNumbers.of(sourceLottoNumbers);
        assertThat(generatedLottoNumbers.hit(expectedLottoNumbers))
                .isEqualTo(6);
    }

    private List<LottoNumber> convertToLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

}