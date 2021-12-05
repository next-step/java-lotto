package lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.Collections;
import lotto.domain.LottoRandomMachine;
import lotto.domain.LottoTickets;
import lotto.domain.Wallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AssignPreTicketTest {

    @Test
    @DisplayName("AssignPreTicket내 buy를 이용한 생성시, 금액이 정상적으로 차감되어야 한다.")
    void buyTest() throws NoSuchFieldException, IllegalAccessException {
        AssignPreTicket assignPreTicket = AssignPreTicket.buy(new Wallet(10000), 3);

        Wallet walletByReflection = getWalletByReflection(assignPreTicket);

        assertThat(assignPreTicket.getAssignCount()).isEqualTo(3);
        assertThat(walletByReflection).isEqualTo(new Wallet(7000));
    }

    @Test
    @DisplayName("로또 티켓이 정상적으로 구매되는지 확인한다.")
    void getAllBuyTickets() {
        AssignPreTicket assignPreTicket = AssignPreTicket.buy(new Wallet(10000), 0);

        BuyTickets allBuyTickets = assignPreTicket.getAllBuyTickets(
            new LottoTickets(Collections.emptyList()),
            new LottoRandomMachine());

        assertThat(allBuyTickets.getAllTicket().getTicketSize()).isEqualTo(10);
        assertThat(allBuyTickets.getAssignTicketSize()).isEqualTo(0);
        assertThat(allBuyTickets.getRandomTicketSize()).isEqualTo(10);
    }


    private Wallet getWalletByReflection(AssignPreTicket assignPreTicket)
        throws NoSuchFieldException, IllegalAccessException {
        Field assignPreTicketField = AssignPreTicket.class.getDeclaredField("wallet");
        assignPreTicketField.setAccessible(true);
        return (Wallet) assignPreTicketField.get(assignPreTicket);
    }

}