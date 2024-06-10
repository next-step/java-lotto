package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void lotto() {
        List<LottoNumber> actual = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        Lotto lotto = new Lotto(actual);
        List<LottoNumber> numbers = lotto.getNumbers();

        assertThat(numbers).containsAll(actual);
    }

    @Test
    void lottos() {
        Lottos lottos = new Lottos(14000);
        lottos.generate();
        int size = lottos.getSize();

        assertThat(size).isEqualTo(14);
    }

    @Test
    void checkLottoNumber() {
        Lottos lottos = new Lottos(14000);
        lottos.generate();
        String lastWeekNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";
        LastWeekWinningNumber lastWeekMatched = new LastWeekWinningNumber(lastWeekNumbers, bonusNumber);
        // TODO: 통계결과 먼저 있어야 된다.
        lottos.checkNumberLastWeek(lastWeekMatched);
    }

    @Test
    public void lastWeekWinningNumber() {
        String lastWeekNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";
        LastWeekWinningNumber lastWeekMatched = new LastWeekWinningNumber(lastWeekNumbers, bonusNumber);
        List<LottoNumber> expectedLottoNumber = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
                );
        LottoNumber expectedBonusNumber = new LottoNumber(Integer.parseInt(bonusNumber));
        assertThat(lastWeekMatched.getLastWeekNumbers()).containsAll(expectedLottoNumber);
        assertThat(lastWeekMatched.getBonusNumber()).isEqualTo(expectedBonusNumber);

    }
}
