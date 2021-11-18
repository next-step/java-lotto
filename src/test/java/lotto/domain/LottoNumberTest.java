package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @DisplayName("범위 밖의 숫자로 생성할 경우 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] number: {0}")
    @ValueSource(ints = {0, 46})
    void create_InvalidRangeNumber(int invalidRangeNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(invalidRangeNumber))
                .withMessage(LottoNumber.INVALID_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("정상적인 생성")
    @ParameterizedTest(name = "[{index}] number: {0}")
    @ValueSource(ints = {1, 30, 45})
    void create(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @DisplayName("정렬 테스트")
    @Test
    void sort() {
        //given
        LottoNumber smallLottoNumber = new LottoNumber(1);
        LottoNumber bigLottoNumber = new LottoNumber(45);
        List<LottoNumber> lottoNumbers = asList(bigLottoNumber, smallLottoNumber);

        //when
        Collections.sort(lottoNumbers);

        //then
        assertThat(lottoNumbers).isEqualTo(asList(smallLottoNumber, bigLottoNumber));
    }

    @DisplayName("캐시 잘 되는지")
    @ParameterizedTest(name = "[{index}] number: {0}")
    @ValueSource(ints = {1, 45})
    void cache(int number) {
        assertThat(LottoNumber.from(number) == LottoNumber.from(number)).isTrue();
    }

    @DisplayName("범위 밖의 숫자로 캐시된 데이터를 가져오면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] number: {0}")
    @ValueSource(ints = {0, 46})
    void create_InvalidRangeNumberInCachedNumbers(int invalidRangeNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.from(invalidRangeNumber))
                .withMessage(LottoNumber.INVALID_RANGE_ERROR_MESSAGE);
    }


    @Test
    void listOf() {
        //given
        int size = 5;

        //when
        List<LottoNumber> lottoNumbers = LottoNumber.listOf(size, noShuffleStrategy());

        //then
        List<LottoNumber> expectedLottoNumbers = IntStream.rangeClosed(1, size)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        assertThat(lottoNumbers).isEqualTo(expectedLottoNumbers);
    }

    private ShuffleStrategy noShuffleStrategy() {
        return (lottoNumbers11) -> {
        };
    }

}
