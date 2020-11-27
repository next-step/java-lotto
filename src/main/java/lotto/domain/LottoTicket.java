package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoGameConfig.LOTTO_TICKET_NUMBER_COUNT;
import static lotto.domain.LottoGameConfig.MAX_LOTTO_NUMBER;

public class LottoTicket {

    private static final int MIN_COUNT_TO_PRIZE = 3;

    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getSortedLottoNumbers(){
        Collections.sort(this.lottoNumbers);
        return this.lottoNumbers;
    }

    public PrizeUnit countWinningNumbers(List<LottoNumber> lastWinningNumbers, int bonusNumber) {

        validateLastWinningNumbers(lastWinningNumbers);
        validateBonusNumber(bonusNumber);

        List<LottoNumber> winningsNumber = lottoNumbers.stream()
                .filter(element -> lastWinningNumbers.contains(element)).collect(Collectors.toList());

        boolean isMatchBonusNumber = lottoNumbers.contains(new LottoNumber(bonusNumber));

        int winningNumberSize = winningsNumber.size();

        if(winningNumberSize == PrizeUnit.SECOND_GRADE.prizeUnitCount && isMatchBonusNumber){
            return PrizeUnit.SECOND_GRADE;
        }

        if(winningNumberSize < MIN_COUNT_TO_PRIZE){
            winningNumberSize = 0;
        }

        return PrizeUnit.findPrizeFieldByUnitCount(winningNumberSize, false);
    }

    private void validateBonusNumber(int bonusNumber) {
        if(bonusNumber> MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_BONUS_NUMBER.getErrorMessage());
        }
    }

    private void validateLastWinningNumbers(List<LottoNumber> lastWinningNumbers) {

        if (lastWinningNumbers.size() != LOTTO_TICKET_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_WINNING_NUMBER.getErrorMessage());
        }

        if(lastWinningNumbers.stream().anyMatch(number -> number.getNumber() > MAX_LOTTO_NUMBER)){
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_WINNING_NUMBER.getErrorMessage());
        }
    }


}
