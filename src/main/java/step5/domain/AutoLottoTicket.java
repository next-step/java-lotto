package step5.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoTicket implements LottoTicket {
    private static final String LOTTO_NUMBER_ㄷERROR_MESSAGE = "로또 번호는 6개로 구성되어야 합니다.";
    private static final String DELIMITER = ", ";
    private static final LottoMachine lottoMachine = new LottoMachine();
    private final List<LottoNumber> lottoTicket;

    public AutoLottoTicket() {
        List<Integer> autoLottoNumbers = lottoMachine.issue();
        checkValidLottoNumberFormat(autoLottoNumbers);

        lottoTicket = autoLottoNumbers
                .stream()
                .map(autoLottoNumber -> new LottoNumber(autoLottoNumber))
                .collect(Collectors.toList());
    }

    public void checkValidLottoNumberFormat(List<Integer> autoLottoNumbers) {
        if (autoLottoNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ㄷERROR_MESSAGE);
        }
    }

    public List<LottoNumber> ticket() {
        return lottoTicket;
    }
}
