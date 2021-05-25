package lotto.domain;

import static lotto.domain.LottoRank.*;
import static lotto.util.ValidationUtils.*;

import java.util.ArrayList;
import java.util.List;

public class LottoVendor {

	private static final String DUPLICATED_LOTTO_NUMBER_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

	private final LottoTicket winningLottoTicket;
	private final LottoNumber bonusNumber;

	public LottoVendor(String winningLottoNumbers, String bonusNumberString) {
		validateNumber(bonusNumberString);

		winningLottoTicket = new LottoTicket(winningLottoNumbers);
		bonusNumber = LottoNumber.of(Integer.parseInt(bonusNumberString));

		validateIntersectWinningNumber();
	}

	private void validateIntersectWinningNumber() {
		if (winningLottoTicket.matchNumber(bonusNumber)) {
			throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_MESSAGE);
		}
	}

	public LottoReport report(List<LottoTicket> lottoTickets) {
		List<LottoRank> lottoRankList = new ArrayList<>();
		addLottoRanks(lottoTickets, lottoRankList);

		return new LottoReport(lottoRankList);
	}

	private void addLottoRanks(List<LottoTicket> lottoTickets, List<LottoRank> lottoRankList) {
		for (LottoTicket lottoTicket : lottoTickets) {
			lottoRankList.add(lottoRank(lottoTicket));
		}
	}

	private LottoRank lottoRank(LottoTicket lottoTicket) {
		return LottoRank.rank(lottoPoint(lottoTicket, matchCount(lottoTicket)));
	}

	/**
	 * 로또 번호가 5개 일치하면 2등 여부 확인을 위해 보너스 번호를 비교한다.
	 *
	 * @param lottoTicket 유저 로또 티켓
	 * @param matchCount 당첨 번호가 일치하는 번호 수
	 * @return 로또 포인트
	 */
	private LottoPoint lottoPoint(LottoTicket lottoTicket, int matchCount) {
		if (matchCount == SECOND.matchCount()) {
			new LottoPoint(matchCount, lottoTicket.matchNumber(bonusNumber));
		}

		return new LottoPoint(matchCount);
	}

	private int matchCount(LottoTicket lottoTicket) {
		return LottoTicket.compare(lottoTicket, winningLottoTicket);
	}

}
