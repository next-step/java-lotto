package lotto.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.model.LottoMoney;
import lotto.domain.model.LottoRank;
import lotto.domain.model.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("수익률을 (유효 수숫점 두자리) 계산한다.")
    void profitPercent() {
        LottoMoney lottoMoney = LottoMoney.of(14000);
        LottoResult lottoResult = LottoResult.createEmpty();
        lottoResult.update(LottoRank.FIFTH);
        double profitPercent = LottoService.profitPercent(lottoResult, lottoMoney);
        assertThat(profitPercent).isCloseTo(0.35, Assertions.offset(0.01));
    }
}
