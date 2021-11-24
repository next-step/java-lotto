package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ShopTest {

    private static final int PRICE = 1000;

    @ValueSource(ints = {14000, 1000, 100})
    @ParameterizedTest(name = "[{argumentsWithNames}] 로또가격은 개당 1000원으로, 금액에 맞는 갯수가 발행된다.")
    void buyTest(int input) throws NoSuchFieldException, IllegalAccessException {
        Shop shop = new Shop();
        shop.buy(14000, new LottoRandomMachine());

        LottoTickets lotteries = shop.buy(input, new LottoRandomMachine());

        List<LottoTicket> tickets = getTicketsByReflection(lotteries);

        assertThat(tickets.size()).isEqualTo(input / PRICE);
    }


    @SuppressWarnings("unchecked")
    private List<LottoTicket> getTicketsByReflection(LottoTickets lottoTickets)
        throws NoSuchFieldException, IllegalAccessException {
        Field lotteryField = LottoTickets.class.getDeclaredField("tickets");
        lotteryField.setAccessible(true);
        return (List<LottoTicket>) lotteryField.get(lottoTickets);
    }

}
