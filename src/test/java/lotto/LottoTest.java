package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        Lotto lastWeekLWinningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Lotto thisWeekMyLotto = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        Counter counter = new Counter();

        PlayLotto.countSameNumbers(lastWeekLWinningLotto, thisWeekMyLotto, counter, index);

        assertThat(counter.getCount()).isEqualTo(1);
    }

}
