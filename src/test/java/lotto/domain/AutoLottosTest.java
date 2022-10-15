package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AutoLottosTest {

    @DisplayName("지동으로 생성한 로또 번호는 6자리이며 1보다 크거나 같고 45보다 작거나 같다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 1, 3, 4, 5})
    void create_auto_lotto(final int index) {

        final List<Lotto> autoLottoNumbers = AutoLottos.autoCreate(1, 0);

        final List<Number> lottoNumber = autoLottoNumbers.get(0).getLotto();
        assertAll(
                () -> assertThat(lottoNumber.get(index).getNumber()).isGreaterThanOrEqualTo(1),
                () -> assertThat(lottoNumber.get(index).getNumber()).isLessThanOrEqualTo(45)
        );
    }

    @DisplayName("구매 가능한 금액에서 수동 로또 번호를 제외한 자동 로또 번호 6자리를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,0,1", "5,3,2", "10,5,5"})
    void create_auto_lotto2(final int countOfPurchaseLotto, final int countOfManualLotto, final int countOfAutoLotto) {

        final List<Lotto> autoLottoNumbers = AutoLottos.autoCreate(countOfPurchaseLotto, countOfManualLotto);

        final List<Number> lottoNumber = autoLottoNumbers.get(0).getLotto();
        assertAll(
                () -> assertThat(autoLottoNumbers).hasSize(countOfAutoLotto),
                () -> assertThat(lottoNumber).hasSize(6)
        );
    }
}
