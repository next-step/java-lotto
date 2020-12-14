package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("정상생성 : 1-45 사이 숫자")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void create(int number) {
        //when
        LottoNumber lottoNumber = new LottoNumber(number);

        //then
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("생성 오류 : 범위를 벗어난 값")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void create_exception(int number) {
        //when, then
        assertThatIllegalArgumentException()
              .isThrownBy(() -> new LottoNumber(number))
              .withMessage("1 - 45 사이 숫자를 입력해주세요");
    }

    @Test
    void sort() {
        List<LottoNumber> lottoNumbers = Arrays
              .asList(new LottoNumber(5), new LottoNumber(3), new LottoNumber(4));

//        Collections.sort(lottoNumbers);

        System.out.println(lottoNumbers);
    }
}
