package lotto.domain;

import lotto.common.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinLottoNumbers {
    private final static String SEPARATOR = ",";
    private LottoNumbers winLottoNumbers;
    
    public WinLottoNumbers(String winLottoNumber) {
        String[] winNumbers = winLottoNumber.split(SEPARATOR);
        List<LottoNumber> lottoNumbers = Arrays.stream(winNumbers)
            .map(String::trim)
            .filter(StringUtils::isNumeric)
            .mapToInt(lottoNumber -> Integer.parseInt(lottoNumber.trim()))
            .mapToObj(lottoNumber -> new LottoNumber(lottoNumber))
            .collect(Collectors.toList());
        
        winLottoNumbers = new LottoNumbers(lottoNumbers);
    }
    
    public void getResult(BuyingLottos lottos) {}
    
    public LottoNumbers getLotto() {
        return winLottoNumbers;
    }
    
    public int getMatchedNumberCount(LottoNumbers lottoNumbers) {
        return winLottoNumbers.getMatchedNumberCount(lottoNumbers);
    }
}
