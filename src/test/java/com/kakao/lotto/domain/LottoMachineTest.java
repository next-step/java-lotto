package com.kakao.lotto.domain;

import com.kakao.lotto.supportInfo.PurchaseInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoMachineTest {

    @Test
    @DisplayName("로또 생성기에서는 로또 금액만큼의 로또 티켓을 생성한다.")
    void makeRandomLottoTicketSize() {
        LottoMachine lottoMachine = new LottoMachine(new PurchaseInfo(15000));
        LottoTickets lottoTickets = lottoMachine.makeLottoTickets();
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(15);
    }

    @Test
    @DisplayName("로또 생성기에서는 수동으로 지정한 로또 티켓 생성도 가능하다.")
    void makePickedLottoTicketSize() {
        List<List<Integer>> pickedLotteries = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoMachine lottoMachine = new LottoMachine(new PurchaseInfo(2000, pickedLotteries));

        LottoTickets lottoTickets = lottoMachine.makeLottoTickets();

        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 생성기에서 수동으로 로또 티켓을 구입하는 경우 가능한 돈보다 더 많은 숫자를 찍으면 안된다.")
    void getTicketWithPickedLotteriesErrors() {
        List<List<Integer>> pickedLotteries = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6));
        PurchaseInfo purchaseInfo = new PurchaseInfo(1500, pickedLotteries);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMachine(purchaseInfo));
    }

}
