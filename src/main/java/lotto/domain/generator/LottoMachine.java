package lotto.domain.generator;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    List<LottoTicketGenerator> generators;

    public LottoTickets autoCreate(int autoLottoCount) {
        generators = new ArrayList<>();
        IntStream.range(0, autoLottoCount).forEach(i -> generators.add(new AutoLottoTicketGenerator()));
        return LottoTickets.from(
            generators.stream()
                .map(LottoTicketGenerator::generate)
                .collect(Collectors.toList())
        );
    }

    public LottoTicket manualCreate(int... lottoTicketNumbers) {
        return ManualLottoTicketGenerator.of(lottoTicketNumbers).generate();
    }

    public LottoTicket manualCreate(List<Integer> lottoTicketNumbers) {
        return ManualLottoTicketGenerator.of(
            lottoTicketNumbers.stream()
                .mapToInt(Integer::intValue)
                .toArray()
        ).generate();
    }

    public LottoTickets oneTimeCreate(LottoTickets manualLottoTickets, int autoLottoCount) {
        List<LottoTicket> tickets = manualLottoTickets.toList();

        generators = new ArrayList<>();
        IntStream.range(0, autoLottoCount).forEach(i -> generators.add(new AutoLottoTicketGenerator()));
        tickets.addAll(LottoTickets.from(
            generators.stream()
                .map(LottoTicketGenerator::generate)
                .collect(Collectors.toList())).toList());

        return LottoTickets.from(tickets);
    }
}
