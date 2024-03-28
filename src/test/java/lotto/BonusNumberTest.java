package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    private List<LottoNumber> createLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return lottoNumbers;
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 22})
    public void 보너스_번호_생성(int input) {
        BonusNumber number = new BonusNumber(input);
        assertThat(number.getNumber()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void 보너스_번호는_1이상_45이하의_숫자만_입력_가능(int input) {
        assertThatThrownBy(() -> new BonusNumber(input)).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("1이상 45이하의 숫자만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @CsvSource({"3,true", "10,false"})
    public void 보너스_번호_포함_여부(int input, boolean expect) {
        BonusNumber bonusNumber = new BonusNumber(input);
        List<LottoNumber> numbers = createLottoNumbers();
        assertThat(bonusNumber.match(numbers)).isEqualTo(expect);
    }
}
