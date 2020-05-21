package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public List<LottoTicket> purchaseLottoTicket(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        int numberOfTicket = purchaseAmount / LOTTO_PRICE;

        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTicket; i++) {
            List<LottoNumber> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();
            lottoTickets.add(new LottoTicket(lottoNumbers));
        }

        return lottoTickets;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 살 수 없습니다.");
        }
    }
}
