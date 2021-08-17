package lotto.domain.generator;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    List<LottoTicketGenerator> generators;

    public List<LottoTicket> autoCreate(int autoLottoCount) {
        generators = new ArrayList<>();
        IntStream.range(0, autoLottoCount).forEach(i -> generators.add(new AutoLottoTicketGenerator()));
        return generators.stream().map(LottoTicketGenerator::generate).collect(Collectors.toList());
    }

    public LottoTicket manualCreate(int... lottoTicketNumbers) {
        return ManualLottoTicketGenerator.of(lottoTicketNumbers).generate();
    }
}
