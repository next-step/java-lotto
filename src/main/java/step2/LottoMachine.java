package step2;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoMachine {

    private List<Lotto> lottos;

    public LottoMachine() {
        try (Scanner scanner = new Scanner(System.in)) {
            InputView inputView = new InputView(scanner);
            makeLotto(inputView.askPurchaseAmount());
            ResultView.showLottoUnitCount(lottos.size());
            ResultView.showLottoUnitDetail(lottos);
        }
    }

    private void makeLotto(String askPurchaseAmount) {
        LottoPrice lottoPrice = new LottoPrice(askPurchaseAmount);
        this.lottos = LottoGenerator.publish(lottoPrice.getAvailableForPurchaseCount());
    }

    public static void main(String[] args) {
        new LottoMachine();
    }
}
