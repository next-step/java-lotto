package lotto.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import lotto.domain.model.LottoMoney;
import lotto.domain.model.LottoRank;
import lotto.dto.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("수익률을 수숫점 두자리 계산한다.")
    void profitPercent() {
        LottoMoney lottoMoney = LottoMoney.of(14000);
        LottoResult lottoResult = LottoResult.empty();
        lottoResult.add(LottoRank.FIFTH);
        double profitMargin = LottoService.profitMargin(lottoResult, lottoMoney);
        assertThat(profitMargin).isEqualTo(0.35, offset(0.01));
    }
}
