package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.machine.LottoGenerator;
import lotto.domain.shop.LottoShop;
import lotto.view.dto.LottoDto;
import lotto.view.dto.LottoOrderDto;
import lotto.view.dto.LottoOrderResultDto;

public class LottoShoppingService {
    private final LottoGenerator lottoGenerator;

    public LottoShoppingService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoOrderResultDto purchase(LottoOrderDto lottoOrderDto) {
        LottoShop lottoShop = new LottoShop(lottoOrderDto.getMoney(), lottoGenerator);

        List<Lotto> lotteries = lottoShop.purchase();
        List<LottoDto> lottoDtoList = lotteries.stream()
                .map(Lotto::copyLottoNumbers)
                .map(LottoDto::new)
                .collect(Collectors.toList());

        return new LottoOrderResultDto(lottoDtoList);
    }


}
