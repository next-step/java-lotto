package step3.lotto.domain.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class LottoRank {

    private static final Integer DEFAULT_LOTTO_RANK = 7; // 로또 등수구할때 기본으로 세팅되어있는 값
    private static final Integer MIN_LOTTO_WINNING_RANK = 6;
    List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber = 0;

    LottoRank(int bonusNumber, List<Integer> winningNumbers) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public Integer getRank(SortedSet<Integer> paramValue) {
        Integer lottoRank = DEFAULT_LOTTO_RANK;

        for (Integer number : paramValue) {
            lottoRank = checkSameValue(number, lottoRank);
        }

        //1등이 아닐시 등급 1 추가
        if (lottoRank == 1) {
            return 1;
        }

        lottoRank++;

        // 3등과 2등 체크
        if (lottoRank == 3) {
            lottoRank = checkLottoSecond(paramValue, lottoRank);
        }

        //당첨되지 않았을 시
        if (lottoRank > MIN_LOTTO_WINNING_RANK) {
            return 0;
        }

        return lottoRank;
    }

    private  Integer checkSameValue(Integer paramValue, int lottoRank) {
        Integer returnValue = lottoRank;

        if (winningNumbers.contains(paramValue)) {
            returnValue--;
        }

        return returnValue;
    }

    private  int checkLottoSecond(SortedSet<Integer> paramValue, int lottoRank) {
        if (paramValue.contains(bonusNumber)) {
            lottoRank--;
        }

        return lottoRank;
    }

}
