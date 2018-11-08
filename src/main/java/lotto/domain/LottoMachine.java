package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.PurchaseInfo;
import lotto.dto.WinningNumber;
import lotto.utils.LottoNumberGenerator;

public class LottoMachine {

	public static final int LOTTO_PRICE = 1000;

	private PurchaseInfo purchaseInfo;
	private LottoNumberGenerator lottoNumberGenerator;

	public LottoMachine(PurchaseInfo purchaseInfo) {
		if(purchaseInfo.getMoney() < LOTTO_PRICE) {
			throw new IllegalArgumentException("1개 이상부터 구매 가능합니다.");
		}
		this.purchaseInfo = purchaseInfo;
		this.lottoNumberGenerator = new LottoNumberGenerator();
	}

	public LottoTicket getLottos() {
		List<Lotto> lottos = manualPick();
		lottos.addAll(quickPick());
		return new LottoTicket(lottos);
	}

	private List<Lotto> manualPick() {
		return purchaseInfo.getManualNumbers().stream()
				.map(manualNumber -> getLotto(manualNumber))
				.collect(Collectors.toList());
	}

	private List<Lotto> quickPick() {
		List<Lotto> lottos = new ArrayList<>();
		for(int count = 1; count <= purchaseInfo.getQuickPickCount(); count++) {
			lottos.add(getLotto());
		}
		return lottos;
	}

	private Lotto getLotto() {
		return new Lotto(lottoNumberGenerator.pick());
	}

	public Lotto getLotto(String number) {
		return new Lotto(lottoNumberGenerator.pick(number), true);
	}

	public WinningLotto getWinningLotto(WinningNumber winningNumber) {
		Lotto lotto = getLotto(winningNumber.getWinningNumber());
		int bonusNumber = winningNumber.getBonusNumber();
		if(lotto.hasNumber(bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
		}
		return new WinningLotto(lotto, bonusNumber);
	}
}
