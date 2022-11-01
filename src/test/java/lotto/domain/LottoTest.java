package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 생성")
    @Test
    void create() {
        List<LottoNumber> numbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto).isEqualTo(new Lotto(
                List.of(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))));
    }

    @DisplayName("로또 생성 실패 - 로또 숫자 개수 미달")
    @Test
    void invalidSize() {
        assertThatThrownBy(() -> new Lotto(
                List.of(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6");
    }

    @DisplayName("로또 생성 실패 - 로또 숫자 중복")
    @Test
    void duplicatedNumbers() {
        assertThatThrownBy(() -> new Lotto(
                List.of(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @ParameterizedTest(name = "로또 숫자가 몇 개나 일치하는지 - {0} | {1} | {2}")
    @CsvSource(value = {
            "1,2,3,4,5,6|1,2,3,4,5,6|6",
            "1,2,3,45,5,6|1,2,3,45,5,7|5",
            "1,2,3,4,5,6|7,8,9,10,11,12|0"
    }, delimiterString = "|")
    void howToMatch(String lottoNumbersJointComma, String winningNumbersJointComma, String matchNumberCount) {
        Lotto lotto = new Lotto(Arrays.stream(lottoNumbersJointComma.split(","))
                                      .map(Integer::parseInt)
                                      .map(LottoNumber::new)
                                      .collect(Collectors.toList()));
        LottoNumbers winningLottoNumbers = new LottoNumbers(Arrays.stream(winningNumbersJointComma.split(","))
                                                                  .map(Integer::parseInt)
                                                                  .map(LottoNumber::new)
                                                                  .collect(Collectors.toList()));
        assertThat(winningLottoNumbers.countOfMatch(lotto.getNumbers())).isEqualTo(Integer.parseInt(matchNumberCount));
    }
}
