package lottoGame.model;

import lottoGame.model.exception.InputException;
import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {46,47,51})
    void if_out_range(int input){
        assertThrows(InputException.class, () ->
                new DefaultLottoNumber(input));
    }
}
