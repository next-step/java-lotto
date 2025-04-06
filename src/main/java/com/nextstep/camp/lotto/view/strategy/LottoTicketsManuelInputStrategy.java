package com.nextstep.camp.lotto.view.strategy;

import java.util.*;
import java.util.stream.Collectors;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.entity.LottoTicket;
import com.nextstep.camp.lotto.domain.entity.LottoTickets;
import com.nextstep.camp.lotto.domain.exception.LottoNumberInputRegexException;
import com.nextstep.camp.lotto.domain.vo.LottoCount;

public class LottoTicketsManuelInputStrategy implements InputStrategy<LottoTickets> {
    private final Scanner scanner;
    private final LottoCount lottoCount;

    private static final String LOTTO_NUMBER_REGEX = "^\\s*\\d{1,2}\\s*(,\\s*\\d{1,2}\\s*){5}$";;
    private static final String DELIMITER = ",\\s?";

    private LottoTicketsManuelInputStrategy(Scanner scanner, LottoCount lottoCount) {
        this.scanner = scanner;
        this.lottoCount = lottoCount;
    }

    public static LottoTicketsManuelInputStrategy ofSystemIn(LottoCount lottoCount) {
        Scanner scanner = new Scanner(System.in);
        return new LottoTicketsManuelInputStrategy(scanner, lottoCount);
    }

    @Override
    public LottoTickets read() {
        List<LottoTicket> manualTickets = lottoCount.intStream()
            .mapToObj(count -> getLottoTicket())
            .collect(Collectors.toList());

        return LottoTickets.of(manualTickets);
    }

    private LottoTicket getLottoTicket() {
        String line = scanner.nextLine();
        validate(line);
        List<Integer> numbers = parseToNumbers(line);
        return LottoTicket.of(numbers);
    }

    private static void validate(String line) {
        if (!line.matches(LOTTO_NUMBER_REGEX)) {
            throw new LottoNumberInputRegexException();
        }
    }

    private List<Integer> parseToNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
