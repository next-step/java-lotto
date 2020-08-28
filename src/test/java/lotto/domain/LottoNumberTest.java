package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("로또번호 생성 -  1~45 사이")
    @Test
    void newInstance() {
        //given
        int number = 1;

        //when
        LottoNumber lottoNumber = new LottoNumber(number);

        //then
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("로또번호 생성 - 잘못된 번호인 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void newInstanceWithWrongNumber(int number) {
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number))
              .withMessage("1 - 45 사이 번호만 등록 가능합니다.");
    }

    @DisplayName("객체 순서 비교")
    @Test
    void compareTo() {
        LottoNumber first = new LottoNumber(1);
        LottoNumber second = new LottoNumber(2);

        List<LottoNumber> lottoNumbers = Arrays.asList(second, first);
        //when
        Collections.sort(lottoNumbers);

        //then
        List<LottoNumber> expected = Arrays.asList(first, second);
        assertEquals(expected, lottoNumbers);
    }
}
