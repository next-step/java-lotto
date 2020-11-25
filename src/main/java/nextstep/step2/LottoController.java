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

	public Lottos startLottoGameGetLottos(LottoCount lottoCount, String manaulLottos, LottoResultView resultView) {
		resultView.printLottoPurchase(lottoCount);
		return printLottoListAndReturnLottos(lottoCount, manaulLottos);
	}

	public void printLottoStaticsic(LottoStaticstic lottoStaticstic, Lottos lottos, LottoResultView resultView) {
		Map<LottoReward, List<Lotto>> lottoRewardListMap = lottoStaticstic.getLottoRewardMap(lottos);
		resultView.printLottoStaticsic(lottoRewardListMap);
		resultView.printWinningProbability(lottoStaticstic.calculateWinningProbability(lottoRewardListMap));
	}

	private Lottos printLottoListAndReturnLottos(LottoCount lottoCount, String manaulLottos) {
		List<Lotto> manualList = purchaseManualLottos(manaulLottos);
		List<Lotto> autoList = purchaseAutoLottos(lottoCount.getAuto());
		Lottos purchaseLottos = mergeLottos(manualList, autoList);
		LottoTicketView.printLottoTickets(purchaseLottos);
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

	protected Lottos mergeLottos(List<Lotto> manaual, List<Lotto> auto) {
		List<Lotto> mergeList = Stream.of(manaual, auto)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		return new Lottos(mergeList);
	}
}
