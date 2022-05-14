package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    void create() {
        //given
        List<LottoNumber> lottoNumbers = TestObjectSupport.convertToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        LottoNumbers result = new LottoNumbers(lottoNumbers);

        //then
        assertThat(result).isEqualTo(new LottoNumbers(lottoNumbers));
    }

    @Test
    void createByStaticFactoryMethod() {
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        LottoNumbers result = LottoNumbers.create(lottoNumbers);

        //then
        assertThat(result).isEqualTo(new LottoNumbers(TestObjectSupport.convertToLottoNumberList(lottoNumbers)));
    }

    @Test
    void numberCount() {
        //given
        List<LottoNumber> fiveLottoNumbers = TestObjectSupport.convertToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5));

        //then
        assertThatThrownBy(() -> new LottoNumbers(fiveLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void duplicateNumber() {
        //given
        List<LottoNumber> duplicateNumbers = TestObjectSupport.convertToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 1));

        //then
        assertThatThrownBy(() -> new LottoNumbers(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
