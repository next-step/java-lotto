package nextstep.lotto.dto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static nextstep.lotto.constant.ExceptionMessage.INVALID_BONUS_NUMBER_CONTAINS_LOTTO_NUMBERS;
import static nextstep.lotto.constant.ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE;

public class LottoWinnerNumbers {

    private Set<LottoNumber> winnerNumbers;

    private LottoNumber bonusNumber;

    private LottoWinnerNumbers(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        this.winnerNumbers = numbers.stream().collect(Collectors.toSet());
        this.bonusNumber = bonusNumber;

        if( winnerNumbers.size() != 6){
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE);
        }

        if(winnerNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_CONTAINS_LOTTO_NUMBERS);
        }
    }

    public static LottoWinnerNumbers create(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        return new LottoWinnerNumbers(numbers,bonusNumber);
    }

    public LottoRank matchCount(List<LottoNumber> userLotto) {
        return LottoRank.of((int) winnerNumbers.stream()
                .filter(userLotto::contains)
                .count(), userLotto.contains(bonusNumber));
    }

    public List<LottoNumber> getLottoNumber(){
        List<LottoNumber> lottoTicket = this.winnerNumbers.stream().collect(Collectors.toList());
        Collections.sort(lottoTicket);
        return Collections.unmodifiableList(
                lottoTicket
        );
    }
}
