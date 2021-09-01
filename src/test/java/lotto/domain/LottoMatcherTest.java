package lotto.domain;

import lotto.exception.InvalidNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoMatcherTest {
    @DisplayName("지난주 당첨번호가 1 ~ 45 외의 숫자면 예외가 발생한다.")
    @Test
    void invalidLottoNumber() {
        List<LottoNumber> numbers = new ArrayList<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(4));
        numbers.add(new LottoNumber(5));
        numbers.add(new LottoNumber(6));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(numbers));

        String lastWeekNumbers = "11,22,33,44,55,66";

        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(
                () -> new LottoMatcher(lottos, lastWeekNumbers));
    }
}
