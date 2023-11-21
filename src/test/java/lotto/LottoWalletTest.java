package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWalletTest {

    @DisplayName("입력한 개수만큼의 로또 저장한다.")
    @Test
    void saveLottoAsYouWant() {
        Lotto lotto1 = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Stream.of(6, 5, 4, 3, 2, 1)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        LottoWallet lottoWallet = LottoWallet.of(List.of(lotto1, lotto2), 2);
        assertThat(lottoWallet.totalTicketCount()).isEqualTo(2);
    }

    @DisplayName("저장한 로또중 한장을 준다.")
    @Test
    void returnLottoTicketAsYouWant() {
        Lotto lotto1 = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Stream.of(6, 5, 4, 3, 2, 1)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        LottoWallet lottoWallet = LottoWallet.of(List.of(lotto1, lotto2), 2);

        assertThat(lottoWallet.oneTicket(1)).isEqualTo(lotto2);
    }

}
