package lottos.domain;

import lottos.domain.exceptions.LottoDuplicationNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,6:3"}, delimiter = ':')
    void 로또와_보너스넘버가_중첩되는경우_에러(final String numbersText, final String bonusText) {
        assertThrows(LottoDuplicationNumberException.class, () -> {

            final List<Integer> numbers = Arrays.stream(numbersText.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            final int bonusNumber = Integer.parseInt(bonusText);

            new WinningLotto(numbers, bonusNumber);
        });
    }

    @Test
    void 로또_비교() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(4, 5, 6, 7, 8, 9), 10);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoResult lottoResult = winningLotto.match(lotto);
        assertEquals(lottoResult.getPrize(), LottoPrize.FIFTH);
    }
}
