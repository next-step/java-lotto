package lotto.domain;

import lotto.NumberInputScanner;
import lotto.StringInputScanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer {

    private int money;
    private int manualCount;
    private List<Lotto> lottoList;
    private Map<Prize, Integer> winningList = new HashMap<>();
    LottoMachine lottoMachine;

    public Buyer(int money) {
        this(money, 0);
    }

    public Buyer(int money, int manualCount) {
        this(money, manualCount, new ArrayList<>());
    }

    public Buyer(int money, int manualCount, List<Lotto> lottoList) {
        this.money = money;
        this.manualCount = manualCount;
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

    public void buyLotto() {
        lottoMachine = new LottoMachine(this.money, manualCount);
        lottoList = lottoMachine.generateLotto();
    }

    public int getAutoLottoCount() {
        return lottoMachine.getAutoLottoCount();
    }

    public int getManualLottoCount() {
        return lottoMachine.getManualLottoCount();
    }

    public List<List<LottoNo>> getLottoListNumbers() {
        List<List<LottoNo>> lottoListNumbers = new ArrayList<>();

        lottoList.stream().forEach(lotto -> {
            lottoListNumbers.add(lotto.getLottoNumber());
        });

        return lottoListNumbers;
    }

    public Map<Prize, Integer> checkLotto(List<LottoNo> winningNumbers, LottoNo bonusNumber) {

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
