package lotto;

import lotto.application.LottoService;
import lotto.domain.matcher.LottoMatcher;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.LottoTickets;
import lotto.ui.*;

public class Application {

    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(lottoMachineDto(), lottoService());
    }

    public static LottoTickets lottoTickets() {
        return new LottoTickets();
    }

    public static LottoMatcher lottoGame() {
        return new LottoMatcher(lottoTickets());
    }

    public static LottoService lottoService() {
        return new LottoService(lottoMachine(), lottoGame());
    }

    public static LottoMachine lottoMachine() {
        return new LottoMachine(lottoMachineDto());
    }

    private static LottoMachineDto lottoMachineDto() {
        return InputView.lottoMachineDto();
    }

    private static WinningRequestDto winningRequestDto() {
        return null;
    }

}
