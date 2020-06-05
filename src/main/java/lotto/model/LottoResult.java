package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private List<Winner> winnerResult = new ArrayList<>();
    private List<List<Integer>> lottoNumbers;
    private String[] inputLastNumber;

    public LottoResult(String[] inputLastNumber) {
        this.inputLastNumber = inputLastNumber;
    }

    public LottoResult(List<List<Integer>> lottoNumbers, String[] inputLastNumber) {
        this.lottoNumbers = lottoNumbers;
        this.inputLastNumber = inputLastNumber;
    }

    public List<Winner> getLottoResult() {
        for (List<Integer> lottoNumber : lottoNumbers) {
            setWinnerResult(checkWinnerNumber(lottoNumber));
        }
        return winnerResult;
    }

    public int checkWinnerNumber(List<Integer> userLottoNumber) {
        int matchingCount = 0;
        for (int i = 0; i < inputLastNumber.length; i++) {
            matchingCount += (userLottoNumber.contains(Integer.parseInt(inputLastNumber[i]))) ? 1 : 0;
        }
        return matchingCount;
    }

    private void setWinnerResult(int matchingResult) {
        int prize = LottoPrize.getLottoPrize(matchingResult);
        if (prize > 0) {
            winnerResult.add(new Winner(prize, matchingResult));
        }
    }
}
