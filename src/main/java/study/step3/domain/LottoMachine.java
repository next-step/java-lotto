package study.step3.domain;

import study.step3.domain.strategy.LottoCreationStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    private static final String DEFAULT_SPLIT_REGEX = ",";

    private static LottoCreationStrategy lottoCreationStrategy;

    public LottoMachine(LottoCreationStrategy lottoCreationStrategy) {
        this.lottoCreationStrategy = lottoCreationStrategy;
    }

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
        return lottoCreationStrategy.createLottoNumber();
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
