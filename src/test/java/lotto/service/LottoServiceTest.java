package lotto.service;

import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.TesterLottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    private LottoService lottoService;
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoService = new LottoService();
        lottoGenerator = new TesterLottoGenerator();
    }

    @DisplayName("로또 생성 테스트 : count 사이즈만큼 로또가 생성되는지 확인")
    @Test
    void issueLottos() {
        int count = 5;
        Lottos lottos = lottoService.issueLottos(count, lottoGenerator);

        assertThat(lottos.size()).isEqualTo(count);
    }
}
