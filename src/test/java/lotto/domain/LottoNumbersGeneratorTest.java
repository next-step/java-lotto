package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * LottoNumbersGenerator 객체 생성 및 로또번호 생성기능 테스트
 */
public class LottoNumbersGeneratorTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3,4,5,6", "a,b,c,d,e,f"})
    @DisplayName("문자열을 로또번호로 변활할 떄 유효성 검사")
    void validate_toLottoNumbers(String textNumber) {
        // given
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();

        // then
        assertThatThrownBy(() -> lottoNumbersGenerator.toLottoNumbers(textNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자로 된 숫자 목록을 로또번호 목록으로 변환기능")
    void toLottoNumbers() {
        // given
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        LottoNumbers lottoNumbers = lottoNumbersGenerator.toLottoNumbers("1, 2, 3 ,4,5,6");

        // then
        assertThat(lottoNumbers.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("로또번호 객체 생성")
    void generator_lottoNumbers() {
        // given
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        LottoNumbers lottoNumbers = lottoNumbersGenerator.generateRandomLottoNumbers();

        // then
        assertThat(lottoNumbers.isEmpty()).isFalse();
    }
}
