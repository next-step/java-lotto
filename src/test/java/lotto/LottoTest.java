package lotto;

import lotto.business.PlayLotto;
import lotto.objects.Counter;
import lotto.objects.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private PlayLotto playLotto;

    @BeforeEach
    void setUp() {
        playLotto = new PlayLotto();
    }

    @ParameterizedTest
    @ValueSource(ints = {14000})
    void buyLotto(int money) {
        assertThat(playLotto.buyLotto(money)).isEqualTo(14);
    }

    @Test
    void getRandomNumber() {
        assertThat(playLotto.getRandomNumber()).isBetween(1, 45);
    }

    @RepeatedTest(value = 6)
    void createLotto(RepetitionInfo repetitionInfo) {
        assertThat(playLotto.createLotto().get(repetitionInfo.getCurrentRepetition() - 1)).isBetween(1, 45);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void countSameNumbers(int index) {
        Lotto lastWeekLWinningLotto = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        Lotto thisWeekMyLotto = new Lotto(new HashSet<>(Arrays.asList(3, 4, 5, 6, 7, 8)));
        Counter counter = new Counter();

        PlayLotto.countSameNumbers(lastWeekLWinningLotto, thisWeekMyLotto, counter, index);

        assertThat(counter.getCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6,7:3,4,5,6,7,8:5", "21,3,2,43,5,8,13:1,5,3,44,25,9:2"}, delimiter = ':')
    void compareNumbers(String lastNumbers, String myNumbers, String expected) {
        String[] splitedLastNumbers = lastNumbers.split(",");
        String[] splitedMyNumbers = myNumbers.split(",");

        Set<Integer> lastLottoNumbers = new HashSet<>();
        Set<Integer> myLottoNumbers = new HashSet<>();

        for (String number : splitedLastNumbers) {
            lastLottoNumbers.add(Integer.valueOf(number));
        }
        for (String number : splitedMyNumbers) {
            myLottoNumbers.add(Integer.valueOf(number));
        }

        Lotto lastLotto = new Lotto(lastLottoNumbers);
        Lotto myLotto = new Lotto(myLottoNumbers);

        assertThat(playLotto.compareNumbers(lastLotto, myLotto)).isEqualTo(Integer.valueOf(expected));
    }

}
