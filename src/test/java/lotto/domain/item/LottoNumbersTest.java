package lotto.domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @DisplayName("로또 번호 리스트를 생성한다.")
    @Test
    public void constructor_success() throws Exception {
        //given
        ArrayList<LottoNumber> numbers =
                new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2)));

        //when
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers compare = new LottoNumbers(numbers);

        //then
        assertThat(lottoNumbers.equals(compare)).isTrue();
    }
}
