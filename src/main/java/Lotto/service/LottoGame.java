package Lotto.service;

import Lotto.domain.Lotto;
import Lotto.domain.Lottos;
import Lotto.domain.LottoNumber;
import Lotto.domain.ResultStats;
import Lotto.view.input.InputViewInterface;
import Lotto.view.message.Message;
import Lotto.view.output.OutputViewInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGame {
    private final InputViewInterface inputView;
    private final OutputViewInterface outputView;

    public LottoGame(InputViewInterface inputView, OutputViewInterface outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Lottos lottos = generateAllLottos();
        outputView.printLottos(lottos);

        Set<LottoNumber> winningNumbers= getWinningTicket();
        LottoNumber bonusNumber = getBonusNumber();

        ResultStats result = lottos.getSummary(winningNumbers, bonusNumber);
        int totalSpent = lottos.size() * Lotto.PRICE;
        outputView.printResultStats(result, totalSpent);
    }

    private Lottos generateAllLottos() {
        outputView.printPrompt(Message.PAID_MONEY.getMessage());
        int paidMoney = inputView.getNumberInput();

        outputView.printPrompt(Message.MANUAL_COUNT.getMessage());
        int manualCount = inputView.getNumberInput();
        List<int[]> manualNumbers = getManualNumbers(manualCount);

        int autoCount = (paidMoney - (manualCount * Lotto.PRICE)) / Lotto.PRICE;
        Lottos lottoTickets = Lottos.generate(manualNumbers, autoCount);
        outputView.printTicketCount(manualCount, autoCount);

        return lottoTickets;
    }

    private List<int[]> getManualNumbers(int count) {
        outputView.printPrompt(Message.MANUAL_NUMBERS.getMessage());
        List<int[]> manualNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualNumbers.add(inputView.getNumberListInput());
        }
        return manualNumbers;
    }

    private Set<LottoNumber> getWinningTicket() {
        outputView.printPrompt(Message.WINNING_NUMBERS.getMessage());
        int[] winningNumbersArray = inputView.getNumberListInput();
        return Arrays.stream(winningNumbersArray)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    private LottoNumber getBonusNumber() {
        outputView.printPrompt(Message.BONUS_NUMBER.getMessage());
        int bonusNumber = inputView.getNumberInput();
        return LottoNumber.of(bonusNumber);
    }
}

