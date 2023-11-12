package lottoauto.domain.aggregate;

import lottoauto.domain.lotto.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Aggregator {

    private final Map<Integer, Integer> priceBoard;
    private final WinnerBoard winnerBoard;
    private final List<Lotto> lottoList;

    private static final int EACH_LOTTO_PRICE = 1000;

    public Aggregator(List<Lotto> lottoList) {
        this.priceBoard = Map.of(
                3, 5000,
                4, 50000,
                5, 1500000,
                6, 2000000000
        );
        winnerBoard = new WinnerBoard();
        this.lottoList = lottoList;
    }

    public void checkWinnerLotto(String winNumbersString) {
        List<Integer> winNumbers = Arrays.stream(winNumbersString.split(","))
                .map(strNumber -> {
                    int number = Integer.parseInt(strNumber.strip());
                    if (number > 45 || number < 1) {
                        throw new IllegalArgumentException("적절하지 않은 당첨 번호 입니다.");
                    }
                    return number;
                })
                .collect(Collectors.toList());

        System.out.println("winNumbers " + winNumbers);

        for (Lotto lotto : lottoList) {
            int winNumber = lotto.getLottoScore(winNumbers);
            winnerBoard.put(winNumber);
        }
    }

    public double calculateEarningRate() {
        int totalPrice = 0;

        for (Integer key : priceBoard.keySet()) {
            totalPrice += priceBoard.get(key) * winnerBoard.get(key);
        }

        return Math.floor(totalPrice * 100.0 / (lottoList.size() * EACH_LOTTO_PRICE)) / 100;
    }

    public WinnerBoard getWinnerBoard() {
        return winnerBoard;
    }

    public int totalLottoCount() {
        return lottoList.size();
    }

    public String lottoListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottoList) {
            stringBuilder.append(lotto)
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aggregator that = (Aggregator) o;
        return Objects.equals(priceBoard, that.priceBoard) && Objects.equals(getWinnerBoard(), that.getWinnerBoard()) && Objects.equals(lottoList, that.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceBoard, getWinnerBoard(), lottoList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int matchCount=3; matchCount<=6; matchCount++) {
            stringBuilder.append(matchCount + "개 일치 " + "(" + priceBoard.get(matchCount) + "원)- ")
                    .append(winnerBoard.get(matchCount) + "개\n");
        }
        return stringBuilder.toString();
    }
}
