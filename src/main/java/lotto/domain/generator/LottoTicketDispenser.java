package lotto.domain.generator;

/**
 * Created by hspark on 10/11/2018.
 */
public interface LottoTicketDispenser {
	PurchaseLottoTicketResultInfo purchase(PurchaseLottoTicketRequestInfo requestInfo);
}
