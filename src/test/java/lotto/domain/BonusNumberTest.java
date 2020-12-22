package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    private BonusNumber bonusNumber;



    @Test
    void createBonusNumber(){
        String lastWinningNumber = "1,2,3,4,5,6";
        String newbonusNumber = "7";
        BonusNumber bonusNumber = new BonusNumber( lastWinningNumber ,newbonusNumber);
        assertThat(bonusNumber).isEqualTo(new BonusNumber(7));
    }

    @Test
    void validBonusNumber() {
        String lastWinningNumber = "1,2,3,4,5,6";
        String newbonusNumber = "6";
        assertThrows( RuntimeException.class,()->{
            int bonus = bonusNumber.validBonusNumber(lastWinningNumber,newbonusNumber);
        });
    }
}