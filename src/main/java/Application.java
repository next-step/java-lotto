import lotto.LottoGame;
import lotto.ui.Input;
import lotto.ui.LottoInput;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        LottoInput lottoInput = new LottoInput(new ScannerInput());
        LottoGame lottoGame = new LottoGame(lottoInput.inputPrincipal());

        int manualLottoCount = lottoInput.inputManualLottoCount();

        lottoGame.setManualLottoCount(manualLottoCount);
        lottoGame.buyManual(lottoInput.inputManualLottoList(manualLottoCount));
        lottoGame.buyAuto();

        lottoGame.winning(lottoInput.inputLottoResult());
    }

    static class ScannerInput implements Input {

        static Scanner scanner = new Scanner(System.in);

        @Override
        public int nextInt() {
            return scanner.nextInt();
        }

        @Override
        public String nextLine() {
            scanner.nextLine();
            return scanner.nextLine();
        }
    }
}
