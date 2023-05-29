package lotto.service;

import lotto.data.Lotto;
import lotto.data.LottoCount;
import lotto.data.LottoWinningPrice;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.data.LottoWinningPrice.getLottoNumberByNumber;

public class LottoGame {
    private static final int MATCHED_ZERO = 0;
    private static final int MATCHED = 1;

    private LottoGame() {
        //
    }

    public static int matchWinningNumbers(Lotto winningNumbers, Lotto lotto) {
        int matched = 0;
        for (Integer winningNumber : winningNumbers.getNumbers()) {
            matched += isMatched(lotto, winningNumber);
        }

        return matched;
    }

    public static boolean matchBonusNumber(int bonusNumber, Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return true;
        }

        return false;
    }

    private static int isMatched(Lotto lotto, Integer winningNumber) {
        if (lotto.getNumbers().contains(winningNumber)) {
            return MATCHED;
        }
        return MATCHED_ZERO;
    }

    public static Map<LottoWinningPrice, Integer> getWinningNumberList(Lotto winningNumbers, int bonusNumber, List<Lotto> lottoList) {
        Map<LottoWinningPrice, Integer> winningNumberList = initWinningNumberList();
        for (Lotto lotto : lottoList) {
            LottoWinningPrice winningPriceByNumber = getLottoNumberByNumber(matchWinningNumbers(winningNumbers, lotto), matchBonusNumber(bonusNumber, lotto));
            winningNumberList.put(winningPriceByNumber, winningNumberList.get(winningPriceByNumber) + 1);
        }

        return winningNumberList;
    }

    public static Map<LottoWinningPrice, Integer> initWinningNumberList() {
        Map<LottoWinningPrice, Integer> list = new TreeMap<>();
        for (LottoWinningPrice lottoWinningPrice : LottoWinningPrice.values()) {
            list.put(lottoWinningPrice, 0);
        }

        return list;
    }

    public static int getAllReturnAmount(Map<LottoWinningPrice, Integer> winningNumberList) {
        int returnAmount = 0;

        for (LottoWinningPrice price : winningNumberList.keySet()) {
            returnAmount += price.getWinningPrice() * winningNumberList.get(price);
        }

        return returnAmount;
    }

    public static String getRateOfReturn(int returnAmount, int purchaseAmount) {
        double rateOfReturn = returnAmount / purchaseAmount;
        return String.format("%.2f", rateOfReturn);
    }
}
