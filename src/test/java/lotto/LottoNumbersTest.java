package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    void LottoNumbers_생성() {
        //given
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

        //when
        List<LottoNumber> value = lottoNumbers.value();

        //then
        assertThat(value).contains(new LottoNumber(1), new LottoNumber(6));
    }

    @Test
    void LottoNumbers_생성_사이즈_예외() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(new LottoNumber(1))))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또 번호의 개수는 6개여야 합니다.");
    }
}
