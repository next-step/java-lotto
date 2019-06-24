package lotto.domain;

import lotto.common.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinLotto {
    private final static String SEPARATOR = ",";
    private Lotto lotto;
    
    public WinLotto(String winLottoNumber) {
        String[] winNumbers = winLottoNumber.split(SEPARATOR);
        List<LottoNumber> lottoNumbers = Arrays.stream(winNumbers)
            .map(String::trim)
            .filter(StringUtils::isNumeric)
            .mapToInt(lottoNumber -> Integer.parseInt(lottoNumber.trim()))
            .mapToObj(lottoNumber -> new LottoNumber(lottoNumber))
            .collect(Collectors.toList());
        
        lotto = new Lotto(lottoNumbers);
    }
}
