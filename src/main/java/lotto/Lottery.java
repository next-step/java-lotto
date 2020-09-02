package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    public static void main(String[] args) {
        int ticketCount = InputView.getPurchaseCount();
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<ticketCount; i++){
            lottoList.add(new Lotto());
        }
        ResultView.printLotto(lottoList);

        Integer[] winningNumbers = InputView.getWinningNumbers();
        ResultView.printResultStatus(lottoList, winningNumbers);
    }
}
