package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoFactory {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 46;
    private static final List<Integer> DEFAULT_NUMBER_RANGE = IntStream.range(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE)
                                                                    .boxed()
                                                                    .collect(Collectors.toList());

    private LottoFactory() { }

    public static LottoTickets createLottoTickets(LottoQuantity lottoQuantity, List<List<Integer>> inputManual) {
        List<LottoTicket> result = new ArrayList<>();
        result.addAll(LottoFactory.createManualLottoTickets(inputManual));
        result.addAll(LottoFactory.createAutoLottoTickets(lottoQuantity));

        return new LottoTickets(result);
    }

    private static List<LottoTicket> createAutoLottoTickets(LottoQuantity lottoQuantity) {
        return Stream.generate(LottoFactory::createAutoLotto)
                                    .limit(lottoQuantity.autoQuantity())
                                    .collect(Collectors.toList());
    }

    private static LottoTicket createAutoLotto() {
        return new LottoTicket(lottoNumberRandom());
    }

    private static List<LottoTicket> createManualLottoTickets(List<List<Integer>> inputManual) {
        return inputManual.stream()
                .map(LottoFactory::createManualLotto)
                .collect(Collectors.toList());
    }

    private static LottoTicket createManualLotto(List<Integer> numbers) {
        return new LottoTicket(numbers);
    }

    public static LottoWinners createWinners(List<Integer> numbers, int inputBonusNumber) {
        LottoNumbers winners = new LottoNumbers(numbers);
        LottoNumber bonus = new LottoNumber(inputBonusNumber);
        return new LottoWinners(winners, bonus);
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
