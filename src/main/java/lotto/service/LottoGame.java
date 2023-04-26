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
            matched = getMatched(lotto, matched, winningNumber);
        }

        return matched;
    }

    private static int getMatched(Lotto lotto, int matched, Integer winningNumber) {
        if (lotto.getNumbers().contains(winningNumber)) {
            matched++;
        }
        return matched;
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

    public static Map<LottoWinningPrice, Integer> getWinningNumberList(Lotto winningNumbers, List<Lotto> lottoList) {
        Map<LottoWinningPrice, Integer> winningNumberList = initWinningNumberList();
        for (Lotto lotto : lottoList) {
            int matched = matchWinningNumbers(winningNumbers, lotto);
            winningNumberList.put(LottoWinningPrice.getLottoNumberByNumber(matched), winningNumberList.get(LottoWinningPrice.getLottoNumberByNumber(matched)) + 1);
        }

        return winningNumberList;
    }

    private static Map<LottoWinningPrice, Integer> initWinningNumberList() {
        Map<LottoWinningPrice, Integer> list = new HashMap<>();
        for(LottoWinningPrice lottoWinningPrice : LottoWinningPrice.values()){
            list.put(lottoWinningPrice, 0);
        }

        return list;
    }

    public static int getAllReturnAmount(Lotto winningNumbers, List<Lotto> lottoList) {
        int returnAmount = 0;
        for (Lotto lotto : lottoList) {
            returnAmount += getReturnAmount(matchWinningNumbers(winningNumbers, lotto));
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
