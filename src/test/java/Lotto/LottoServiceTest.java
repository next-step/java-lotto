package Lotto;

import domain.Lotto;
import domain.LottoNumber;
import domain.LottoService;
import domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.LottoNumberValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoServiceTest {

    @Test
    @DisplayName("구입한 티켓 갯수에 맞춰 로또를 생성한다.")
    void generateLottoTest() {
        LottoService lottoService = new LottoService();

        List<Lotto> lottoTicket = lottoService.generateLotto(2000);

        for (Lotto lotto1 : lottoTicket) {
            System.out.println("lotto1.getLottoNumbers() = " + lotto1.getLottoNumbers());
        }
        assertThat(lottoTicket.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨 번호를 6개 미만으로 입력하는 경우 오류가 발생한다.")
    void invalidInputExceptionTest() {
        LottoService lottoService = new LottoService();

        assertThrows(IllegalArgumentException.class, () -> lottoService.generateWinningInfo("1,2,3,4, 5"));
    }

    @Test
    @DisplayName("ArrayList()의 Contains 함수를 활용하여 당첨 번호를 체크한다.")
    void matchWinningNumbers() {
        Lotto lotto1 = new Lotto("1, 2,3,4,5,6");

        LottoService lottoService = new LottoService();
        String winningInput = "1, 2, 3, 4, 5, 6";
        WinningLotto winningLotto = lottoService.generateWinningInfo(winningInput);


        int count = 0;
        for (Integer num : lotto1.getLottoNumbers()) {
            if (winningLotto.getWinnerNumbers().contains(num)) {
                count++;
            }
        }
        assertThat(count).isEqualTo(6);
    }
}
