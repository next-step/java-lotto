package lotto.application;

import lotto.domain.Lottos;
import lotto.domain.NumberGeneration;
import lotto.domain.TestNumberGeneration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoPlayTest {

    @Test
    @DisplayName("당첨된 갯수에 따른 로또 당첨 금액을 리턴한다")
    void 로또당첨_금액_확인() {
        List<Integer> winList = Arrays.asList(6,5,4,3,2,1);
        NumberGeneration numberGeneration = new TestNumberGeneration();
        LottoGeneration lottoGeneration = new LottoGeneration();
        Lottos lottos = lottoGeneration.generateLottoNumbers(5, numberGeneration);

        LottoPlay lottoPlay = new LottoPlay(lottos, winList);
        Long result = lottoPlay.sumMatch();

        Assertions.assertThat(result).isEqualTo(10_000_000_000L);
    }
}
