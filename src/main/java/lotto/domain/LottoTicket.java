package lotto.domain;

import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoInformation.NUMBER_OF_LOTTO_NUMBERS;

public class LottoTicket {
    
    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket from(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket from(Integer... numbers) {
        List<LottoNumber> lottoNumberList = Arrays.stream(numbers)
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumberList);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new LottoException("로또 번호는 6개여야 합니다.");
        }
    }


    public LottoRank getLottoRank(LottoWinningNumbers lottoWinningNumbers) {
        return LottoRank.valueOf(
                countOfMatch(lottoWinningNumbers),
                matchesBonus(lottoWinningNumbers)
        );
    }

    public int countOfMatch(LottoWinningNumbers lottoWinningNumbers) {
        return lottoNumbers.stream()
                .map(lottoWinningNumbers::numberContain)
                .reduce(0, Integer::sum);
    }

    public boolean matchesBonus(LottoWinningNumbers lottoWinningNumbers) {
        return lottoNumbers.contains(lottoWinningNumbers.getBonusNumber());
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
