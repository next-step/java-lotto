package step2.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * LottoGame
 * ver. 1.0
 * 2020.05.31

 */
public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static final String FIXED_DELIMITER = ",|:";

    private List<Lotto> lottoList = new ArrayList<>();
    private Lotto winningNumberLotto = Lotto.getInstance();

    private List<Prize> prizeList = new ArrayList<>();

    // pay
    public int calculateGameCountByPayMoney(Money money) {

        if (money.getPayedMoney() % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
        return money.getPayedMoney() / LOTTO_PRICE;
    }

    public void issueLotto(int gameCount) {
        lottoList = Lotto.issueLotto(gameCount);
    }


    public void checkWiningNumber(String winingNumber) {
        String[] winningNumberArray = winingNumber.split(FIXED_DELIMITER);
        winningNumberLotto = Lotto.checkWiningNumber(winningNumberArray);

    }

    public void makeRules() {

        prizeList.add(Prize.of(0, 0));
        prizeList.add(Prize.of(1, 0));
        prizeList.add(Prize.of(2, 0));
        prizeList.add(Prize.of(3, 5_000));
        prizeList.add(Prize.of(4, 50_000));
        prizeList.add(Prize.of(5, 1_500_000));
        prizeList.add(Prize.of(6, 2_000_000_000));

    }


    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(this.lottoList);
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

        return (int) lotto.getNumbers().stream()
                .filter(lottoX ->
                        isPresentWinningNumber(lottoX))
                .count();
    }


    private boolean isPresentWinningNumber(Integer lottoX) {
        return winningNumberLotto.getNumbers()
                .stream()
                .filter(x -> x == lottoX)
                .findFirst()
                .isPresent();
    }


    private void addPrize(int matchedNumber) {

        Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchedNumber() == matchedNumber)
                .findFirst()
                .get()
                .addWinning();

    }


    public BigDecimal totalResult() {

        // winningResult
        BigDecimal sum = BigDecimal.valueOf(prizeList.stream()
                .mapToLong(prize -> prize.getPrizeTotal())
                .sum());

        return sum.divide(BigDecimal.valueOf(lottoList.size() * LOTTO_PRICE), 3, BigDecimal.ROUND_HALF_EVEN);
    }

}
