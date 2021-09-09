package step5.domain.lottoticket;

import step5.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoTicket implements LottoTicket {
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 번호는 6개로 구성되어야 합니다.";
    private static final String DELIMITER = ", ";
    private final List<LottoNumber> lottoTicket;

    public ManualLottoTicket(String stringLottoNumber) {
        List<String> lottoNumbers = Arrays.asList(stringLottoNumber.split(DELIMITER));
        checkValidLottoNumberFormat(stringLottoNumber);

        lottoTicket = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void checkValidLottoNumberFormat(String stringLottoNumber) {
        List<String> lottoNumbers = Arrays.asList(stringLottoNumber.split(DELIMITER));
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<LottoNumber> ticket() {
        return lottoTicket;
    }

    @Override
    public Long matchWinningLotto(WinningLottoTicket winningLottoTicket) {
        return lottoTicket.stream()
                .filter(lottoNumber -> winningLottoTicket.ticket().contains(lottoNumber))
                .count();
    }

    @Override
    public boolean matchBonusBall(WinningLottoTicket winningLottoTicket) {
        return lottoTicket.contains(winningLottoTicket.bonusBall().number());
    }
}
