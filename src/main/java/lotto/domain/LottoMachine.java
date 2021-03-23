package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 46;
    private static final List<Integer> DEFAULT_NUMBER_RANGE = IntStream.range(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE)
                                                                    .boxed()
                                                                    .collect(Collectors.toList());

    public static LottoTickets createLottoTickets(LottoQuantity lottoQuantity, List<List<Integer>> inputManual) {
        List<LottoTicket> tickets = inputManual.stream()
                .map(LottoMachine::createLottoTicket)
                .collect(Collectors.toList());

        IntStream.range(0, lottoQuantity.autoQuantity())
                .forEach(i -> tickets.add(createLottoTicket()));

        return new LottoTickets(tickets);
    }

    public static LottoWinners createWinners(List<Integer> numbers, int inputBonusNumber) {
        LottoNumbers winners = new LottoNumbers(numbers);
        LottoNumber bonus = new LottoNumber(inputBonusNumber);
        return new LottoWinners(winners, bonus);
    }

    private static LottoTicket createLottoTicket() {
        return new LottoTicket(lottoNumberRandom());
    }

    public static LottoTicket createLottoTicket(List<Integer> numbers) {
        return new LottoTicket(numbers);
    }

    private static List<Integer> lottoNumberRandom() {
        Collections.shuffle(DEFAULT_NUMBER_RANGE);

        List<Integer> result = DEFAULT_NUMBER_RANGE.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());

        Collections.sort(result);

        return result;
    }
}
