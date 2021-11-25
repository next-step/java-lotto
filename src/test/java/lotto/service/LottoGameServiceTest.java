package lotto.service;

import lotto.domain.LottoGameCount;
import lotto.domain.Lottoes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameServiceTest {
    @Test
    @DisplayName("LottoGameService 생성자 테스트")
    public void constructor() {
        assertThat(new LottoGameService()).isEqualTo(new LottoGameService());
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    public void calculateYield() {
        LottoGameService lottoGameService = new LottoGameService(new LottoGameCount(10),
                new Lottoes(5000L));
        assertThat(lottoGameService.calculateYield()).isEqualTo(0.5);
    }
}
