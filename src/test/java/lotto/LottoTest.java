package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void match() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");

        List<LottoNumber> winnerNumbers = new ArrayList<>();
        winnerNumbers.add(new LottoNumber(1));
        winnerNumbers.add(new LottoNumber(2));
        winnerNumbers.add(new LottoNumber(3));
        winnerNumbers.add(new LottoNumber(4));
        winnerNumbers.add(new LottoNumber(5));
        winnerNumbers.add(new LottoNumber(6));

        int result = lotto.match(winnerNumbers);
        Assertions.assertThat(result).isEqualTo(6);
    }
}
