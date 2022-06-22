package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersListTest {
    @Test
    void create() {
        //given
        LottoNumbers lottoNumbers = TestObjectSupport.createLottoNumbers();
        List<LottoNumbers> lottoNumbersList = List.of(lottoNumbers);

        //when
        LottoNumbersList result = new LottoNumbersList(lottoNumbersList);

        //then
        assertThat(result).isEqualTo(new LottoNumbersList(lottoNumbersList));
    }

    @Test
    void get() {
        //given
        LottoNumbersList lottoNumbersList = TestObjectSupport.createLottoNumbersList();
        LottoNumbers expectedLottoNumbers = TestObjectSupport.createLottoNumbers();

        //when
        LottoNumbers result = lottoNumbersList.get(0);

        //then
        assertThat(result).isEqualTo(expectedLottoNumbers);
    }

    @Test
    void isSizeBiggerThan() {
        //given
        LottoNumbersList lottoNumbersList = TestObjectSupport.createLottoNumbersList();
        int index1 = 2;
        int index2 = 3;

        //when
        boolean result1 = lottoNumbersList.isSizeBiggerThan(index1);
        boolean result2 = lottoNumbersList.isSizeBiggerThan(index2);

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

    @Test
    void add() {
        //given
        LottoNumbersList lottoNumbersList = TestObjectSupport.createLottoNumbersList();
        LottoNumbers lottoNumbers = TestObjectSupport.createLottoNumbers();
        LottoNumbersList expectedLottoNumbersList = new LottoNumbersList(
                Arrays.asList(lottoNumbers, lottoNumbers, lottoNumbers, lottoNumbers));

        //when
        LottoNumbersList result = lottoNumbersList.add(lottoNumbers);

        //then
        assertThat(result).isEqualTo(expectedLottoNumbersList);
        assertThat(lottoNumbersList).isEqualTo(TestObjectSupport.createLottoNumbersList());
    }
}
