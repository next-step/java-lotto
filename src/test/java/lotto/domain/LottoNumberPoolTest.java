package lotto.domain;

import lotto.domain.data.LottoNumber;
import lotto.domain.data.LottoNumberPool;
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

        assertThat(lottoNumber.getNumber()).isEqualTo(1);
    }

    @DisplayName("LottoPool 안에 있는 여러개의 로또번호를 정상적으로 가져온다.")
    @Test
    void testGetNumbersTest() {
        List<LottoNumber> lottoNumbers = LottoNumberPool.get(List.of(1,2,3));
        List<Integer> lottoNumberInt = lottoNumbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
        assertThat(lottoNumberInt).containsOnly(1,2,3);
    }

    @DisplayName("LottoPool 안에 있는 모든 로또번호를 정상적으로 가져온다.")
    @Test
    void getAllTest() {
        List<Integer> lottoNumbers = LottoNumberPool.getAll().stream().map(LottoNumber::getNumber).collect(Collectors.toList());
        List<Integer> expectationNumbers = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());

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