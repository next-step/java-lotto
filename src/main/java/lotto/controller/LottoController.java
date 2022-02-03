package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Ticket;
import lotto.domain.WinningNumber;
import lotto.domain.lotto.LottoManager;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.machine.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        Ticket ticket = buyTicket();

        LottoManager lottoManager = new LottoManager(new RandomLottoGenerator(),
            ticket.getBuyCount());

        OutputView.printPurchaseAmount(ticket.getBuyCount());
        OutputView.printPurchaseTicket(lottoManager.getLottos());

        WinningNumber winningNumber = makeWinningNumber(InputView.writeWinningNumbers(), InputView.writeBonusBall());
    }

    public Ticket buyTicket() {
        int money = Integer.parseInt(InputView.writePurchaseAmount());
        return new Ticket(money);
    }

    public WinningNumber makeWinningNumber(String[] numbers, String bonus) {
        List<LottoNumber> lottoNumbers = Stream.of(numbers)
            .map(Integer::getInteger)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(bonus));

        return new WinningNumber(lottoNumbers, bonusNumber);
    }
}
