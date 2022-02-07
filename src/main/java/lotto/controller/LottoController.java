package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Ticket;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRepository;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Rank;
import lotto.domain.machine.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        OutputView outputView = new OutputView();
        Ticket ticket = buyTicket();

        LottoRepository lottoManager = new LottoRepository(new RandomLottoGenerator(),
            ticket.getBuyCount());

        outputView.printPurchaseAmount(ticket.getBuyCount());
        outputView.printPurchaseTicket(lottoManager.getLottos());

        WinningNumber winningNumber = makeWinningNumber();

        WinningResult winningResult = new WinningResult(getRanksFrom(lottoManager, winningNumber));
        winningResult.calculateYield(ticket.getBuyCash());

        outputView.printWinningResult(winningResult);
    }

    public Ticket buyTicket() {
        int money = Integer.parseInt(InputView.writePurchaseAmount());
        return new Ticket(money);
    }

    private WinningNumber makeWinningNumber() {
        try {
            return new WinningNumber(makeSixNumbers(), makeBonusBall());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return makeWinningNumber();
        }
    }

    private Lotto makeSixNumbers() {
        return Lotto.from(InputView.writeWinningNumbers());
    }

    private LottoNumber makeBonusBall() {
        return new LottoNumber(InputView.writeBonusBall());
    }

    private List<Rank> getRanksFrom(LottoRepository lottoManager, WinningNumber winningNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lottoManager.getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

            ranks.add(winningNumber.compareTo(lottoNumbers));
        }

        return ranks;
    }
}
