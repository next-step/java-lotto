package lotto.auto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoHandler {

    private final String SPLIT_STRING = ", ";
    private final int LOTTO_PRICE = 1000;

    public int buyLotto(String money) {
        return Integer.parseInt(money) / LOTTO_PRICE;
    }
    public List<Lotto> createLotto(int count) {
        List<Lotto> lottos = new ArrayList<>(count);
        for(int i = 0; i < count; i ++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public List<Integer> compareWinNumbers(String winNumbers) {
        return split(winNumbers);
    }

    public List<Win> confirmWinner(List<Lotto> lottos, List<Integer> winNumbers) {
        List<Win> wins = new ArrayList<>();
        for (Lotto lotto : lottos) {
            wins.add(lotto.checkWin(winNumbers));
        }
        return wins;
    }

    public Double getReturn(String money, List<Win> wins) {
        int winMoney = 0;
        for (Win win : wins) {
            winMoney += (win.getReward());
        }
        return (double) (winMoney / Double.parseDouble(money));
    }

    private List<Integer> split(String value) {
        String[] result = value.split(SPLIT_STRING);
        return Arrays.stream(result).map(Integer::parseInt).collect(Collectors.toList());
    }
}
