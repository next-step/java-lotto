package lotto.domain;

import lotto.generator.AutoLottoNumberGenerator;
import lotto.generator.ManualLottoNumberGenerator;
import lotto.matcher.LottoMatcher;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoBuyer {
    private final LottoShop lottoShop;
    private int price;
    private int availablePurchaseCount;
    private final LottoTickets lottoTickets;

    public LottoBuyer(int price, LottoShop lottoShop, LottoTickets lottoTickets) {
        this.validateLottoShop(lottoShop);
        this.price = price;
        this.lottoShop = lottoShop;
        this.lottoShop.availablePurchase(price);
        this.availablePurchaseCount = lottoShop.calculatePurchaseCount(this.price);
        this.lottoTickets = lottoTickets;
    }

    private void validateLottoShop(LottoShop lottoShop) {
        if (Objects.isNull(lottoShop)) {
            throw new IllegalArgumentException("LottoShop is not null");
        }
    }

    public LottoTickets buyLotto() {
        List<LottoTicket> manualLottoTickets = this.buyManualLottos();
        List<LottoTicket> autoLottoTickets = this.buyAutoLottos();
        List<LottoTicket> mergeLottoTickets = Stream.of(manualLottoTickets, autoLottoTickets)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return new LottoTickets(mergeLottoTickets);
    }

    private List<LottoTicket> buyManualLottos() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<LottoTicket> purchaseLottoTickets = this.lottoTickets.getLottoTickets();
        for (LottoTicket lottos : purchaseLottoTickets) {
            LottoTicket lottoTicket = lottoShop.buyLotto(new ManualLottoNumberGenerator(), lottos.getLotto(), LottoNumbers.LOTTO_SIZE);
            this.availablePurchaseCount--;
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    private List<LottoTicket> buyAutoLottos() {
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

    private void validateAvailablePurchaseCount(int manualCount) {
        if (manualCount > this.availablePurchaseCount) {
            throw new IllegalArgumentException();
        }
    }

    public BigDecimal calculateEarningsRate(List<LottoMatcher> lottoMatchers) {
        return this.lottoShop.calculateEarningsRate(lottoMatchers, this.price);
    }
}
