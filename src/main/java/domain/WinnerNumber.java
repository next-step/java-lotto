package domain;

import java.util.List;

import static domain.LottoGames.LOTTO_NUMBER;

public class WinnerNumber {

    private List<Integer> winnerNumber;

    public WinnerNumber(List<Integer> number) {

        winnerNumber = number;
    }

    public List<Integer> getWinnerNumber() {
        return winnerNumber;
    }

    public int getCountingNumber(Lotto lotto) {
        int count = 0;
//        lotto.getLottoNumber().stream().

        for (int j = 0; j < LOTTO_NUMBER; j++) {
            if(lotto.getLottoNumber().contains(winnerNumber.get(j))){
                count ++;
            }
        }
        return count;
    }
}
