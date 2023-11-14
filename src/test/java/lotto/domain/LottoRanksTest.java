package lotto.domain;

import calculator.domain.NumberGeneration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 당첨 확인 관련 테스트")
public class LottoRanksTest {

    @Test
    @DisplayName("모든 로또 당첨금의 합계를 확인")
    void 당첨금_합계확인() {
        List<Integer> winList = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 10));
        NumberGeneration numberGeneration = new TestNumberGeneration();
        int amount = 5000;
        int bonus = 1;

        Lottos lottos = new Lottos(amount, numberGeneration);
        LottoRanks lottoRanks = new LottoRanks(lottos, winList, bonus);

        assertThat(lottoRanks.findPrizeMoney()).isEqualTo(150_000_000L);


    }
}
