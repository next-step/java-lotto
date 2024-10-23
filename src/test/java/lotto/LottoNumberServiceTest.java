package lotto;

import lotto.lotto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberServiceTest {

    private LottoService lottoService = new LottoService();

    private LottoResult result;

    @BeforeEach
    void setUp() {
        FakeLottoStrategy fakeLottoStrategy = new FakeLottoStrategy();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(fakeLottoStrategy.generateLotto());
        result = new LottoResult(lottos);
    }
    @Test
    @DisplayName("로또생성서비스_테스트")
    public void createLottoTest() {
        assertThat(lottoService.createLotto(3000).getLottoSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또등수_일치하는수_계산")
    public void calculateLotto() {
        String answer = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 10;
        lottoService.calculateLotto(answer, result, bonusNumber);
        assertThat(result.getResultMap().get(LottoRank.RANK_TWO_BONUS)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또_당첨마진율_구하기")
    public void calculateMarginRate() {
        calculateLotto();
        LottoMargin lottoMargin = lottoService.calculateMarginRate(3000, result);
        assertThat(lottoMargin.getMarginRate()).isEqualTo(10000);
    }
}
