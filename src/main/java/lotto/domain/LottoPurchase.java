package lotto.domain;

import java.util.List;

/**
 * 로또 구입 전략
 */
public interface LottoPurchase {

    List<LottoTicket> purchase(final PurchaseAmount amount);
}
