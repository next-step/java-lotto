package net.chandol.lotto.domain.generator;

import net.chandol.lotto.domain.Lotto;
import net.chandol.lotto.dto.PurchaseRequest;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generate(PurchaseRequest request);
}