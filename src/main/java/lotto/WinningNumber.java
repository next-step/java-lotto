package lotto;

import java.util.*;

public class WinningNumber {
    private static final int MINIMUM_VALUE = 6;
    private Set<Integer> winningLotto;

    public WinningNumber(String data) {
        winningLotto = toNumbersSet(data);
    }

    public Map<LottoType, Integer> match(List<Lotto> purchasLottos) {
        Map<LottoType, Integer> winnings = new HashMap<>();
        for (Lotto lotto : purchasLottos) {
            lotto.countbyComparingNumbers(winningLotto);
            increaseWinningCount(winnings, lotto);
        }
        return winnings;
    }

    private void increaseWinningCount(Map<LottoType, Integer> winnings, Lotto lotto) {
        if (lotto.isWinning()) {
            LottoType lottoType = lotto.findLottoType();
            winnings.compute(lottoType, (key, winningCount) -> winningCount == null ? 1 : winningCount + 1);
        }
    }

    private Set<Integer> toNumbersSet(String data) {
        Set<Integer> numberSet = new HashSet<>();
        String[] datas = splitData(data);
        if (checkMinimum(datas))
            throw new IllegalArgumentException(MINIMUM_VALUE + "자리를 입력 하셔야 합니다.");

        for (String number : datas) {
            numberSet.add(Integer.parseInt(number));
        }
        return numberSet;
    }

    private boolean checkMinimum(String[] datas) {
        return MINIMUM_VALUE != datas.length;
    }

    private String[] splitData(String data) {
        return data.split(", ");
    }
}
