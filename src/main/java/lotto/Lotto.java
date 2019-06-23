package lotto;

import java.util.List;

public class Lotto {

    private static final int lottoDefaulWinnertPrice = 5000;
    private static final int lottoIsWinnerNumberCount = 1;
    private static final int lottoIsNotWinnerNumberCount = 0;
    private static final String lottoIsWinnerPriceEnumPrefix = "Winner";
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
        return LottoEnum.findByPrice(createFindPriceKey()).getPrice();
    }

    private String createFindPriceKey(){
        return lottoIsWinnerPriceEnumPrefix + winnerNumberCount;
    }


}
