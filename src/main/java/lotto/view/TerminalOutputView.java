package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class TerminalOutputView {

    private static final String LOTTO_NUMBERS_DELIMITER = ", ";
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

    public void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        String resultNumbers = lottoNumbers.stream()
                .map(LottoNumber::number)
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBERS_DELIMITER));
        System.out.println(LOTTO_NUMBERS_PREFIX + resultNumbers + LOTTO_NUMBERS_POSTFIX);
    }
}
