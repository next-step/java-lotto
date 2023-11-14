package Lotto;

import domain.Lotto;
import domain.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoServiceTest {

    @Test
    @DisplayName("구입한 티켓 갯수에 맞춰 로또를 생성한다.")
    void generateLottoTest() {
        LottoService lottoService = new LottoService();

        List<Lotto> lotto = lottoService.generateLotto(2);

        for (Lotto lotto1 : lotto) {
            System.out.println("lotto1.getLottoNumbers() = " + lotto1.getLottoNumbers());
        }
        assertThat(lotto.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨 번호를 6개 미만으로 입력하는 경우 오류가 발생한다.")
    void invalidInputExceptionTest() {

    }
}
