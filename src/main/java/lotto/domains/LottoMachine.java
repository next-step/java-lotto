package lotto.domains;

import lotto.ui.InputUI;
import lotto.ui.OutputUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private final int LOTTO_PRICE = 1000;
    private int amount;
    private Lottos lottos;
    private LottoNumbers winningLottoNumber;

    public void buyLottos() {
        OutputUI.printInputPurchasingAmount();
        this.amount = InputUI.inputPurchasingAmount();
        this.lottos = makeLottos(new Cash(amount));
        OutputUI.printNumberOfPurchases(lottos.count());
        lottos.printLottosNumbers();
    }

    public Lottos makeLottos(Cash cash) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < cash.numberOfPurchasesAvailable(new Cash(LOTTO_PRICE)); i++) {
            lottoList.add(new Lotto());
        }
        return new Lottos(lottoList);
    }
    
    public void inputWinningNumber() {
        OutputUI.printInputWinningLottoNumbers();
        String winningNumbers = InputUI.inputWinnigNumbers();
        this.winningLottoNumber = new LottoNumbers(convertStringToList(winningNumbers));
    }

    public void printStatistics() {
        LottoStatistics lottoStatistics = lottos.getStatistics(winningLottoNumber);
        System.out.println("1 : "+lottoStatistics.count(1));
        System.out.println("2 : "+lottoStatistics.count(2));
        System.out.println("3 : "+lottoStatistics.count(3));
        System.out.println("4 : "+lottoStatistics.count(4));
        System.out.println("5 : "+lottoStatistics.count(5));
        System.out.println("6 : "+lottoStatistics.count(6));

        System.out.println("수익률 : " + lottoStatistics.totalPayout()/amount );
    }

    public List<Integer> convertStringToList(String data) {
        return Arrays.stream(data.split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }
}
