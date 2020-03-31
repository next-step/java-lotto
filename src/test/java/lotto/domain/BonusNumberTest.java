package lotto.domain;

import lotto.common.LottoStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    LottoNumbers defaultLottoNumbers;

    @BeforeEach
    void setUp() {
        defaultLottoNumbers = LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호를 생성할 수 있다")
    @Test
    public void createBonusNumberTest() {
        BonusNumber one = new BonusNumber(defaultLottoNumbers, 7);
        BonusNumber another = new BonusNumber(defaultLottoNumbers, 7);

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("보너스 번호만 같아도 같은 객체로 판단한다")
    @Test
    public void bonusNumberEqualsTest() {
        LottoNumbers fistLottoNumbers = LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumbers secondLottoNumbers = LottoStub.getLottoNumbers(8, 9, 10, 11, 12, 13);

        BonusNumber one = new BonusNumber(fistLottoNumbers, 7);
        BonusNumber another = new BonusNumber(secondLottoNumbers, 7);

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("보너스 번호는 1 ~ 45 사이의 수를 가질 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void bonusNumberRangeTest(int bonusNumber) {
        assertThatThrownBy(() -> new BonusNumber(defaultLottoNumbers, bonusNumber))
                .isInstanceOf(LottoNumberRangeException.class)
                .hasMessageContaining("로또 번호는 1~45 사이의 수만 가능합니다.");
    }

    @DisplayName("보너스 번호는 기존 당첨번호와 중복될 수 없다")
    @Test
    public void doesntDuplicateBonusNumber() {
        assertThatThrownBy(() -> new BonusNumber(defaultLottoNumbers, 6))
                .isInstanceOf(BonusNumberDuplicateException.class)
                .hasMessageContaining("보너스 번호는 당첨번호와 중복될 수 없습니다.");
    }

    @DisplayName("입력받은 숫자와 보너스 넘버가 일치하는지 확인할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {7, 45})
    void isMatchBonusNumber(int number) {
        BonusNumber bonusNumber = new BonusNumber(defaultLottoNumbers, number);

        boolean match = bonusNumber.isMatch(number);

        assertThat(match).isTrue();
    }
}
