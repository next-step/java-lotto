package lotto;

import lotto.lotto.LottoResult;
import lotto.lotto.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberServiceTest {

    private LottoService lottoService = new LottoService();
    private LottoResult result = new LottoResult();

    @Test
    @DisplayName("로또 금액만큼 로또를 생성")
    public void createLottoTest() {
        Lottos lottos = lottoService.createLotto(3000);

        assertThat(lottos.getLottos().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스2등이 1번 나머지는 당첨되지않으면 보너스 2등에 1번, 나머지0으로 저장됨")
    public void calculateLottoRank() {
        FakeLottoStrategy fakeLottoStrategy = new FakeLottoStrategy();
        List<Lotto> createLotto = new ArrayList<>();
        createLotto.add(fakeLottoStrategy.generateLotto());
        Lottos lottos = new Lottos(createLotto);
        int bonusNumber = 10;

        result = lottoService.calculateLottoRank("1, 2, 3, 4, 5, 6", lottos, bonusNumber);

        assertThat(result.getResultMap().get(LottoRank.RANK_TWO_BONUS)).isEqualTo(1);
        result.getResultMap().keySet().stream().forEach(value -> {
            if (!value.equals(LottoRank.RANK_TWO_BONUS)) {
                assertThat(result.getResultMap().get(value)).isEqualTo(0);
            }
        });
    }

    @Test
    @DisplayName("로또_당첨마진율_구하기")
    public void calculateMarginRate() {
        calculateLottoRank();
        LottoMargin lottoMargin = lottoService.calculateMarginRate(3000, result);

        long resultPrice = 30_000_000 / 3_000;
        assertThat(lottoMargin.getMarginRate()).isEqualTo(resultPrice);
    }
}
