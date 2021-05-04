package domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

public class LottoTest {

    @DisplayName("로또번호를 갯수당 출력한다")
    @Test
    public void lottoNUmber(){
        Lotto lotto = new Lotto(1000);
    }
    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.")
    @ParameterizedTest
    @CsvSource("14000")
    public void lottoPay(String payment){
        Lotto lotto = new Lotto(Integer.parseInt(payment));
    }
    @DisplayName("당첨번호입력받기")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    public void winningNumber(String winning_numbers){
       // Lotto lotto = new Lotto(1000);
        assertThat(winning_numbers).isEqualTo("1,2,3,4,5,6");
    }
    @DisplayName("보너스볼 입력받기")
    @ParameterizedTest
    @ValueSource(strings = {"7"})
    public void bonusNumber(String winning_numbers){
        // Lotto lotto = new Lotto(1000);
        assertThat(winning_numbers).isEqualTo("7");
    }
    @DisplayName("입력된 6개번호가 몇 개 일치하는지/보너스 + 5개가 일치하는지")
    @Test
    public void howSameNumber(){
        String winning_numbers = "1,2,3,4,5,6,7";
        Lotto lotto = new Lotto(14000);
        String [] inputWinningNumber = winning_numbers.split(",");
        ArrayList<Integer> inputNumber = new ArrayList<>();
        for (int i = 0; i <inputWinningNumber.length ; i++) {
            inputNumber.add(Integer.parseInt(inputWinningNumber[i]));
        }
        System.out.println(inputNumber);
        lotto.comparisonsToArray(inputNumber);
    }
}
