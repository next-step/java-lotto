package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

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

        //when, then
        assertThatThrownBy(() -> {
            LottoNumbers testLottoNumbers = new LottoNumbers(lottoNumberSet);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void containsTest() {
        //given
        Set<LottoNumber> testSet = new LinkedHashSet<>(lottoNumberSet);
        testSet.remove(new LottoNumber(1));
        testSet.add(new LottoNumber(LOTTO_SIZE + 1));
        LottoNumbers testNumbers = new LottoNumbers(testSet);

        //when
        int result = lottoNumbers.contains(testNumbers);

        //then
        assertThat(result).isEqualTo(LOTTO_SIZE - 1);
    }

}
