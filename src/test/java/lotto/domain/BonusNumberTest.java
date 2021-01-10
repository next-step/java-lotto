package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @Test
    void createBonusNumber(){
        String lastWinningNumber = "1,2,3,4,5,6";
        String newbonusNumber = "7";

        BonusNumber bonusNumber = new BonusNumber( lastWinningNumber ,newbonusNumber);
        boolean equalsNumber = bonusNumber.equals(new BonusNumber(7));
        assertThat(equalsNumber).isEqualTo(true);
    }

    @Test
    void validBonusNumberException(){
        BonusNumber bonusNumber = new BonusNumber();
        String lastWinningNumber = "1,2,3,4,5,6";
        String newbonusNumber = "6";
        LottoNumber lottoNumber = bonusNumber.generateBonusNumber(newbonusNumber);
        Set<LottoNumber> lottoNumberSet = bonusNumber.generateLastWinningNumbers(lastWinningNumber);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new BonusNumber(6).validBonusNumber(lottoNumberSet, lottoNumber);
        }).withMessageMatching("Bonus Number exist in lastWinningNumber.");
    }

    @Test
    void LottoNumber_BonusNumber_Match(){
        LottoNumber lottoNumber = new LottoNumber(10);
        BonusNumber bonusNumber = new BonusNumber(10);
        boolean b = lottoNumber.hashCode() == bonusNumber.hashCode();
        System.out.println(b);
    }

}