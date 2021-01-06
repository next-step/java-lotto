package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerLottoTicket {

    public static final String SPLIT_CONSTANT = ",";
    public static final int LOTTO_NUMBER = 6;

    List<LottoNumber> list = new ArrayList<>();

    public WinnerLottoTicket(String inputLottoWinnerNumber) {
        String[] lottoNumbers = inputLottoWinnerNumber.split(SPLIT_CONSTANT);
        validateSize(lottoNumbers);
        for (String number : lottoNumbers) {
            this.list.add(new LottoNumber(number.trim()));
        }
    }

    private void validateSize(String[] lottoNumbers) {
        if (lottoNumbers.length != LOTTO_NUMBER) {
            System.out.printf("Input Size: %d",lottoNumbers.length);
            throw new IllegalArgumentException("입력하신 당첨 번호의 개수가 유효하지 않습니다.");
        }
    }

    public int checkResult(LottoTicket lottoTicket) {
        long count = this.list
            .stream()
            .filter(lottoTicket::contain)
            .count();
        return (int) count;
    }
}
