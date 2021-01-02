package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @Test
    void createBonusNumber(){
        String lastWinningNumber = "1,2,3,4,5,6";
        String newbonusNumber = "7";
        BonusNumber bonusNumber = new BonusNumber( lastWinningNumber ,newbonusNumber);
        boolean equalsNumber = bonusNumber.equals(new BonusNumber((7)));
        assertThat(equalsNumber).isEqualTo(true);
    }

    @Test
    void validBonusNumber() {
        String lastWinningNumber = "1,2,3,4,5,6";
        String newbonusNumber = "6";
        assertThrows( IllegalArgumentException.class,()->{
            int bonus = new BonusNumber(6).validBonusNumber(lastWinningNumber,newbonusNumber);
        });
    }


    @Test
    void validBonusNumberException(){
        String lastWinningNumber = "1,2,3,4,5,6";
        String newbonusNumber = "6";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new BonusNumber(6).validBonusNumber(lastWinningNumber, newbonusNumber);
        }).withMessageMatching("Bonus Number exist in lastWinningNumber.");
    }
}