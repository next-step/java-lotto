package study.step4.domain;

import study.step4.domain.strategy.LottoCreationStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
    private static final String DEFAULT_SPLIT_REGEX = ",";

    private static LottoCreationStrategy lottoCreationStrategy;

    public LottoMachine(LottoCreationStrategy lottoCreationStrategy) {
        this.lottoCreationStrategy = lottoCreationStrategy;
    }

    public static LottoTickets createLottoTickets(int buyAmount, List<List<Integer>> inputManual) {
        LottoQuantity lottoQuantity = new LottoQuantity(buyAmount, inputManual.size());

        List<LottoTicket> lottoManualTickets = inputManual.stream()
                .map(LottoMachine::createManualLotto)
                .collect(Collectors.toList());

        List<LottoTicket> lottoAutoTickets = Stream.generate(LottoMachine::createLottoTicket)
                .limit(lottoQuantity.quantity())
                .collect(Collectors.collectingAndThen(toList(), LottoTickets::new)).readOnlyLottoTicket();

        List<LottoTicket> result = new ArrayList<>();
        result.addAll(lottoManualTickets);
        result.addAll(lottoAutoTickets);

        return new LottoTickets(result);
    }

    private static LottoTicket createManualLotto(List<Integer> numbers) {
        return new LottoTicket(Set.copyOf(numbers));
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

    private static Set<Integer> lottoNumberRandom() {
        return lottoCreationStrategy.createLottoNumber();
    }

    private static Set<Integer> createLottoNumbers(String numbers) {
        Set<Integer> result = stringToList(numbers).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        return result;
    }

    private static List<String> stringToList(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(DEFAULT_SPLIT_REGEX))
                .map(String::trim)
                .collect(toList());
    }
}
