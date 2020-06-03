package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private List<Lotto> lottoList = new ArrayList<>();

    private List<Integer> winningNumberList = new ArrayList<>();
    private List<Prize> prizeList = new ArrayList<>();


    // default 1 to LOTTO_MAX_LIMIT
    private static List<Integer> lottoGameNumbers = new ArrayList<>();

    public LottoGame() {
        // ready
        for (int i = 1; i <= LOTTO_MAX_LIMIT; i++) {
            lottoGameNumbers.add(i);
        }
    }

    // buy
    public int getGameCountByPayMoney(Money payedMoney) {

        int gameCount = calculteGameCountByPayMoney(payedMoney.getPayedMoney());

        return gameCount;

    }

    private int calculteGameCountByPayMoney(int payMoney) {

        if (payMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
        return payMoney / LOTTO_PRICE;
    }


    // issue
    public void issueLotto(int gameCount) {

        for (int i = 0; i < gameCount; i++) {

            lottoList.add(Lotto.of(LOTTO_DRAW_LIMIT, lottoGameNumbers));
        }

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

        prizeList.add(Prize.of(3, 5_000));
        prizeList.add(Prize.of(4, 50_000));
        prizeList.add(Prize.of(5, 1_500_000));
        prizeList.add(Prize.of(6, 2_000_000_000));

        // ...

    }


    public List<Lotto> getLottoList() {
        List<Lotto> lottoList = this.lottoList;
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
            result = getMatchedCountAdd(result, eachNumber);
        }

        return result;
    }

    private int getMatchedCountAdd(int result, int eachNumber) {
        if (winningNumberList.contains(eachNumber)) {
            result++;
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

        int sum = prizeList.stream()
                .mapToInt(prize -> prize.getPrizeTotal())
                .sum();

        return sum / (lottoList.size() * LOTTO_PRICE);
    }


    public static List<Integer> getLottoGameNumbers() {
        return lottoGameNumbers;
    }


}
