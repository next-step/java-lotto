package lotto.domain.generator;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hspark on 10/11/2018.
 */
public class PurchaseLottoTicketResultInfo {
	private List<LottoTicket> autoTickets;
	private List<LottoTicket> manualTickets;

	public PurchaseLottoTicketResultInfo(List<LottoTicket> autoTickets, List<LottoTicket> manualTickets) {
		this.autoTickets = autoTickets;
		this.manualTickets = manualTickets;
	}

	public List<LottoTicket> getAutoTickets() {
		return Collections.unmodifiableList(autoTickets);
	}

	public List<LottoTicket> getManualTickets() {
		return Collections.unmodifiableList(manualTickets);
	}

	public List<LottoTicket> getTickets() {
		List<LottoTicket> mergeList = new ArrayList<>(autoTickets);
		mergeList.addAll(manualTickets);
		return Collections.unmodifiableList(mergeList);
	}

	/**
	 * autoTickets, manualTickets 순서 혼동 방지를 위한 빌더 패턴
	 * @return PurchaseLottoTicketsBuilder
	 */
	public static PurchaseLottoTicketsBuilder builder() {
		return new PurchaseLottoTicketsBuilder();
	}

	public static class PurchaseLottoTicketsBuilder {
		private List<LottoTicket> autoTickets;
		private List<LottoTicket> manualTickets;

		public PurchaseLottoTicketsBuilder autoTickets(List<LottoTicket> autoTickets) {
			this.autoTickets = autoTickets;
			return this;
		}

		public PurchaseLottoTicketsBuilder manualTickets(List<LottoTicket> manualTickets) {
			this.manualTickets = manualTickets;
			return this;
		}

		public PurchaseLottoTicketResultInfo build() {
			return new PurchaseLottoTicketResultInfo(autoTickets, manualTickets);
		}
	}
}
