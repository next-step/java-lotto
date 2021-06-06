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
import java.util.List;

public class LottoTest {

    @DisplayName("로또번호를 갯수당 출력한다")
    @Test
    public void lottoNUmber() {
        Lotto lotto = new Lotto(1000);
        Assertions.assertThat(lotto.allLotto.lottoPapers.size()).isEqualTo(1);
    }

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.")
    @ParameterizedTest
    @CsvSource("14000")
    public void lottoPay(String payment) {
        Lotto lotto = new Lotto();
        lotto.ActionCount(Integer.parseInt(payment));
        Assertions.assertThat(lotto.allLotto.lottoPapers.size()).isEqualTo(14);
    }

    @DisplayName("당첨번호입력받기")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    public void winningNumber(String winning_numbers) {
        // Lotto lotto = new Lotto(1000);
        assertThat(winning_numbers).isEqualTo("1,2,3,4,5,6");
    }

    @DisplayName("보너스볼 입력받기")
    @ParameterizedTest
    @ValueSource(strings = {"7"})
    public void bonusNumber(String winning_numbers) {
        // Lotto lotto = new Lotto(1000);
        assertThat(winning_numbers).isEqualTo("7");
    }

    @DisplayName("입력된 5개가 일치하는지")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    public void howSameNumber(String input_numbers) {
        String winning_numbers = "1,2,3,4,5,7";
        String[] input_number = input_numbers.split(",");
        List<Integer> input_numberList = new ArrayList<>();
        int bonus_number = 6;
        for (int i = 0; i < input_number.length; i++) {
            input_numberList.add(Integer.valueOf(input_number[i]));
        }
        AllLotto allLotto = new AllLotto();
        allLotto.lottoPapers.add(input_numberList);
        ComparisonLottoNumber comparisonLottoNumber = new ComparisonLottoNumber();
        List<Integer> resultCount = comparisonLottoNumber.comparison(allLotto, winning_numbers,bonus_number);
        Assertions.assertThat(resultCount.get(0)).isEqualTo(7);
    }

    @DisplayName("입력된 6개번호가 몇등인지")
    @Test
    public void rank() {
        List<Integer> resultCount = new ArrayList<>();
        resultCount.add(1);//0등
        resultCount.add(5);//3등
   //     resultCount.add(6);//1등
        resultCount.add(7);//2등
        resultCount.add(4);//4등
        resultCount.add(3);//5등
        Rank rank = new Rank();
        List<Match> matches = rank.rankCondition(resultCount);
        Assertions.assertThat(matches).contains(Match.FIRST);
    }
    @DisplayName("입력된 등수의 갯수")
    @Test
    public void rankCount() {
        List<Integer> resultCount = new ArrayList<>();
        resultCount.add(1);//0등
        resultCount.add(5);//3등
        //     resultCount.add(6);//1등
        resultCount.add(7);//2등
        resultCount.add(4);//4등
        resultCount.add(3);//5등
        Rank rank = new Rank();
        List<Match> matches = rank.rankCondition(resultCount);
        Assertions.assertThat(matches).contains(Match.FIRST);
    }
}