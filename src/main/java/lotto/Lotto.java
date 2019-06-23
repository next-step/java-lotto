package lotto;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lotto {

    private static final int lottoIsWinnerNumberCount = 1;
    private static final int lottoIsNotWinnerNumberCount = 0;
    private static final String lottoIsWinnerPriceEnumSuffix = "개 일치 ";
    private static final String lastWeekWinNumDelimiter = ",";
    private List <Integer> lottoGameNumber;
    private int winnerNumberCount = 0;
    private int winnerPrice = 0;

    public Lotto(List <Integer> lottoGameNumber) {
        this.lottoGameNumber = lottoGameNumber;
    }

    public int getWinnerNumberCount() {
        return winnerNumberCount;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }

    public void winnerCheck(String lastWeekWinnerNumber) {
        String[] lastWeekwinNumbers = lastWeekWinnerNumber.split(lastWeekWinNumDelimiter);
        for (String winNumber : lastWeekwinNumbers) {
            winnerNumberCount += winnerNumCount(winNumber);
        }
        winnerPrice = winnerNumPrice();
    }

    private int winnerNumCount(String winNumber) {
        if (lottoGameNumber.contains(Integer.parseInt(winNumber))) {
            return lottoIsWinnerNumberCount;
        }
        return lottoIsNotWinnerNumberCount;
    }

    private int winnerNumPrice() {
        return LottoEnum.findByPrice(createFindPriceKey()).price();
    }

    private String createFindPriceKey(){
        return winnerNumberCount + lottoIsWinnerPriceEnumSuffix;
    }

    public String lottoNumber(){
        return lottoGameNumber.stream()
                .map(num -> Integer.toString(num))
                .collect(Collectors.joining(","));
    }

    public String getResultText() {
        return createFindPriceKey() + winnerNumPrice();
    }
}
