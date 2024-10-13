package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BonusBallTest {

    @DisplayName("보너스 볼이 일치하는지 확인 가능하다")
    @Test
    void matchBonusBall(){
        int bonusNumber = 12;
        BonusBall bonusBall = new BonusBall(bonusNumber);

        assertTrue(bonusBall.isBonusNumber(12));
        assertFalse(bonusBall.isBonusNumber(LottoNumber.valueOf(11)));
    }
    
    @DisplayName("로또 1장의 번호들 중 보너스 번호와 일치하는지 확인 가능하다")
    @Test
    void isMatchBonusBallFrom(){
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        BonusBall bonusBall = new BonusBall(1);

        assertTrue(bonusBall.isMatchBonusBallFrom(lotto));
    }
}