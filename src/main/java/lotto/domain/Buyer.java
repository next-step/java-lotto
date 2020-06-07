package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer {

    private static final int WINNING_MIN_COUNT = 3;
    private static final int WINNING_MAX_COUNT = 6;
    private static final int LOTTO_PRIZE = 1000;

    private int money;
    private List<Lotto> lottoList;
    private Map<Prize, Integer> winningList = new HashMap<>();

    public Buyer(int money) {
        this(money, new ArrayList<>());
    }

    public Buyer(int money, List<Lotto> lottoList) {
        this.money = money;
        this.lottoList = lottoList;

        initWinningList();
    }

    private void initWinningList() {
        winningList.put(Prize.FIRST, 0);
        winningList.put(Prize.SECOND, 0);
        winningList.put(Prize.THIRD, 0);
        winningList.put(Prize.FOURTH, 0);
        winningList.put(Prize.FIFTH, 0);
        winningList.put(Prize.MISS, 0);
    }

    public void buyAutoLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        int count = this.money / LOTTO_PRIZE;
        for (int i = 0; i < count; i++) {
            lottoList.add(lottoMachine.generateLotto(new ArrayList<>(new RandomLottoNumber().generateNumber())));
        }
    }

    public int getLottoCount() {
        return lottoList.size();
    }

    public List<List<Integer>> getLottoListNumbers() {
        List<List<Integer>> lottoListNumbers = new ArrayList<>();

        lottoList.stream().forEach(lotto -> {
            lottoListNumbers.add(lotto.getLottoNumber());
        });

        return lottoListNumbers;
    }

    public Map<Prize, Integer> checkLotto(List<Integer> winningNumbers, int bonusNumber) {

        lottoList.forEach(lotto -> {
            Prize prize = lotto.getLottoPrize(winningNumbers, bonusNumber);
            putWinningList(prize);
        });

        return winningList;
    }

    private void putWinningList(Prize prize) {
        winningList.computeIfPresent(prize, (prizeKey, value) -> ++value);
    }
}
