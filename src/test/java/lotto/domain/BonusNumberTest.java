package lotto.domain;

import lotto.util.NumberUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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
    void noEqualTest(){
        boolean b = new BonusNumber(7).notEquals(new Integer(7));
        assertThat(b).isEqualTo(false);
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