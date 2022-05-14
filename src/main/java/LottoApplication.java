import domain.LottoMachine;
import domain.Lottos;
import domain.RandomSelectRule;
import view.InputView;

import java.util.Scanner;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        inputView.scanCashWithAnnouncement();
        LottoMachine lottoMachine = new LottoMachine(new RandomSelectRule());
        Lottos lottos = lottoMachine.issue(inputView.getCash());
        InputView.printLottos(lottos);
    }
}
