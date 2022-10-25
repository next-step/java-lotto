package lottoGame.model.lotto.lottoNumber;

import lottoGame.model.exception.InputException;
import lottoGame.model.lotto.WinningLotto;
import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    private static Stream<Arguments> provideIntInput() {
        return Stream.of(
                Arguments.of(
                        new DefaultLottoNumber(1),
                        new DefaultLottoNumber(15),
                        new DefaultLottoNumber(27),
                        new DefaultLottoNumber(30),
                        new DefaultLottoNumber(44),
                        new DefaultLottoNumber(45))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 47, 51})
    void if_out_range(int input) {
        assertThrows(InputException.class, () ->
                new DefaultLottoNumber(input));
    }

    @ParameterizedTest
    @MethodSource("provideIntInput")
    void createLottoNumber(DefaultLottoNumber lottoNum) {
        List<LottoNumber> lottoNumber = DefaultLottoNumber.getLottoNumbers();
        assertThat(lottoNumber).contains(lottoNum);
    }
}
