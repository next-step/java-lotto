package step5.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoTicket implements LottoTicket {
    private static final String LOTTO_NUMBER_ㄷERROR_MESSAGE = "로또 번호는 6개로 구성되어야 합니다.";
    private static final String DELIMITER = ", ";
//    private final List<LottoNumber> lottoTicket;

    public AutoLottoTicket() {

    }

    public void checkValidLottoNumberFormat(String stringlottoNumber) {
        List<String> lottoNumbers = Arrays.asList(stringlottoNumber.split(DELIMITER));
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ㄷERROR_MESSAGE);
        }
    }


}
