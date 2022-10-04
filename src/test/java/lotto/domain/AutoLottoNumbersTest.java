package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AutoLottoNumbersTest {

    @DisplayName("지동으로 생성한 로또 번호는 6자리이며 1보다 크거나 같고 45보다 작거나 같다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 1, 3, 4, 5})
    void create_auto_lotto(final int index) {

        final List<LottoNumber> autoLottoNumbers = AutoLottoNumbers.autoCreate(1);

        final List<Number> lottoNumber = autoLottoNumbers.get(0).getLottoNumber();
        assertAll(
                () -> assertThat(lottoNumber.get(index).getNumber()).isGreaterThanOrEqualTo(1),
                () -> assertThat(lottoNumber.get(index).getNumber()).isLessThanOrEqualTo(45)
        );
    }

    @DisplayName("구매 가능한 금액만큼 생성하며 자동 로또 번호 6자리를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void create_auto_lotto2(final int count) {

        final List<LottoNumber> autoLottoNumbers = AutoLottoNumbers.autoCreate(count);

        final List<Number> lottoNumber = autoLottoNumbers.get(0).getLottoNumber();
        assertAll(
                () -> assertThat(autoLottoNumbers).hasSize(count),
                () -> assertThat(lottoNumber).hasSize(6)
        );
    }
}
