package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer {

    private static final int WINNING_MIN_COUNT = 3;
    private static final int WINNING_MAX_COUNT = 6;

    private int money;
    private List<Lotto> lottoList;
    private Map<Integer, List<Lotto>> winningList = new HashMap<>();

    public Buyer(int money) {
        this(money, new ArrayList<>());
    }

    public Buyer(int money, List<Lotto> lottoList) {
        this.money = money;
        this.lottoList = lottoList;

        winningListInit();
    }

    private void winningListInit() {
        winningList.put(3, new ArrayList<>());
        winningList.put(4, new ArrayList<>());
        winningList.put(5, new ArrayList<>());
        winningList.put(6, new ArrayList<>());
    }

    public void buyAutoLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        int count = this.money / 1000;
        for(int i=0 ; i < count ; i++){
            lottoList.add(lottoMachine.generateLotto(new ArrayList<>(new RandomLottoNumber().generateNumber())));
        }
    }

    public int getLottoCount() {
        return lottoList.size();
    }

    public String getLottoListNumber() {
        StringBuffer stringBuffer = new StringBuffer();
        lottoList.stream().forEach(lotto -> {
            stringBuffer.append(lotto.getLottoNumber());
            stringBuffer.append("\n");
        });
        return stringBuffer.toString();
    }

    public void checkLotto(List<Integer> winningNumbers) {
        lottoList.forEach(lotto -> {
            int rightNumberCount = lotto.checkRightNumberCount(winningNumbers);
            putWinningList(rightNumberCount, lotto);
        });
    }

    private void putWinningList(int rightNumberCount, Lotto lotto) {
        if(rightNumberCount >= WINNING_MIN_COUNT)
            winningList.get(rightNumberCount).add(lotto);
    }

    public ArrayList checkWin() {
        ArrayList winCountList = new ArrayList();
        for(int i = WINNING_MIN_COUNT ; i <= WINNING_MAX_COUNT ; i++) {
            winCountList.add(winningList.get(i).size());
        }
        return winCountList;
    }


}
