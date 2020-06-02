package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

/*
 * LottoGame
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MAX_LIMIT = 45;
    private static final int LOTTO_DRAW_LIMIT = 6;
    private static final String FIXED_DELIMITER = ",|:| ";

    private static List<Integer> lottoGameNumbers = new ArrayList<>();
    private static List<Lotto> lottoList = new ArrayList<>();

    private static List<Integer> winningNumberList = new ArrayList<>();
    private static List<Prize> prizeList = new ArrayList<>();


    public LottoGame() {

        // ready
        List<Integer> lottoGameNumbers = new ArrayList<>();

        for (int i = 1; i < LOTTO_MAX_LIMIT; i++) {
            lottoGameNumbers.add(i);
        }

    }

    // buy
    public int buyLotto(String payMoney) {

        Number.checkNotNumber(payMoney);
        Number.checkNumber(payMoney);

        int gameCount = getGameCountByPayMoney(Integer.parseInt(payMoney));

        return gameCount;

    }

    // issue
    public void issueLotto(int gameCount) {

        for (int i = 0; i < gameCount; i++) {
            lottoList.add(Lotto.of(LOTTO_DRAW_LIMIT, lottoGameNumbers));
        }

    }

    private int getGameCountByPayMoney(int payMoney) {

        if (payMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
        return payMoney / LOTTO_PRICE;
    }

    public void checkWiningNumber(String winingNumber) {

        String[] winningNumberArray = winingNumber.split(FIXED_DELIMITER);

        if (winningNumberArray.length != LOTTO_DRAW_LIMIT) {
            throw new IllegalArgumentException("Not matched with draw limits. ");
        }

        Number.checkNotNumber(winningNumberArray);
        Number.checkNumber(winningNumberArray);

        winningNumberList = Arrays.stream(winningNumberArray)
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    public void makeRules() {

        prizeList.add(Prize.of(3, 5000));
        prizeList.add(Prize.of(4, 50000));
        prizeList.add(Prize.of(5, 1500000));
        prizeList.add(Prize.of(6, 2000000000));

        // ...

    }


    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public List<Prize> getPrizeList() {
        return prizeList;
    }


    public void matchingWinningNumbers() {

        lottoList.forEach(lotto -> {
                    int matchedNumber = getWinningcount(lotto);
                    addPrize(matchedNumber);
                }
        );

    }


    private int getWinningcount(Lotto lotto) {

        int result = 0;

        for (int eachNumber : lotto.getNumbers()) {
            if (winningNumberList.contains(eachNumber)) {
                result++;
            }
        }

        return result;
    }


    private void addPrize(int matchedNumber) {

        for (Prize prize : prizeList) {
            if (prize.getMatchedNumber() == matchedNumber) {
                prize.addCount(1);
            }
        }
    }


    public double totalResult() {

        int sum = prizeList.stream().mapToInt(prize -> prize.getPrizeTotal()).sum();
        return sum / (lottoList.size() * LOTTO_PRICE);
    }

    public List<Integer> getLottoGameNumbers() {
        return lottoGameNumbers;
    }

}
