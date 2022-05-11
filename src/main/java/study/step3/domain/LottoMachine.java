package study.step3.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {
    private static final String DEFAULT_SPLIT_REGEX = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 46;

    private static final List<Integer> DEFAULT_NUMBER_RANGE =
            IntStream.range(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE)
                    .boxed()
                    .collect(Collectors.toList());

    public static LottoTickets createLottoTickets(int buyAmount) {
        LottoQuantity lottoQuantity = new LottoQuantity(buyAmount);

        List<LottoTicket> tickets = Stream.generate(LottoMachine::createLottoTicket)
                .limit(lottoQuantity.quantity())
                .collect(Collectors.toList());

        return new LottoTickets(lottoQuantity, tickets);
    }

    public static LottoTicket createLottoTicket(String numbers) {
        return new LottoTicket(createLottoNumbers(numbers));
    }

    public static LottoWinners createWinners(String inputNumber, int inputBonusNumber) {
        LottoNumbers winners = new LottoNumbers(createLottoNumbers(inputNumber));
        LottoNumber bonus = new LottoNumber(inputBonusNumber);
        return new LottoWinners(winners, bonus);
    }

    private static LottoTicket createLottoTicket() {
        return new LottoTicket(lottoNumberRandom());
    }

    private static List<Integer> lottoNumberRandom() {
        Collections.shuffle(DEFAULT_NUMBER_RANGE);
        List<Integer> result = DEFAULT_NUMBER_RANGE.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());
        Collections.sort(result);
        return result;
    }

    private static List<Integer> createLottoNumbers(String numbers) {
        List<Integer> result = stringToList(numbers).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return result;
    }

    private static List<String> stringToList(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(DEFAULT_SPLIT_REGEX))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
