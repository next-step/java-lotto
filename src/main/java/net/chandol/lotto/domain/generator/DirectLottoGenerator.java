package net.chandol.lotto.domain.generator;

import net.chandol.lotto.domain.Lotto;
import net.chandol.lotto.dto.PurchaseRequest;
import net.chandol.lotto.value.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class DirectLottoGenerator implements LottoGenerator {

    public DirectLottoGenerator() {
    }

    @Override
    public List<Lotto> generate(PurchaseRequest request) {
        List<LottoNumber> directLottoNumbers = request.getDirectLottoNumbers();
        List<Lotto> lottos = directLottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());

        return lottos;
    }
}
