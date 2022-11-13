package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    void 우승번호를_받아_생성한다() {
        Integer[] numbers = {1,2,3,4,5,6};
        WinningLotto winningLotto = new WinningLotto(numbers);

        List<LottoNumber> numbersList = Arrays.stream(numbers)
                        .map(n -> LottoNumber.of(n))
                                .collect(Collectors.toList());

        assertThat(winningLotto.same(numbersList)).isTrue();
    }

    @Test
    void 당첨갯수를_센다() {
        Integer[] winning = {1,2,3,4,5,6};
        Integer[] trys = {1,2,4,7,8,10};
        List<LottoNumber> tryLotto = Arrays.stream(trys)
                .map(n -> LottoNumber.of(n))
                .collect(Collectors.toList());

        WinningLotto winningNumber = new WinningLotto(winning);

        assertThat(winningNumber.countSameNumber(tryLotto)).isEqualTo(3);
    }
}
