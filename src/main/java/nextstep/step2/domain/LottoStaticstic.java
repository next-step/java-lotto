package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStaticstic {
	private String winnerNumbers;
	private LottoPurchase purchase;
	private LottoNumber bonusNumber;

	public LottoStaticstic(String winnerNumbers, LottoPurchase purchase, LottoNumber bonusNumber) {
		this.winnerNumbers = winnerNumbers;
		this.purchase = purchase;
		this.bonusNumber = bonusNumber;
	}

	public Map<LottoReward, List<Lotto>> getLottoRewardMap(List<Lotto> lottoList) {
		Lotto lastWeekLotto = new Lotto().getLastWeekLotto(winnerNumbers);
		lastWeekLotto.validate();
		bonusNumber.validateBonusNumber(lastWeekLotto);
		Map<LottoReward, List<Lotto>> lottoRewardListMap = getLottoRewardGroupingMap(lottoList, lastWeekLotto);
		addLottoEmptyReward(lottoRewardListMap);  //로또번호가 3개 이상 맞지 않아도 출력하기 위해서 추가한다.
		return lottoRewardListMap;
	}

	private Map<LottoReward, List<Lotto>> getLottoRewardGroupingMap(List<Lotto> lottoList, Lotto lastWeekLotto) {
		WinningLotto winningLotto = new WinningLotto(lastWeekLotto, bonusNumber);
		lottoList.forEach(lotto -> lotto.setLottoReward(winningLotto));
		return lottoList.stream()
				.collect(Collectors.groupingBy(Lotto::getLottoReward));
	}

	public float calculateWinningProbability(Map<LottoReward, List<Lotto>> lottoResultMap) {
		int totalAmount = lottoResultMap.keySet()
				.stream()
				.map(reward -> reward.getWinningMoney() * lottoResultMap.get(reward).size())
				.reduce(0, Integer::sum);
		return (float) totalAmount / (purchase.getLottoCount() * purchase.LOTTO_PRICE);
	}

	private void addLottoEmptyReward(Map<LottoReward, List<Lotto>> lottoRewardListMap) {
		Stream.of(LottoReward.values()).forEach(lottoReward -> {
			if (!lottoRewardListMap.keySet().contains(lottoReward)) {
				lottoRewardListMap.put(lottoReward, new ArrayList<>());
			}
		});
	}
}
