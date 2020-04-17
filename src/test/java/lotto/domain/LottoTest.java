package lotto.domain;

import lotto.exception.InvalidLottoNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 성공 테스트")
    public void lottoConstructorWithArrayListTest() {
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(expect);

        assertThat(lotto.size()).isEqualTo(expect.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4", "1, 2, 3, 4, 5, 6, 7, 8"})
    @DisplayName("로또 숫자 갯수가 아닌 경우 예외 테스트")
    public void lottoInvalidInputSizeTest(String input) {
        List<Integer> expect = Arrays.stream(input.split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        assertThatExceptionOfType(InvalidLottoNumbersException.class)
                .isThrownBy(() -> {
                    Lotto.of(expect);
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 45, 70", "-1, 2, 3, 4, 5, 6, 7"})
    @DisplayName("로또 숫자가 유효하지 않은 경우 예외 테스트")
    public void lottoInvalidInputNumberTest(String input) {
        List<Integer> expect = Arrays.stream(input.split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        assertThatExceptionOfType(InvalidLottoNumbersException.class)
                .isThrownBy(() -> {
                    Lotto.of(expect);
                });
    }


    @Test
    @DisplayName("로또 값을 정상적으로 string 변환하는지 테스트")
    public void lottoToStringTest() {
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(expect);

        assertThat(lotto.toString("[%s]", ", ")).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

}
