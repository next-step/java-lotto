package step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoSeller {
    static final int PRICE_OF_A_LOTTO_TICKET = 1000;
    static final String ALERT_MISSING_MONEY = "돈을 넣어주세요. 로또복권은 한 장당 1000원 입니다.";
    private static final String ALERT_SHORT_OF_MONEY = "돈이 모자랍니다.";
    private static final String ALERT_NEGATIVE_NUMBER = "구매할 수동로또 개수는 음수가 될 수 없습니다.";
    static final String NUMBER_SEPARATOR = ",";

    public static int countAutoTickets(int inputMoney, int numberOfManualTickets) {
        validationInputData(inputMoney, numberOfManualTickets);
        return (inputMoney / PRICE_OF_A_LOTTO_TICKET) - numberOfManualTickets;
    }

    public static LottoTickets issueLottoTicket(List<String> manualTickets, int numberOfAutoTickets) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (String manualTicket : manualTickets) {
            List<Integer> parsedManualTicket = parseToNumbers(manualTicket);
            lottoTickets.add(LottoTicketGenerator.issueManualTickets(parsedManualTicket));
        }
        for (int i = 0; i < numberOfAutoTickets; i++) { //TODO: index i가 사용되지 않고 있음
            lottoTickets.add(LottoTicketGenerator.issueAutoTickets());
        }
        return LottoTickets.from(lottoTickets);
    }

    private static List<Integer> parseToNumbers(String manualTicket) {
        return Arrays.stream(manualTicket.split(NUMBER_SEPARATOR))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static LuckyTicket getLuckyNumber(List<Integer> inputLuckyNumber, int bonusNumber) {
        List<LottoNumber> luckyTicket = inputLuckyNumber.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return LuckyTicket.of(luckyTicket, LottoNumber.from(bonusNumber));
    }

    private static void validationInputData(int inputMoney, int numberOfManualTickets) {
        if (inputMoney < PRICE_OF_A_LOTTO_TICKET) {
            throw new IllegalArgumentException(ALERT_MISSING_MONEY);
        }
        if (numberOfManualTickets < 0) {
            throw new IllegalArgumentException(ALERT_NEGATIVE_NUMBER);
        }
        if (numberOfManualTickets * PRICE_OF_A_LOTTO_TICKET > inputMoney) {
            throw new IllegalArgumentException(ALERT_SHORT_OF_MONEY);
        }
    }
}
