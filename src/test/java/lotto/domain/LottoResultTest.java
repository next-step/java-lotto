package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 로또결과_만들기() {
        ArrayList<Lotto> lottoList = new ArrayList<Lotto>();
        lottoList.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5,6 )));
        Lottos lottos = Lottos.create(lottoList);
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6));
        lottos.checkWinningNumbers(winningNumbers);

        assertThat(LottoResult.create(lottos)).isInstanceOf(LottoResult.class);
    }

}
