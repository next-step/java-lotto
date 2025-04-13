package Lotto.service;

import Lotto.domain.Lotto;
import Lotto.domain.Lottos;
import Lotto.domain.LottoNumber;
import Lotto.domain.ResultStats;
import Lotto.view.InputViewInterface;
import Lotto.view.OutputViewInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGame {
    public static final String PAID_MONEY_MSG = "구입금액을 입력해 주세요.";
    public static final String WINNING_LOTTERY_NUMBERS_MSG = "\n지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBERS_MSG = "보너스 볼을 입력해 주세요.";
    public static final String MANUAL_TICKET_COUNT_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_TICKET_NUMBERS_MSG = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String DELIMITER = ",";

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
        outputView.printPrompt(PAID_MONEY_MSG);
        int paidMoney = inputView.getNumberInput();

        outputView.printPrompt(MANUAL_TICKET_COUNT_MSG);
        int manualCount = inputView.getNumberInput();
        List<int[]> manualNumbers = getManualNumbers(manualCount);

        int autoCount = (paidMoney - (manualCount * Lotto.PRICE)) / Lotto.PRICE;
        Lottos lottoTickets = Lottos.generate(manualNumbers, autoCount);
        outputView.printTicketCount(manualCount, autoCount);

        return lottoTickets;
    }

    private List<int[]> getManualNumbers(int count) {
        outputView.printPrompt(MANUAL_TICKET_NUMBERS_MSG);
        List<int[]> manualNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualNumbers.add(inputView.getNumberListInput(DELIMITER));
        }
        return manualNumbers;
    }

    private Set<LottoNumber> getWinningTicket() {
        outputView.printPrompt(WINNING_LOTTERY_NUMBERS_MSG);
        int[] winningNumbersArray = inputView.getNumberListInput(DELIMITER);
        return Arrays.stream(winningNumbersArray)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    private LottoNumber getBonusNumber() {
        outputView.printPrompt(BONUS_NUMBERS_MSG);
        int bonusNumber = inputView.getNumberInput();
        return LottoNumber.of(bonusNumber);
    }
}

