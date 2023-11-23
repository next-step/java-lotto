package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,11,12,13:3", "11,12,13,14,15,16:0", "45,1,2,44,36,26:2"}, delimiter = ':')
    void Lotto_당첨번호와_동일갯수_카운트(String lottoNumbers, int expected) {
        Lotto lotto = of(Arrays.stream(lottoNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .toArray());
        Lotto lastWeekLotto = of(1, 2, 3, 4, 5, 6);

        assertThat(lotto.getMatchCount(lastWeekLotto)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4", "1,2,3,11,12,46", "0,12,13,14,15,16", "45,1,2,44,36,100,55"}, delimiter = ':')
    void Lotto_수동생성_실패(String inputNumbers) {

        int[] numbers = Arrays.stream(inputNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        assertThatThrownBy(() -> of(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Lotto_수동생성_실패_중복값() {
        int[] numbers = {1, 2, 3, 4, 5, 5};

        assertThatThrownBy(() -> of(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Lotto_수동생성_성공() {
        Lotto lotto = of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6", "1,2,3,11,12,44", "5,12,23,14,25,36", "45,1,32,36,10,25"}, delimiter = ':')
    void Lotto_생성_후_정렬(String inputNumbers) {
        int[] numbers = Arrays.stream(inputNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        Lotto lotto = of(numbers);
        List<Integer> sortedNumber = IntStream.of(numbers).boxed().collect(Collectors.toList());
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers.get(0)).isEqualTo(sortedNumber.get(0));
        assertThat(lottoNumbers.get(1)).isEqualTo(sortedNumber.get(1));
        assertThat(lottoNumbers.get(2)).isEqualTo(sortedNumber.get(2));
        assertThat(lottoNumbers.get(3)).isEqualTo(sortedNumber.get(3));
        assertThat(lottoNumbers.get(4)).isEqualTo(sortedNumber.get(4));
        assertThat(lottoNumbers.get(5)).isEqualTo(sortedNumber.get(5));
    }

}