package nextstep.step2;

import nextstep.step2.domain.*;
import nextstep.step2.view.LottoResultView;
import nextstep.step2.view.LottoTicketView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

	public List<Lotto> startLottoGameGetLottos(LottoCount lottoCount, String manaulLottos, LottoResultView resultView) {
		resultView.printLottoPurchase(lottoCount);
		return printLottoListAndReturnLottos(lottoCount, manaulLottos);
	}

	public void printLottoStaticsic(LottoStaticstic lottoStaticstic, List<Lotto> lottoList, LottoResultView resultView) {
		Map<LottoReward, List<Lotto>> lottoRewardListMap = lottoStaticstic.getLottoRewardMap(lottoList);
		resultView.printLottoStaticsic(lottoRewardListMap);
		resultView.printWinningProbability(lottoStaticstic.calculateWinningProbability(lottoRewardListMap));
	}

	private List<Lotto> printLottoListAndReturnLottos(LottoCount lottoCount, String manaulLottos) {
		List<Lotto> manualList = purchaseManualLottos(manaulLottos);
		List<Lotto> autoList = purchaseAutoLottos(lottoCount.getAuto());
		List<Lotto> purchaseLottos = mergeLottos(manualList, autoList);
		new LottoTicketView().printLottoTickets(purchaseLottos);
		return purchaseLottos;
	}

	protected List<Lotto> purchaseManualLottos(String manualLottos) {
		String[] lottoNumbers = manualLottos.split(":");
		List<Lotto> lottos = new ArrayList<>(lottoNumbers.length);
		for(String numbers : lottoNumbers) {
			lottos.add(Lotto.of(numbers));
		}
		return lottos;
	}

	protected List<Lotto> purchaseAutoLottos(int lottoCount) {
		LottoAutoGenerator lottoGenerator = new LottoAutoGenerator();
		List<Lotto> lottos = new ArrayList<>(lottoCount);
		for(int i = 0; i < lottoCount; i++) {
			lottos.add(lottoGenerator.getAutoNumbers());
		}
		return lottos;
	}

	protected List<Lotto> mergeLottos(List<Lotto> manaual, List<Lotto> auto) {
		return Stream.of(manaual, auto)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());

	}
}
