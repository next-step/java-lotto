package lottos.domain;

import lottos.converter.IntListConverter;
import lottos.domain.exceptions.LottoDuplicationNumberException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,6:3"}, delimiter = ':')
    void 로또와_보너스넘버가_중첩되는경우_에러(@ConvertWith(IntListConverter.class) final List<Integer> numbers, final int bonusNumber) {

        assertThrows(LottoDuplicationNumberException.class, () -> new WinningLotto(numbers, bonusNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"4,5,6,7,8,9:10:1,2,3,4,5,6:FIFTH", "1,2,3,4,5,6:7:1,2,7,8,9,10:MISS"}, delimiter = ':')
    void 로또_비교(@ConvertWith(IntListConverter.class) final List<Integer> winningNumbers, final int bonusNumber,
               @ConvertWith(IntListConverter.class) final List<Integer> numbers, final String prize) {

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(numbers);

        LottoResult lottoResult = winningLotto.match(lotto);
        assertEquals(lottoResult.getPrize(), LottoPrize.valueOf(prize));
    }
}
