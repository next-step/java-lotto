package lotto.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Ticket;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoManager;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Rank;
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

        WinningNumber winningNumber = makeWinningNumber();

        WinningResult winningResult = new WinningResult(getRanksFrom(lottoManager, winningNumber));
        winningResult.calculateYield(ticket.getBuyCash());

        OutputView.printWinningResult(winningResult);
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

    private List<Rank> getRanksFrom(LottoManager lottoManager, WinningNumber winningNumber) {
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
