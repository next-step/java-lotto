package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class BonusNumberTest {

    @Test
    @DisplayName("bonus 번호 매치 테스트")
    public void bonusNumberMatchTest() {
        BonusNumber bonusNumber = new BonusNumber(2);
        boolean sut = bonusNumber.match(List.of(1, 2, 3));
        Assertions.assertTrue(sut);
    }

    @Test
    @DisplayName("보너스 번호 유효값 실패 테스트")
    public void createBonusNumberFailTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BonusNumber(46));
    }

}