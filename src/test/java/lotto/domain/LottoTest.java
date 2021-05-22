package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

class LottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,3,5,6", "10,11,12,14,14,16"})
    void isDuplicated_lotto_number(String numbers) {
        List<LottoNumber> lottoNumbers = toLottoNumbers(numbers);
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 중복되는 번호를 가질 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,6,7,8,9,10"})
    @DisplayName("로또번호가 6개가 아닐 경우 로또 생성시 유효성 검증")
    void validate_lotto_numbers_size(String textNumber) {
        List<LottoNumber> lottoNumbers = toLottoNumbers(textNumber);
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또번호 개수가 부족하거나 초과하였습니다.");
    }

    @Test
    @DisplayName("6개의 로또번호를 가진 로또 생성")
    void create_lotto() {
        List<LottoNumber> lottoNumbers = toLottoNumbers("1,2,3,4,5,6");
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    private List<LottoNumber> toLottoNumbers(String textNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : textNumber.split(",")) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
        return lottoNumbers;
    }
}
