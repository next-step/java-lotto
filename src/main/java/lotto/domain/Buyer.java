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
    private Map<Integer, List<Lotto>> winningList = new HashMap<>();

    public Buyer(int money) {
        this(money, new ArrayList<>());
    }

    public Buyer(int money, List<Lotto> lottoList) {
        this.money = money;
        this.lottoList = lottoList;

        initWinningList();
    }

    private void initWinningList() {
        winningList.put(3, new ArrayList<>());
        winningList.put(4, new ArrayList<>());
        winningList.put(5, new ArrayList<>());
        winningList.put(6, new ArrayList<>());
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

    public void checkLotto(List<Integer> winningNumbers) {
        lottoList.forEach(lotto -> {
            int rightNumberCount = lotto.checkRightNumberCount(winningNumbers);
            putWinningList(rightNumberCount, lotto);
        });
    }

    private void putWinningList(int rightNumberCount, Lotto lotto) {
        if (rightNumberCount >= WINNING_MIN_COUNT)
            winningList.get(rightNumberCount).add(lotto);
    }

    public List<Integer> checkWin() {
        List<Integer> winCountList = new ArrayList();
        for (int i = WINNING_MIN_COUNT; i <= WINNING_MAX_COUNT; i++) {
            winCountList.add(winningList.get(i).size());
        }
        return winCountList;
    }


}
