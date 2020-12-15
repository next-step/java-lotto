package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

public class LottoNumbersTest {

    @Test
    @DisplayName("46개중에서 랜덤으로 뽑은 숫자들이 6개이고, 1 ~ 45사이에 있는지 테스트")
    public void pickLottoNumberRandom() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers();

        // when
        List<LottoNumber> pickLottoNumbers = lottoNumbers.getLottoNumbers();

        // then
        assertThat(pickLottoNumbers.size()).isEqualTo(6);

        pickLottoNumbers.stream().forEach(number -> {
            assertThat(number.getLottoNumber()).isGreaterThanOrEqualTo(1)
                    .isLessThanOrEqualTo(45);
        });
    }

    @Test
    @DisplayName("고정으로 세팅한 숫자들을 6개 뽑았을때, 리스트에 해당 번호가 있는지 테스트")
    public void pickLottoNumberFixed() {
        // given
        List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 45);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        // when
        List<LottoNumber> pickLottoNumbers = lottoNumbers.getLottoNumbers();

        // then
        pickLottoNumbers.stream().forEach(number -> {
            assertThat(number.getLottoNumber()).isIn(numbers);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false", "10,true", "11,false"})
    @DisplayName("주어진 로또번호가 목록에 있는지 테스트")
    public void containsLottoNumber(String input, String expected) {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 10, 20, 30, 40, 45));
        LottoNumber lottoNumber = new LottoNumber(Integer.parseInt(input));

        // when
        boolean isContainsLottoNumber = lottoNumbers.containsLottoNumber(lottoNumber);

        // then
        assertThat(isContainsLottoNumber).isEqualTo(Boolean.parseBoolean(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 3 4 5 6,1", "1 20 3 4 5 6,2", "1 20 30 4 5 6,3", "1 20 30 40 5 6,4"
                        , "1 20 30 40 45 6,5", "1 20 30 40 45 10,6"})
    @DisplayName("두개의 로또번호들의 일치하는 수를 찾는 테스트")
    public void matchedLottoNumbersCount(String input, String expected) {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 10, 20, 30, 40, 45));
        LottoNumbers winLottoNumbers = new LottoNumbers(
                                            Arrays.asList(input.split(" ")).stream()
                                                            .map(Integer::parseInt)
                                                            .collect(Collectors.toList())
        );

        // when
        int matchedLottoNumbersCount = lottoNumbers.matchedLottoNumbersCount(winLottoNumbers);

        // then
        assertThat(matchedLottoNumbersCount).isEqualTo(Integer.parseInt(expected));
    }
}