package lotto.domain;

import lotto.common.ErrorMessage;
import lotto.common.LottoNumbersMaker;
import lotto.common.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private final static String SEPARATOR = ",";
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static int START_NUMBER = 0;
    
    private List<LottoNumber> lottoNumbers;
    
    LottoNumbers() {
        this.lottoNumbers = LottoNumbersMaker.getNewLottoNumbers();
    }
    
    public LottoNumbers(final String lottoNumbersStr) {
        this(lottoNumbersStr.split(SEPARATOR));
    }
    
    public LottoNumbers(final String[] lottoNumbersArr) {
        this(
          Arrays.stream(lottoNumbersArr)
            .map(String::trim)
            .filter(StringUtils::isNumeric)
            .mapToInt(lottoNumber -> Integer.parseInt(lottoNumber.trim()))
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList())
        );
    }
    
    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        if (!checkDuplicateNumber(lottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.message());
        }
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR.message());
        }
        this.lottoNumbers = lottoNumbers;
    }

    private static boolean checkDuplicateNumber(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
          .distinct()
          .count() == lottoNumbers.size();
    }
    
    public int getMatchedNumberCount(final LottoNumbers lottoNumbers) { 
        return this.lottoNumbers.stream()
            .filter(lottoNumbers::contains)
            .mapToInt(lottoNumber -> 1)
            .sum();
    }
    
    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
    
    public boolean haveBonusNumber(BonusNumber bonusNumber) {
        LottoNumber bonusLottoNumber = bonusNumber.getLottoNumber();
        return lottoNumbers.contains(bonusLottoNumber);
    }
    
    public boolean isEqualsTo(LottoNumbers lottoNumbers) {
        return lottoNumbers.isEqualsTo(this.lottoNumbers);
    }
    
    private boolean isEqualsTo(List<LottoNumber> lottoNumbers) {
        return IntStream.range(START_NUMBER, lottoNumbers.size())
                .allMatch(i -> this.lottoNumbers.get(i).equals(lottoNumbers.get(i)));
    }
    
    
    
    @Override
    public String toString() {
        return "\n(" + lottoNumbers + ")";
    }
}
