package lotto.domain;

import lotto.generator.AutoLottoNumberGenerator;
import lotto.generator.ManualLottoNumberGenerator;
import lotto.matcher.LottoMatcher;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoBuyer {
    private int price;
    private int availablePurchaseCount;
    private final LottoTickets lottoTickets;

    public LottoBuyer(int price, LottoTickets lottoTickets) {
        this.price = price;
        this.lottoTickets = lottoTickets;
    }

    private void validateLottoShop(LottoShop lottoShop) {
        if (Objects.isNull(lottoShop)) {
            throw new IllegalArgumentException("LottoShop is not null");
        }
    }

    public LottoTickets buyLotto(LottoShop lottoShop) {
        this.validateLottoShop(lottoShop);
        this.availablePurchaseCount = lottoShop.calculatePurchaseCount(this.price);

        List<LottoTicket> manualLottoTickets = this.buyManualLottos(lottoShop);
        List<LottoTicket> autoLottoTickets = this.buyAutoLottos(lottoShop);
        List<LottoTicket> mergeLottoTickets = Stream.of(manualLottoTickets, autoLottoTickets)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return new LottoTickets(mergeLottoTickets);
    }

    private List<LottoTicket> buyManualLottos(LottoShop lottoShop) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<LottoTicket> purchaseLottoTickets = this.lottoTickets.getLottoTickets();
        for (LottoTicket lottos : purchaseLottoTickets) {
            LottoTicket lottoTicket = lottoShop.buyLotto(new ManualLottoNumberGenerator(), lottos.getLotto(), LottoNumbers.LOTTO_SIZE);
            this.availablePurchaseCount--;
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    private List<LottoTicket> buyAutoLottos(LottoShop lottoShop) {
        if (this.availablePurchaseCount == 0) {
            return Collections.EMPTY_LIST;
        }

        List<LottoTicket> lottoTickets = new ArrayList<>();
        while (this.availablePurchaseCount > 0) {
            LottoTicket lottoTicket = lottoShop.buyLotto(new AutoLottoNumberGenerator(), LottoNumbers.LOTTO_NUMBERS, LottoNumbers.LOTTO_SIZE);
            this.availablePurchaseCount--;
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public BigDecimal calculateEarningsRate(List<LottoMatcher> lottoMatchers, LottoShop lottoShop) {
        this.validateLottoShop(lottoShop);
        return lottoShop.calculateEarningsRate(lottoMatchers, this.price);
    }
}
