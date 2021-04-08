package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;
import lotto.domain.lotto.LottoOrderedList;
import lotto.domain.machine.LottoGenerator;
import lotto.domain.shop.LottoShop;
import lotto.domain.shop.Money;
import lotto.domain.shop.Order;
import lotto.dto.LottoOrderDto;
import lotto.dto.LottoOrderResultDto;
import lotto.dto.LottoOrderedDto;

public class LottoShopping {
    private final LottoGenerator lottoGenerator;

    public LottoShopping(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoOrderResultDto purchase(LottoOrderDto lottoOrderDto) {
        LottoShop lottoShop = new LottoShop(convertFromDtoToOrder(lottoOrderDto), lottoGenerator);

        return toDto(lottoShop.purchase(), lottoShop.getPreOrderedLottoCount());
    }

    public LottoOrderResultDto toDto(LottoOrderedList lottoOrderedList, int preOrderCount) {
        List<LottoOrderedDto> orderResult =
                lottoOrderedList.getLottoList().stream()
                        .map(Lotto::toList)
                        .map(LottoOrderedDto::new)
                        .collect(Collectors.toList());
        return new LottoOrderResultDto(orderResult, preOrderCount);
    }

    public Order convertFromDtoToOrder(LottoOrderDto lottoOrderDto) {
        List<Lotto> lottoList = lottoOrderDto.getManualNumberList().stream()
                .map(this::convertFromListIntegerToLotto)
                .collect(Collectors.toList());
        return new Order(new Money(lottoOrderDto.getMoney()), lottoList);
    }

    private Lotto convertFromListIntegerToLotto(List<Integer> integers) {
        return new Lotto(integers.stream()
                .map(LottoBall::new)
                .collect(Collectors.toList()));
    }
}
