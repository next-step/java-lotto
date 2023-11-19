package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWalletTest {

    @DisplayName("입력한 개수만큼의 로또 저장한다.")
    @Test
    void saveLottoAsYouWant() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        LottoWallet lottoWallet = LottoWallet.from(List.of(lotto1, lotto2));
        assertThat(lottoWallet.totalTicketCount()).isEqualTo(2);
    }

    @DisplayName("저장한 로또중 한장을 준다.")
    @Test
    void returnLottoTicketAsYouWant() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        LottoWallet lottoWallet = LottoWallet.from(List.of(lotto1, lotto2));

        assertThat(lottoWallet.oneTicket(1)).isEqualTo(lotto2);
    }

}
