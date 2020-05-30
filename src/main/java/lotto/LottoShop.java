package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    private LottoGenerator lottoGenerator;

    public LottoShop(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<LottoTicket> buy(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(integer -> lottoGenerator.generate())
                .collect(Collectors.toList());
    }
}
