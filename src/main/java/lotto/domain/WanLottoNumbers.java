package lotto.domain;

import lotto.common.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WanLottoNumbers {
    private final static String SEPARATOR = ",";
    private LottoNumbers winLottoNumbers;
    private BonusNumber bonusNumber;
    
    public WanLottoNumbers(String winLottoNumber) {
        this(winLottoNumber, 0);
    }
    
    public WanLottoNumbers(final String winLottoNumber, final int bonasNumber) {
        final String[] winNumbers = winLottoNumber.split(SEPARATOR);
        final List<LottoNumber> lottoNumbers = Arrays.stream(winNumbers)
            .map(String::trim)
            .filter(StringUtils::isNumeric)
            .mapToInt(lottoNumber -> Integer.parseInt(lottoNumber.trim()))
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
        
        this.winLottoNumbers = new LottoNumbers(lottoNumbers);
        this.bonusNumber = new BonusNumber(bonasNumber);
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
