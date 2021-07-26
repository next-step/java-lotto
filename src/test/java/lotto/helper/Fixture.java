package lotto.helper;

import lotto.lotto.LottoTickets;
import lotto.money.Money;
import lotto.money.PaymentInfo;
import lotto.number.WinningNumbers;

import java.util.Arrays;

public class Fixture {
    private Fixture() {}

    public static LottoTickets lottoTickets() {
        return LottoTickets.from(
                Arrays.asList(
                        Generator.lottoTicket(5, 10, 15, 20, 25, 30),
                        Generator.lottoTicket(5, 10, 15, 20, 25, 31),
                        Generator.lottoTicket(5, 10, 15, 20, 25, 32),
                        Generator.lottoTicket(5, 10, 15, 20, 26, 31),
                        Generator.lottoTicket(5, 10, 15, 21, 26, 31),
                        Generator.lottoTicket(5, 10, 16, 21, 26, 31)
                )
        );
    }

    public static WinningNumbers winningNumbers() {
        return Generator.winningNumbers(31, 5, 10, 15, 20, 25, 30);
    }

    public static PaymentInfo paymentInfo() {
        return PaymentInfo.of(Money.from(1000), Generator.autoLottoTickets(1));
    }
}
