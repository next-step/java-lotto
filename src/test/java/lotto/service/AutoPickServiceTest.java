package lotto.service;

import lotto.domain.LottoConstraint;
import lotto.domain.Pick;
import lotto.domain.enums.PickType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoPickServiceTest {

    @Test
    void autoPick(){
        LottoService lottoService = new LottoService(1000, new LottoConstraint(5, 30), new DefaultPrizePackager());
        AutoPickService autoPickService = new AutoPickService(lottoService);
        Pick pick = autoPickService.pick();
        assertThat(pick.getType()).isEqualTo(PickType.AUTO);
        assertThat(pick.getBalls()).hasSize(5);
    }
}
