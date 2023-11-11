package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerNumber {

    private static final String DELIMITER = ",";
    private Lotto lotto;

    public WinnerNumber(String lottoNumbers) {
        this.lotto = new Lotto(createLottoNumbers(lottoNumbers));
    }

    private List<LottoNumber> createLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Lotto resultLotto() {
        return lotto;
    }
}
