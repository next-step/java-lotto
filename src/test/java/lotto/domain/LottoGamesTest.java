package lotto.domain;

import lotto.domain.generator.ManualLottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGamesTest {

    private ManualLottoGenerator manualLottoGenerator;

    @BeforeEach
    public void beforeEach() {
        manualLottoGenerator = new ManualLottoGenerator();
    }

    @Test
    @DisplayName("로또 수익률 계산")
    public void returnRate() {
        Lotto lotto = new Lotto(manualLottoGenerator);
        List<Lotto> lottoList = List.of(lotto);
        LottoGames lottoGames = new LottoGames(lottoList);
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        lottoGames.calculatePrizeCount(winningLotto);
        assertThat(lottoGames.calculateReturn()).isEqualTo(5);
    }

    @Test
    @DisplayName("인풋만큼 로또 게임 생성")
    public void gameMakeTest() {
        LottoGames lottoGames = new LottoGames(14000);
        assertThat(lottoGames.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("상금별 당첨이 몇개가 있는지 확인")
    public void calculatePrizeCountTest() {
        Lotto lotto = new Lotto(manualLottoGenerator);
        List<Lotto> lottoList = List.of(lotto);
        LottoGames lottoGames = new LottoGames(lottoList);
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        lottoGames.calculatePrizeCount(winningLotto);
        assertThat(lottoGames.getLottoResult()).isEqualTo(List.of(0, 0, 0, 1, 0, 0, 0));
    }


}
