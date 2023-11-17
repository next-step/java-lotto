package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWalletTest {

    @DisplayName("입력한 개수만큼의 로또 저장한다.")
    @Test
    void saveLottoAsYouWant() {
        LottoWallet lottoWallet = LottoWallet.from(1);
        lottoWallet.saveLotto(new Lotto(Collections.emptyList()));
        assertThat(lottoWallet.remainTicketsCount()).isEqualTo(2);
    }

    @DisplayName("저장한 로또중 한장을 준다.")
    @Test
    void returnLottoTicketAsYouWant() {
        LottoWallet lottoWallet = LottoWallet.from(1);

        Lotto expectedTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoWallet.saveLotto(expectedTicket);

        assertThat(lottoWallet.oneTicket(1)).isEqualTo(expectedTicket);
    }

}
