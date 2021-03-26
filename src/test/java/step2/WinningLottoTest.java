package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("지난 주 당첨번호 생성 테스트")
    void create_last_winning_lotto(){
        String input = "1,2,3,4,5,6";
        WinningLotto winningLotto = new WinningLotto(input);
        assertThat(winningLotto.getLottoNumberList().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("지난주 당첨번호와 로또 리스트와 비교하여 맞는 개수 리턴 테스트")
    void lotto_compare(){
        String winningNumbers = "1,2,3,4,5,6";
        String purchasedNumbers = "1,3,5,7,9,11";
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        Lotto purchasedLotto = new Lotto(purchasedNumbers);
        assertThat(winningLotto.getLottoNumberList().stream()
                .filter(winningNumber->purchasedLotto.getLottoNumberList().contains(winningNumber))
                .count()).isEqualTo(3);
    }

}
