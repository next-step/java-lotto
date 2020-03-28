package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BonusNumberTest {

    @DisplayName("보너스 번호를 생성할 수 있다.")
    @Test
    public void createBonusNumberTest() {
        BonusNumber bonusNumber1 = new BonusNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        BonusNumber bonusNumber2 = new BonusNumber(Arrays.asList(11, 22, 33, 44, 15, 16), 7);

        assertThat(bonusNumber1).isNotEqualTo(bonusNumber2);
    }

    @DisplayName("보너스 번호는 기존 당첨번호와 중복될 수 없다.")
    @Test
    public void doesntDuplicateBonusNumber() {

    }

}
