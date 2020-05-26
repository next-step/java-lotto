package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    private LottoNumber winLottoNumber = LottoNumberFactory.createManualLottoNumbers("1, 2, 3, 4, 5, 6");

    @DisplayName("당첨 번호가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateBonusNumberIfLottoNumberIsNull() {
        assertThatThrownBy(() -> BonusNumber.newInstance(0, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 보다 작거나, 45 보다 크면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 46, 47 })
    void canNotCreateBonusNumberIfNumberLessThen1OrGreaterThan45(int bonusNumber) {
        assertThatThrownBy(() -> BonusNumber.newInstance(bonusNumber, this.winLottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6 })
    void canNotCreateBonusNumberIfWinLottoNumberIncludeNumber(int bonusNumber) {
        assertThatThrownBy(() -> BonusNumber.newInstance(bonusNumber, this.winLottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 생성할 수 있다.")
    @Test
    void canCreateBonusNumber() {
        assertThat(BonusNumber.newInstance(7, this.winLottoNumber)).isInstanceOf(BonusNumber.class);
    }

    @DisplayName("보너스 번호를 얻을 수 있다.")
    @Test
    void canGetBonusNumber() {
        int number = 7;
        BonusNumber bonusNumber = BonusNumber.newInstance(number, this.winLottoNumber);

        assertThat(bonusNumber.getBonusNumber()).isEqualTo(number);
    }

    @DisplayName("내부 보너스 번호가 같으면 동일한 객체이다.")
    @Test
    void canSameBonusNumberIfBonusNumberSame() {
        int number = 7;
        BonusNumber bonusNumber1 = BonusNumber.newInstance(number, this.winLottoNumber);
        BonusNumber bonusNumber2 = BonusNumber.newInstance(number, this.winLottoNumber);

        assertThat(bonusNumber1.getBonusNumber()).isEqualTo(bonusNumber2.getBonusNumber());
        assertThat(bonusNumber1).isEqualTo(bonusNumber2);
        assertThat(bonusNumber1.hashCode()).isEqualTo(bonusNumber2.hashCode());
    }
}
