package lotto.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LottoTest {


    @DisplayName("로또 번호 저장 테스치")
    @Test
    void 로또_번호_저장() {
        List<LottoNumber> numbers = new ArrayList<>(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)

                ));
        Lotto lotto = new Lotto(numbers);
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    //    @ParameterizedTest
    //    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("로또 번호 갯수의 불일치")
    @Test

    void lottoNumCountNotQualified() {

        Assertions.assertThatThrownBy(() -> {
            List<LottoNumber> numbers = new ArrayList<>(Arrays.asList(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5)
                    ));
            Lotto lotto = new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("중복된 번호의 포함")
    @Test
    void duplicatedLottoNum() {
        Assertions.assertThatThrownBy(() -> {
            List<LottoNumber> numbers = new ArrayList<>(Arrays.asList(
                    new LottoNumber(2),
                    new LottoNumber(2),
                    new LottoNumber(2),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            ));
            Lotto lotto = new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}