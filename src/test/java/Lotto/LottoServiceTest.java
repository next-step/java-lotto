package Lotto;

import domain.Lotto;
import domain.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import policy.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoServiceTest {

    @Test
    @DisplayName("구입한 티켓 갯수에 맞춰 로또를 생성한다.")
    void generateLottoTest() {
        LottoService lottoService = new LottoService();

        List<Lotto> lotto = lottoService.generateLotto(2);

        assertThat(lotto.size()).isEqualTo(2);
    }

}
