package lotto.service;

import lotto.data.Lotto;
import lotto.data.LottoNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.data.LottoNumber.*;

public class LottoGame {
    private final static int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int WINNING_PRICE_ZERO = 0;

    private LottoGame(){
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

    public static int matchWinningNumbers(List<Integer> winningNumbers, Lotto lotto) {
        int matched = 0;
        for (Integer winningNumber : winningNumbers) {
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
        if(winningNumbers.size() != 6){
            throw new IllegalArgumentException("숫자 6개를 입력해주세요.");
        }

        List<Integer> distinctList = winningNumbers.stream().distinct().collect(Collectors.toList());
        if (distinctList.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    public static Map<Integer, Integer> getWinningNumberList(List<Integer> winningNumbers, List<Lotto> lottoList) {
        Map<Integer, Integer> winningNumberList = initWinningNumberList();
        for (Lotto lotto : lottoList) {
            int matched = matchWinningNumbers(winningNumbers, lotto);
            winningNumberList.put(matched, winningNumberList.get(matched) + 1);
        }

        return winningNumberList;
    }

    private static Map<Integer, Integer> initWinningNumberList() {
        Map<Integer, Integer> list = new HashMap<>();
        list.put(MATCHED_0.getMatchedNumber(), 0);
        list.put(MATCHED_1.getMatchedNumber(), 0);
        list.put(MATCHED_2.getMatchedNumber(), 0);
        list.put(MATCHED_3.getMatchedNumber(), 0);
        list.put(MATCHED_4.getMatchedNumber(), 0);
        list.put(MATCHED_5.getMatchedNumber(), 0);
        list.put(MATCHED_6.getMatchedNumber(), 0);

        return list;
    }

    public static int getAllReturnAmount(List<Integer> winningNumbers, List<Lotto> lottoList) {
        int returnAmount = 0;
        for (Lotto lotto : lottoList) {
            returnAmount += getReturnAmount(matchWinningNumbers(winningNumbers, lotto));
        }

        return returnAmount;
    }

    public static int getReturnAmount(int matchedWinningNumbers) {
        LottoNumber lottoNumber = getLottoNumberByNumber(matchedWinningNumbers);
        if (lottoNumber.getWinningPrice() > 0) {
            return lottoNumber.getWinningPrice();
        }

        return WINNING_PRICE_ZERO;
    }

    public static String getRateOfReturn(int returnAmount, int purchaseAmount) {
        double rateOfReturn = returnAmount / purchaseAmount;
        return String.format("%.2f", rateOfReturn);
    }
}
