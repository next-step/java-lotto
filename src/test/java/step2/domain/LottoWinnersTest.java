package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lottos;
import step2.domain.LottoWinners;
import step2.utils.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinnersTest {
    @Test
    @DisplayName("로또 우승자 들고오기")
    void getWinner() {
        List<Lotto> testLotto = new ArrayList<>();
        testLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        testLotto.add(new Lotto(new ArrayList<>(Arrays.asList(10, 11, 12, 13, 14, 15))));
        testLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 40, 41, 15))));
        Lottos lottos = new Lottos(testLotto);

        LottoWinners lottoWinners = new LottoWinners(lottos, new ArrayList<>(Arrays.asList(1, 2, 3, 40, 41, 42)));

        assertThat(lottoWinners.getWinner()).contains(3, 5);
    }
}
