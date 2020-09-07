package lotto.common;

import lotto.domain.LottoNumber;
import lotto.domain.LottoPackage;
import lotto.domain.LottoTicket;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicketMachine {
    private static final int LOTTO_TICKET_PRICE = 1_000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static LottoPackage issueTickets(int money) {
        int ticketCount = calculateTicketCount(money);

        List<LottoTicket> lottoTickets = Stream.generate(() -> issueTicket())
                .limit(ticketCount)
                .collect(Collectors.toList());
        return new LottoPackage(lottoTickets);
    }

    private static int calculateTicketCount(int money) {
        validate(money);
        return money / LOTTO_TICKET_PRICE;
    }

    public static LottoTicket issueTicket(String lottoNumberParam) {
        Set<LottoNumber> lottoNumbers = convertToLottoNumbers(lottoNumberParam);
        return new LottoTicket(lottoNumbers);
    }

    private static void validate(int money) {
        if (money < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("구입금액이 부족합니다.");
        }
    }

    private static LottoTicket issueTicket() {
        Collections.shuffle(lottoNumbers);
        Set<LottoNumber> sixNumbers = new HashSet<>(lottoNumbers.subList(0,6));
        return new LottoTicket(sixNumbers);
    }

    private static Set<LottoNumber> convertToLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(numberValue -> new LottoNumber(numberValue.trim()))
                .collect(Collectors.toSet());
    }
}
