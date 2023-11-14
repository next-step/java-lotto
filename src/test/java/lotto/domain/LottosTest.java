package lotto.domain;

import lotto.application.LottoGeneration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottosTest {
    @Test
    @DisplayName("당첨번호와 로또 번호 목록을 비교하여 맞은번호마다 갯수를 카운트하는 map을 확인")
    void 로또당첨_목록_확인() {
        List<Integer> winList = Arrays.asList(6,5,4,3,2,1);
        NumberGeneration numberGeneration = new TestNumberGeneration();
        LottoGeneration lottoGeneration = new LottoGeneration();
        LottoRank lottoRank = LottoRank.findMatchNumber(6);

        Lottos lottos = lottoGeneration.generateLottoNumbers(5, numberGeneration);
        Map<LottoRank,Integer> ranks = lottos.findMatchNumbers(winList);

        Assertions.assertThat(ranks).hasSize(1).containsEntry(lottoRank
        ,5);

    }
}
