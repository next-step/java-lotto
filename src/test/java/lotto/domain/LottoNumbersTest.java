package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import static lotto.domain.LottoNumber.LOWER_LOTTONUMBER_BOUND;
import static lotto.domain.LottoNumbers.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    private LottoNumbers lottoNumbers;
    private Set<LottoNumber> lottoNumberSet = new LinkedHashSet<>();


    @BeforeEach
    void setUp() {
        for (int i = 1; i <= LOTTO_SIZE; i++) {
            lottoNumberSet.add(new LottoNumber(i));
        }

        lottoNumbers = new LottoNumbers(lottoNumberSet);
    }

    @Test
    void createLottoNumbers() {
        //then
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(lottoNumberSet));
    }

    @Test
    void validLottoSize() {
        //given
        lottoNumberSet.remove(new LottoNumber(LOTTO_SIZE));
        LottoNumbers testLottoNumbers = new LottoNumbers(lottoNumberSet);

        //when, then
        assertThatThrownBy(() -> {
            testLottoNumbers.hasLottoSize();
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void containsAllTest() {
        //given
        Set<LottoNumber> testSet = new LinkedHashSet<>(lottoNumberSet);
        testSet.remove(new LottoNumber(1));
        testSet.add(new LottoNumber(LOTTO_SIZE + 1));
        LottoNumbers testNumbers = new LottoNumbers(testSet);

        //when
        int result = lottoNumbers.containsAll(testNumbers);

        //then
        assertThat(result).isEqualTo(LOTTO_SIZE - 1);
    }

    @Test
    void containsOneTest() {
        //given
        LottoNumber containNumber = new LottoNumber(LOTTO_SIZE);
        LottoNumber notInNumber = new LottoNumber(LOTTO_SIZE + 1);

        //when, then
        assertThat(lottoNumbers.containsOne(containNumber)).isTrue();
        assertThat(lottoNumbers.containsOne(notInNumber)).isFalse();
    }

    @Test
    void takeNumbersTest() {
        //given
        int takeNumber = 3;

        //when
        LottoNumbers testNumbers = lottoNumbers.takeNumbers(takeNumber);

        //then
        assertThat(testNumbers.size()).isEqualTo(takeNumber);
    }


    @Test
    void createLottoNumbersFromArrayIntegers() {
        //given
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = LOWER_LOTTONUMBER_BOUND; i <= LOTTO_SIZE; i++) {
            numbers.add(i);
        }

        //when
        LottoNumbers result = LottoNumbers.of(numbers);

        //then
        assertThat(result).isEqualTo(lottoNumbers);
    }

}
