package lotto.service;

import lotto.data.Lotto;
import lotto.data.LottoWinningPrice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.data.LottoWinningPrice.*;

public class LottoGame {
    private static final int LOTTO_PRICE = 1_000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int WINNING_PRICE_ZERO = 0;
    private static final int MATCHED_ZERO = 0;
    private static final int MATCHED = 1;

    private LottoGame() {
        //
    }

    public static List<Lotto> getLottoList(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoList.add(new Lotto());
        }

        return lottoList;
    }

    public static int getAmountOfLotto(int price) {
        return price / LOTTO_PRICE;
    }

    public static List<Integer> makeLottoNumberPool() {
        List<Integer> lottoNumberPool = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumberPool.add(i);
        }
        return lottoNumberPool;
    }

    public static int matchWinningNumbers(Lotto winningNumbers, Lotto lotto) {
        int matched = 0;
        for (Integer winningNumber : winningNumbers.getNumbers()) {
            matched += isMatched(lotto, winningNumber);
        }
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

    public static void checkWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요.");
        }

        List<Integer> distinctList = winningNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (distinctList.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    public static void checkBonusNumber(Lotto winningNumbers, int bonusNumer) {
        for (int winningNumber : winningNumbers.getNumbers()) {
            if (winningNumber == bonusNumer) {
                throw new IllegalArgumentException("중복된 번호가 있습니다.");
            }
        }
    }

    public static Map<LottoWinningPrice, Integer> getWinningNumberList(Lotto winningNumbers, int bonusNumber, List<Lotto> lottoList) {
        Map<LottoWinningPrice, Integer> winningNumberList = initWinningNumberList();
        for (Lotto lotto : lottoList) {
            LottoWinningPrice winningPriceByNumber = getLottoNumberByNumber(matchWinningNumbers(winningNumbers, lotto), matchBonusNumber(bonusNumber, lotto));
            winningNumberList.put(winningPriceByNumber, winningNumberList.get(winningPriceByNumber) + 1);
    }

    private static Map<LottoWinningPrice, Integer> initWinningNumberList() {
        Map<LottoWinningPrice, Integer> list = new HashMap<>();
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

    public static int getReturnAmount(int matchedWinningNumbers) {
        LottoWinningPrice lottoWinningPrice = getLottoNumberByNumber(matchedWinningNumbers);
        if (lottoWinningPrice.getWinningPrice() > 0) {
            return lottoWinningPrice.getWinningPrice();
        }

        return WINNING_PRICE_ZERO;
    }

    public static String getRateOfReturn(int returnAmount, int purchaseAmount) {
        double rateOfReturn = returnAmount / purchaseAmount;
        return String.format("%.2f", rateOfReturn);
    }
}
