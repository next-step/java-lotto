package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.util.LottoViewConstants;

import java.util.List;
import java.util.stream.Collectors;

public class TerminalOutputView {

    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTTO_NUMBERS_POSTFIX = "]";

    public void printPurchaseAmountGuide() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.stream()
                .map(LottoTicket::lottoNumbers)
                .forEach(this::printLottoNumbers);
        System.out.println();
    }

    private void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        String resultNumbers = lottoNumbers.stream()
                .map(LottoNumber::number)
                .map(String::valueOf)
                .collect(Collectors.joining(LottoViewConstants.LOTTO_NUMBERS_DELIMITER));
        System.out.println(LOTTO_NUMBERS_PREFIX + resultNumbers + LOTTO_NUMBERS_POSTFIX);
    }

    public void printWinningNumbersGuide() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
    }
}
