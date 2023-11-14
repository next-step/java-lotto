package lotto.domain;

import calculator.domain.NumberGeneration;
import calculator.domain.RandomNumberGeneration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("구매한 로또 목록 관련 테스트")
public class LottosTest {

    @Test
    @DisplayName("구매한 로또 개수를 확인한다")
    void 구매_로또수_확인() {
        NumberGeneration numberGeneration = new RandomNumberGeneration();
        int amount = 14000;

        Lottos lottos = new Lottos(amount, numberGeneration);

        assertThat(lottos.count()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또당첨 번호와 매치한 결과를 리턴")
    void 로또당첨_목록확인() {
        List<Integer> winList =  new ArrayList<>(Arrays.asList(6,5,4,2,3,10));
        NumberGeneration numberGeneration = new TestNumberGeneration();
        int amount = 5000;
        int bonus = 1;

        Lottos lottos = new Lottos(amount, numberGeneration);
        Map<LottoRank, Integer> result = lottos.findRanks(winList, bonus);

        assertThat(result).hasSize(1).containsEntry(LottoRank.SECOND, 5);
    }
}
