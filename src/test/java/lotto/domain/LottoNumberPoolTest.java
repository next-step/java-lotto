package lotto.domain;

import lotto.domain.data.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberPoolTest {

    @DisplayName("LottoPool 안에 있는 하나의 로또번호를 정상적으로 가져온다.")
    @Test
    void getOneNumberTest() {
        LottoNumber lottoNumber = LottoNumberPool.get(1);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(1));
    }

    @DisplayName("LottoPool 안에 있는 여러개의 로또번호를 정상적으로 가져온다.")
    @Test
    void testGetNumbersTest() {
        List<LottoNumber> lottoNumbers = LottoNumberPool.get(List.of(1,2,3));
        assertThat(lottoNumbers).containsOnly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3));
    }

    @DisplayName("LottoPool 안에 있는 모든 로또번호를 정상적으로 가져온다.")
    @Test
    void getAllTest() {
        List<LottoNumber> lottoNumbers = LottoNumberPool.getAll();
        List<LottoNumber> expectationNumbers = IntStream.rangeClosed(1,45).boxed().map(LottoNumber::of).collect(Collectors.toList());

        assertThat(lottoNumbers).containsAll(expectationNumbers);
    }

    @DisplayName("LottoPool 안에 없는 번호 일 경우 IllegalArgument 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    void validateTest(int value) {
        assertThatThrownBy(() -> {
            LottoNumberPool.get(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}