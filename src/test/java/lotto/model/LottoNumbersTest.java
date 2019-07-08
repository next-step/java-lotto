package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;


class LottoNumbersTest {

//    @Test
//    void getNumbers() {
//        List<Integer> numbers = Arrays.asList(1, 4, 5, 6, 7, 8);
//        assertThat(new LottoNumbers(numbers).getNumbers().size()).isEqualTo(6);
//    }
//
//    @Test
//    void validate() {
//        List<Integer> numbers = Arrays.asList(1, 4, 2);
//        assertThatThrownBy(() -> new LottoNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void getWinningCount() {
//        LottoNumbers lottery = new LottoNumbers(Arrays.asList(1, 4, 5, 6, 7, 20));
//        assertThat(lottery.getWinningCount(Arrays.asList(1, 4, 5, 6, 7, 8))).isEqualTo(5);
//    }


    @Test
    void countMatch() {
        LinkedHashSet winningNumbers = (LinkedHashSet) Arrays.asList(
                Number.of(4),
                Number.of(5),
                Number.of(6),
                Number.of(7),
                Number.of(8),
                Number.of(9));


//        new Lotteries(winningNumbers);
    }
}