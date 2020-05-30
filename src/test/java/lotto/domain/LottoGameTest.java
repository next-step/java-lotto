package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        PurchasePrice purchasePrice = PurchasePrice.newInstance(5000);
        List<LottoTicket> manualTickets = Arrays.asList(
                LottoTicketFactory.createManualLottoTicket("1, 2, 3, 13, 14, 15"),
                LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 14, 15"),
                LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 5, 15"),
                LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 5, 7"),
                LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 5, 6")
        );

        this.lottoGame = new LottoGame(PurchaseInfo.newInstance(purchasePrice, manualTickets));
    }

    @DisplayName("구입정보가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLottoGameIfPurchaseInfoIsNull() {
        assertThatThrownBy(() -> new LottoGame(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoGame을 생성할 수 있다.")
    @Test
    void canCreateLottoGame() {
        assertThat(this.lottoGame).isInstanceOf(LottoGame.class);
    }

    @DisplayName("자동 로또 번호를 생성할 수 있다.")
    @Test
    void canCreateLottoNumbers() {
        LottoTickets lottoTickets = this.lottoGame.createAutoLottoTickets();

        assertThat(lottoTickets).isInstanceOf(LottoTickets.class);
        assertThat(lottoTickets.getCountByCreationType(CreationType.MANUAL)).isEqualTo(5);
    }

    @DisplayName("로또 당첨 결과를 얻을 수 있다.")
    @Test
    void canCreateLottoMatchResult() {
        LottoTicket winLottoTicket = LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = LottoNumber.newBonusNumber(7, winLottoTicket);
        LottoMatchResult lottoMatchResult = this.lottoGame.calculateMatchCount(winLottoTicket, bonusNumber);

        assertThat(lottoMatchResult).isInstanceOf(LottoMatchResult.class);
    }
}
