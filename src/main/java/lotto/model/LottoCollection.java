package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoCollection {
    private final List<List<Integer>> lottos;

    public LottoCollection(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public List<Integer> checkWinningNumber(String[] winningNumber) {
        List<Integer> inventory = new ArrayList<>();
        for (List<Integer> lotto : lottos) {
            inventory.add(countMatchingNumber(winningNumber, lotto));
        }

        return inventory;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    private int countMatchingNumber(String[] winningNumber, List<Integer> lotto) {
        int matchingWinningNumber = 0;
        for (Integer lottoNumber : lotto) {
            matchingWinningNumber = getMatchingNumber(winningNumber, matchingWinningNumber, lottoNumber);
        }

        return matchingWinningNumber;
    }

    private int getMatchingNumber(String[] winningNumber, int matchingCount, Integer lottoNumber) {
        for (String string : winningNumber) {
            matchingCount = addNumberCount(matchingCount, lottoNumber, string);
        }
        return matchingCount;
    }

    private int addNumberCount(int matchingToWinningNumber, Integer integer, String string) {
        if (isWinningNumber(integer, string)) {
            matchingToWinningNumber++;
        }
        return matchingToWinningNumber;
    }

    private boolean isWinningNumber(Integer integer, String string) {
        return Integer.parseInt(string) == integer;
    }
}
