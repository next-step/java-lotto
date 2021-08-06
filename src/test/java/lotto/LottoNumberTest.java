package lotto;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNumberTest {

    LottoNumber lottoNumber = new LottoNumber();

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    @Test
    void 로또_숫자_1부터_45까지() {
        List<Integer> shuffleNumber = lottoNumber.shuffle();
        for (int number : shuffleNumber) {
            assertThat(number).isGreaterThanOrEqualTo(LOTTO_START_NUMBER)
                .isLessThanOrEqualTo(LOTTO_END_NUMBER);
        }
    }

    @Test
    void 로또_숫자_6개_섞였나() {
        List<Integer> shuffleNumber = lottoNumber.shuffle();
        List<Integer> shuffleNumber2 = lottoNumber.shuffle();
        shuffleNumber = shuffleNumber.stream().sorted().collect(Collectors.toList());
        shuffleNumber2 = shuffleNumber2.stream().sorted().collect(Collectors.toList());
        assertThat(Arrays.equals(shuffleNumber.stream()
                        .map(Integer::intValue)
                        .toArray(),
                        shuffleNumber2.stream()
                        .map(Integer::intValue)
                        .toArray())).isFalse();

    }



}
