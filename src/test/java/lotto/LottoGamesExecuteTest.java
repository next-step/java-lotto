package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGamesExecuteTest {

    @Test
    @DisplayName("입력한 금액에 따른 게임 생성 테스트")
    void extractLottoNumbers() {
        int lottoPrice = 14000;
        LottoGamesExecute lottoGamesExecute = new LottoGamesExecute(lottoPrice);
        List <Lotto> lottos = lottoGamesExecute.extractLottoNumbers();
        Lotto lotto = lottos.get(0);
        assertThat(lottos.size()).isEqualTo(14);
        assertThat(lotto.lottoNumber().split(lotto.LAST_WEEK_WINNUM_DELIMITER).length).isEqualTo(6);
    }
}
