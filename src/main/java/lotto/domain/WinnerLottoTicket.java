package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerLottoTicket {

    public static final String SPLIT_CONSTANT = ",";
    public static final int LOTTO_NUMBER = 6;

    private final LottoTicket lottoTicket;
    private final BonusNumber bonusNumber;

    public WinnerLottoTicket(String inputLottoWinnerNumber, String bonusNumber) {
        String[] lottoNumbers = inputLottoWinnerNumber.split(SPLIT_CONSTANT);
        validateSize(lottoNumbers);
        List<LottoNumber> collect = Arrays.stream(lottoNumbers)
            .map(s -> new LottoNumber(s.trim()))
            .collect(Collectors.toList());
        this.lottoTicket = new LottoTicket(collect);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void validateSize(String[] lottoNumbers) {
        if (lottoNumbers.length != LOTTO_NUMBER) {
            throw new IllegalArgumentException("입력하신 당첨 번호의 개수가 유효하지 않습니다.");
        }
    }

    public int checkResult(LottoTicket lottoTicket) {
        long count = this.lottoTicket.countSameNumber(lottoTicket);
        return (int) count;
    }
}
