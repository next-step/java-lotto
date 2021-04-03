package lotto.service;

import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoOrderedList;
import lotto.domain.machine.LottoGenerator;
import lotto.domain.shop.LottoShop;
import lotto.domain.shop.Money;
import lotto.dto.LottoOrderResultDto;
import lotto.dto.LottoOrderedDto;

public class LottoShopping {
    private final LottoGenerator lottoGenerator;

    public LottoShopping(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoOrderResultDto purchase(Money money) {
        LottoShop lottoShop = new LottoShop(money, lottoGenerator);

        return toDto(lottoShop.purchase());
    }

    public LottoOrderResultDto toDto(LottoOrderedList lottoOrderedList) {
        return new LottoOrderResultDto(
                lottoOrderedList.getLottoList().stream()
                        .map(Lotto::toList)
                        .map(LottoOrderedDto::new)
                        .collect(Collectors.toList()));
    }
}
