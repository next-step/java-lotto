package step4.lotto.domain.numbers;

import java.util.SortedSet;

public class LottoRank {

    private static final int DEFAULT_LOTTO_RANK = 7; // 로또 등수구할때 기본으로 세팅되어있는 값
    private static final int MIN_LOTTO_WINNING_RANK = 6;
    private LottoTicket winningNumbers;
    private int bonusNumber = 0;

    LottoRank(int bonusNumber, LottoTicket winningNumbers) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public Integer getRank(SortedSet<Integer> paramValue) {
        Integer lottoRank = DEFAULT_LOTTO_RANK;

        for (Integer number : paramValue) {
            lottoRank = checkSameValue(number, lottoRank);
        }

        lottoRank = findRank(lottoRank, paramValue);

        return lottoRank;
    }

    private int findRank(int lottoRank, SortedSet<Integer> paramValue) {
        //1등이 아닐시 등급 1 추가
        if (lottoRank == 1) {
            return 1;
        }

        //당첨되지 않았을 시
        if (lottoRank > MIN_LOTTO_WINNING_RANK) {
            return 0;
        }

        lottoRank++;

        // 3등과 2등 체크
        if (lottoRank == 3) {
            lottoRank = checkLottoSecond(paramValue, lottoRank);
        }

        return lottoRank;
    }

    private int checkSameValue(Integer paramValue, int lottoRank) {
        Integer returnValue = lottoRank;

        if (winningNumbers.getLottoTicket().contains(paramValue)) {
            returnValue--;
        }

        return returnValue;
    }

    private int checkLottoSecond(SortedSet<Integer> paramValue, int lottoRank) {
        if (paramValue.contains(bonusNumber)) {
            lottoRank--;
        }

        return lottoRank;
    }

}
