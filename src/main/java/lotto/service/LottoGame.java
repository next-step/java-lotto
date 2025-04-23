package lotto.service;

import lotto.domain.*;
import lotto.view.input.InputViewInterface;
import lotto.view.message.Message;
import lotto.view.output.OutputViewInterface;
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
        int price = inputView.getValidatedNumberInput(
                value -> value > 0 && value % 1000 == 0,
                "1000원 단위의 양수를 입력해주세요."
        );
        Purchase paidMoney = new Purchase(price);

        outputView.printPrompt(Message.MANUAL_COUNT.getMessage());
        int manualCount = inputView.getNumberInput();
        List<List<LottoNumber>> manualNumbers = getManualNumbers(manualCount);

        int autoCount = (paidMoney.getPrice() - (manualCount * Lotto.PRICE)) / Lotto.PRICE;
        Lottos lottoTickets = Lottos.generate(manualNumbers, autoCount);
        outputView.printTicketCount(manualCount, autoCount);

        return lottoTickets;
    }

    private List<List<LottoNumber>> getManualNumbers(int count) {
        outputView.printPrompt(Message.MANUAL_NUMBERS.getMessage());
        return inputView.getManualLottoNumbers(count);
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

