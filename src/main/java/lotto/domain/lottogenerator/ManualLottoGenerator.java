package lotto.domain.lottogenerator;

import lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private final List<List<Integer>> numbers;

    public ManualLottoGenerator(final List<List<Integer>> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<LottoTicket> create() {
        return numbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

}
