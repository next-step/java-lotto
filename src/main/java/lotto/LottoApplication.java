package lotto;

import lotto.application.LottoService;
import lotto.console.LottoConsole;

public class LottoApplication {
    public static void main(String[] args) {
        LottoConsole.run(new LottoService());
    }
}
