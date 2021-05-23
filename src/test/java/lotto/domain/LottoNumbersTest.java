package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumbersTest {

    LottoNumbersGenerator lottoNumbersGenerator;

    @BeforeEach
    public void beforeEach() {
        this.lottoNumbersGenerator = new LottoNumbersGenerator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,3,5,6", "10,11,12,14,14,16"})
    @DisplayName("중복번호 유효성 검증")
    void isDuplicated_lotto_number(String textNumbers) {
        assertThatThrownBy(() -> this.lottoNumbersGenerator.toLottoNumbers(textNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 중복되는 번호를 가질 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,6,7,8,9,10"})
    @DisplayName("로또번호가 6개가 아닐 경우 유효성 검증")
    void validate_lotto_numbers_size(String textNumber) {
        assertThatThrownBy(() -> this.lottoNumbersGenerator.toLottoNumbers(textNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또번호 개수가 부족하거나 초과하였습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1:true", "10,11,12,13,14,15:10:true", "30,31,32,41,42,45:1:false"}, delimiter = ':')
    @DisplayName("요소 포함여부 확인")
    void contain_lottoNumber(String textNumber, int number, boolean result) {
        // given
        LottoNumbers lottoNumbers = this.lottoNumbersGenerator.toLottoNumbers(textNumber);

        // when
        boolean resultContains = lottoNumbers.contains(new LottoNumber(number));

        // then
        assertThat(resultContains).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,11,12,13,14,15", "30,31,32,41,42,45"})
    @DisplayName("LottoNumbers 생성")
    void get_list_size(String textNumber) {
        // given
        LottoNumbers lottoNumbers = this.lottoNumbersGenerator.toLottoNumbers(textNumber);

        // then
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,11,12,13,14,15", "30,31,32,41,42,45"})
    @DisplayName("LottoNumbers 생성")
    void create_lottoNumbers(String textNumber) {
        // given
        LottoNumbers lottoNumbers = this.lottoNumbersGenerator.toLottoNumbers(textNumber);

        // then
        assertThat(lottoNumbers.isEmpty()).isFalse();
    }
}
