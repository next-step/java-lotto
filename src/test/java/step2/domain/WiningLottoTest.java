package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WiningLottoTest {
    @Test
    @DisplayName("로또 우승자 들고오기")
    public void getWinner() {
        List<Lotto> testLotto = new ArrayList<>();
        testLotto.add(new Lotto(new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))));
        testLotto.add(new Lotto(new LottoNumbers(new ArrayList<>(Arrays.asList(21, 23, 43, 24, 34, 42)))));
        testLotto.add(new Lotto(new LottoNumbers(new ArrayList<>(Arrays.asList(11, 12, 14, 15, 16, 17)))));
        Lottos lottos = new Lottos(testLotto);

        WiningLotto winingLotto = new WiningLotto(lottos, new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))));

        assertThat(winingLotto.getWinners()).isEqualTo(3);
    }
}
