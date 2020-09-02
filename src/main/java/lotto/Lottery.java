package lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Lottery {

    public static final Map<Integer, Integer> prize = new LinkedHashMap<>();
    static {
        prize.put(3, 5_000);
        prize.put(4, 50_000);
        prize.put(5, 1_500_000);
        prize.put(6, 2_000_000_000);
    }

    public static final int price = 1000;

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
