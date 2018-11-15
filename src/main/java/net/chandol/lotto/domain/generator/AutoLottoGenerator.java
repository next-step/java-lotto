package net.chandol.lotto.domain.generator;

import net.chandol.lotto.domain.Lotto;
import net.chandol.lotto.dto.PurchaseRequest;
import net.chandol.lotto.value.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutoLottoGenerator implements LottoGenerator {
    public AutoLottoGenerator() {
    }

    @Override
    public List<Lotto> generate(PurchaseRequest request) {
        int availableLottoCount = request.getAutoLottoCount();
        return Stream.generate(LottoNumber::auto)
                .limit(availableLottoCount)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
