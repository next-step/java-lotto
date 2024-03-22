package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {

    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private static Lottos testLottos;
    private static final LottoNumbers winnerNumbers = LottoNumbers.fromIntegerList(Arrays.asList(1, 2, 3, 4, 5, 6));

    @BeforeAll
    static void beforeAll() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            LottoNumbers numbers = LottoNumbers.fromIntegerList(Arrays.asList(1 + i, 2 + i, 3 + i, 4 + i, 5 + i, 6 + i));
            lottos.add(new Lotto(numbers, randomNumberGenerator));
        }
        testLottos = new Lottos(lottos);
    }

    @Test
    public void 보너스_볼은_1등_번호와_중복이_되어서는_안된다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber bonusNumber = new LottoNumber(1);
            WinningNumbers winningNumbers = new WinningNumbers(winnerNumbers, bonusNumber);
        });
    }
}
