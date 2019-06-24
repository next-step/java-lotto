package lotto.domain;

import lotto.common.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WanLottoNumbers {
    private final static String SEPARATOR = ",";
    private LottoNumbers winLottoNumbers;
    
    public WanLottoNumbers(final String winLottoNumber) {
        final String[] winNumbers = winLottoNumber.split(SEPARATOR);
        final List<LottoNumber> lottoNumbers = Arrays.stream(winNumbers)
            .map(String::trim)
            .filter(StringUtils::isNumeric)
            .mapToInt(lottoNumber -> Integer.parseInt(lottoNumber.trim()))
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
        
        winLottoNumbers = new LottoNumbers(lottoNumbers);
    }
    
    public LottoNumbers getLotto() {
        return winLottoNumbers;
    }
    
    int getMatchedNumberCount(final LottoNumbers lottoNumbers) {
        return winLottoNumbers.getMatchedNumberCount(lottoNumbers);
    }
}
