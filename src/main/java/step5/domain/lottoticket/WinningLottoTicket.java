package step5.domain.lottoticket;

import step5.domain.BonusBall;
import step5.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoTicket {
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 번호는 6개로 구성되어야 합니다.";
    private static final String DELIMITER = ", ";
    private final List<LottoNumber> lottoTicket;
    private final BonusBall bonusBall;

    public WinningLottoTicket(String stringlottoNumber, Integer bonusBall) {
        List<String> lottoNumbers = Arrays.asList(stringlottoNumber.split(DELIMITER));
        checkValidLottoNumberFormat(stringlottoNumber);

        lottoTicket = lottoNumbers.stream()
                .map(lottoNumber -> new LottoNumber(lottoNumber))
                .collect(Collectors.toList());

        this.bonusBall = new BonusBall(bonusBall);
    }

    private void checkValidLottoNumberFormat(String stringlottoNumber) {
        List<String> lottoNumbers = Arrays.asList(stringlottoNumber.split(DELIMITER));
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<LottoNumber> ticket() {
        return lottoTicket;
    }

    public BonusBall bonusBall() {
        return bonusBall;
    }
}
