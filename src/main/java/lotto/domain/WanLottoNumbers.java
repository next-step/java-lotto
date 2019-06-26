package lotto.domain;

import lotto.common.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WanLottoNumbers {
    private final static String SEPARATOR = ",";
    private final static int EMPTY_BONUS_NUMBER = 0;
    private LottoNumbers winLottoNumbers;
    private BonusNumber bonusNumber;
    
    public WanLottoNumbers(final String winLottoNumber) {
        this(winLottoNumber, EMPTY_BONUS_NUMBER);
    }
    
    public WanLottoNumbers(final String winLottoNumber, final int bonusNumber) {
        final String[] winNumbers = winLottoNumber.split(SEPARATOR);
        final List<LottoNumber> lottoNumbers = Arrays.stream(winNumbers)
            .map(String::trim)
            .filter(StringUtils::isNumeric)
            .mapToInt(lottoNumber -> Integer.parseInt(lottoNumber.trim()))
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
        
        this.winLottoNumbers = new LottoNumbers(lottoNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }
    
    public LottoNumbers getLotto() {
        return winLottoNumbers;
    }
    
    int getMatchedNumberCount(final LottoNumbers lottoNumbers) {
        return winLottoNumbers.getMatchedNumberCount(lottoNumbers);
    }
    
    public boolean isMatchedBonus(LottoNumbers lotto) {
        return lotto.haveBonusNumber(bonusNumber);
    }
}
