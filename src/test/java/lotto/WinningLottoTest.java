package lotto;

import common.converter.StringToLottoNumberConverter;
import common.converter.StringToLottoNumberSetConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @DisplayName("당첨 로또는 6개의 당첨 번호와 1개의 보너스 번호가 있다")
    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5 6, 7"
    })
    void lottoNumbers(
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> numbers,
            @ConvertWith(StringToLottoNumberConverter.class) final LottoNumber bonus
    ) {
        WinningLotto lotto = new WinningLotto(numbers, bonus);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
        assertThat(lotto.getBonus()).isEqualTo(bonus);
    }

    @DisplayName("당첨 로또는 6개의 당첨 번호와 1개의 보너스 번호는 중복되면 예외가 발생한다")
    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5 6, 6"
    })
    void notDuplicateNumbers(
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> numbers,
            @ConvertWith(StringToLottoNumberConverter.class) final LottoNumber bonus
    ) {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(numbers, bonus));
    }
}