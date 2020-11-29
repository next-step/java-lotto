package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoGameConfig.LOTTO_TICKET_NUMBER_COUNT;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    private final boolean isAutoGenerate;

    public LottoTicket(List<LottoNumber> lottoNumbers, boolean isAutoGenerate){
        validateLottoNumberCount(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
        this.isAutoGenerate = isAutoGenerate;
    }

    public List<LottoNumber> getSortedLottoNumbers(){
        Collections.sort(this.lottoNumbers);
        return this.lottoNumbers;
    }

    public boolean isAutoGenerate(){
        return isAutoGenerate;
    }

    public PrizeUnit countWinningNumbers(List<LottoNumber> lastWinningNumbers, LottoNumber bonusNumber) {

        validateLottoNumberCount(lastWinningNumbers);

        List<LottoNumber> winningsNumber = lottoNumbers.stream()
                .filter(element -> lastWinningNumbers.contains(element)).collect(Collectors.toList());

        return PrizeUnit.findPrizeFieldByUnitCount(winningsNumber.size(), lottoNumbers.contains(bonusNumber));
    }

    private void validateLottoNumberCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_TICKET_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_LOTTO_NUMBER_COUNT.getErrorMessage());
        }
    }

}
