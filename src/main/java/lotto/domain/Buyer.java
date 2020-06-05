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
    private Map<Prize, List<Lotto>> winningList = new HashMap<>();

    public Buyer(int money) {
        this(money, new ArrayList<>());
    }

    public Buyer(int money, List<Lotto> lottoList) {
        this.money = money;
        this.lottoList = lottoList;

        initWinningList();
    }

    private void initWinningList() {
        winningList.put(Prize.FIRST, new ArrayList<>());
        winningList.put(Prize.SECOND, new ArrayList<>());
        winningList.put(Prize.THIRD, new ArrayList<>());
        winningList.put(Prize.FOURTH, new ArrayList<>());
        winningList.put(Prize.FIFTH, new ArrayList<>());
        winningList.put(Prize.MISS, new ArrayList<>());
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

    public void checkLotto(List<Integer> winningNumbers, int bonusNumber) {
        lottoList.forEach(lotto -> {
            Prize prize = lotto.getLottoPrize(winningNumbers, bonusNumber);
            putWinningList(prize, lotto);
        });
    }

    private void putWinningList(Prize prize, Lotto lotto) {
        if (prize.getMatchCount() >= WINNING_MIN_COUNT)
            winningList.get(prize).add(lotto);
    }

    public List<Integer> checkWin() {
        List<Integer> winCountList = new ArrayList();
        for (int i = WINNING_MIN_COUNT; i <= WINNING_MAX_COUNT; i++) {
            winCountList.add(winningList.get(i).size());
        }
        return winCountList;
    }

}
