package lotto.domain;


import lotto.utils.LottoType;

import java.util.List;
import java.util.stream.Collectors;


public class Lotto {

    private static String COMMA_SPACE = ", ";
    private LottoType lottoType;
    private List<Integer> selectedLottoNumber;

    public Lotto(LottoType lottoType) {
        this.lottoType = lottoType;
    }

    public void makeLottoNumber() {

        List lottoNumbers = lottoType.makeLottoNumber();
        this.selectedLottoNumber = lottoNumbers;
    }

    public String getSelectedLottoNumber() {
        String joinNumbers = selectedLottoNumber.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(COMMA_SPACE));
        return "[" + joinNumbers + "]";
    }
}
