package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    @Test
    @DisplayName("당첨 결과 반환 테스트.")
    void getResultTest() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 8, 9, 10)));
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 8, 9, 10, 11)));
        lottos.add(Lotto.createSpecificLotto(List.of(1, 8, 9, 10, 11, 12)));
        lottos.add(Lotto.createSpecificLotto(List.of(21, 22, 23, 24, 25, 26)));

        WinningLotto winningLotto = new WinningLotto(
            Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6)),
            new LottoNumber(7));
        LottoManager lottoManager = new LottoManager(lottos);

        //when
        Map<LottoRank, Integer> result = lottoManager.getResult(winningLotto);

        //then
        assertThat(result).containsEntry(LottoRank.FIFTH, 1);
        assertThat(result).containsEntry(LottoRank.FOURTH, 1);
        assertThat(result).containsEntry(LottoRank.THIRD, 1);
        assertThat(result).containsEntry(LottoRank.SECOND, 1);
        assertThat(result).containsEntry(LottoRank.FIRST, 1);
    }
}