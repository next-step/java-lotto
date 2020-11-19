package step4.domain.lotto;

import step4.Constant;
import step4.domain.lotto.dto.LottoPurchaseInfoDTO;
import step4.domain.lotto.firstcollection.LottoNumber;
import step4.domain.lotto.firstcollection.LottoTickets;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static step4.Constant.ERROR_INVALID_PARAMETER;
import static step4.Constant.ERROR_NOT_ENOUGH_MONEY;

public class LottoTicketMachine {
    private static final BiFunction<Long, Integer, Integer> division = (i, j) -> (int) (i / j);
    private static final int LOTTO_RANGE_MAX = 46;
    private static final int START_INCLUSIVE = 1;
    private static final int LOTTO_START_INDEX = 0;
    private static final int LOTTO_END_INDEX = 6;
    public static final int START_INDEX = 0;

    private static final List<LottoNumber> lottoNumbers = IntStream.range(START_INCLUSIVE, LOTTO_RANGE_MAX)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private LottoTicketMachine() { }

    public static LottoTickets ticketing(LottoPurchaseInfoDTO infoDTO) {
        isValidTicketing(infoDTO);
        List<LottoTicket> autos = createAutoLotto(infoDTO.getAutoTicketsSize());
        List<LottoTicket> manuals = makeManualTickets(infoDTO.getManualNumbers());
        List<LottoTicket> tickets = Stream.of(manuals, autos)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return  new LottoTickets(tickets);
    }

    private static void isValidTicketing(LottoPurchaseInfoDTO infoDTO) {
        isValidPrice(infoDTO.getMoney());
        isValidCount(infoDTO.getManualSize());
        isEnoughMoney(infoDTO.getMoney(), infoDTO.getManualSize());
    }


    public static List<LottoTicket> createAutoLotto(int size) {
        return IntStream.range(START_INDEX, size)
                .mapToObj(index -> {
                    shuffle();
                    return new LottoTicket(new HashSet<>(lottoNumbers.subList(LOTTO_START_INDEX, LOTTO_END_INDEX)));
                })
                .collect(Collectors.toList());
    }

    private static List<LottoTicket> makeManualTickets(List<String> manualNumbers) {
        return manualNumbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }


    private static void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public static int countAllowTicket(long inputPrice) {
        isValidPrice(inputPrice);
        return division.apply(inputPrice, Constant.LOTTO_PRICE);
    }

    private static void isEnoughMoney(long money, int wantedTicketCount) {
        if (countAllowTicket(money) < wantedTicketCount) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_MONEY);
        }
    }

    private static void isValidPrice(double inputPrice) {
        if (inputPrice < Constant.LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_MONEY);
        }
    }

    private static void isValidCount(int wantedTicketCount) {
        if (wantedTicketCount < 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PARAMETER);
        }
    }
}
