package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerLottoTicket {

    public static final String SPLIT_CONSTANT = ",";
    public static final int LOTTO_NUMBER = 6;

    private final LottoTicket lottoTicket;

    public WinnerLottoTicket(String inputLottoWinnerNumber) {
        String[] lottoNumbers = inputLottoWinnerNumber.split(SPLIT_CONSTANT);
        validateSize(lottoNumbers);
        List<LottoNumber> list = new ArrayList<>();
        for (String number : lottoNumbers) {
            list.add(new LottoNumber(number.trim()));
        }
        this.lottoTicket = new LottoTicket(list);
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
