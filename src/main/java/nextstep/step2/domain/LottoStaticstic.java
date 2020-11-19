package nextstep.step2.domain;

import java.util.*;
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

	public Map<LottoReward, List<WinningLotto>> getLottoRewardMap(List<Lotto> lottoList) {
		Lotto lastWeekLotto = new LastWeekLotto().getLastWeekLotto(winnerNumbers);
		bonusNumber.validateBonusNumber(lastWeekLotto);
		Map<LottoReward, List<WinningLotto>> lottoRewardListMap = getLottoRewardGroupingMap(lottoList, lastWeekLotto);
		addLottoEmptyReward(lottoRewardListMap);  //로또번호가 3개 이상 맞지 않아도 출력하기 위해서 추가한다.
		return lottoRewardListMap;
	}

	private Map<LottoReward, List<WinningLotto>> getLottoRewardGroupingMap(List<Lotto> lottoList, Lotto lastWeekLotto) {
		List<WinningLotto> winningLottos = lottoList.stream()
				.map(lotto -> new WinningLotto(lotto, lastWeekLotto, bonusNumber))
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		return winningLottos.stream()
				.collect(Collectors.groupingBy(WinningLotto::getLottoReward));
	}

	public float calculateWinningProbability(Map<LottoReward, List<WinningLotto>> lottoResultMap) {
		int totalAmount = lottoResultMap.keySet()
				.stream()
				.map(reward -> reward.getWinningMoney() * lottoResultMap.get(reward).size())
				.reduce(0, Integer::sum);
		return (float) totalAmount / (purchase.getLottoCount() * purchase.LOTTO_PRICE);
	}

	private void addLottoEmptyReward(Map<LottoReward, List<WinningLotto>> lottoRewardListMap) {
		Stream.of(LottoReward.values()).forEach(lottoReward -> {
			if (!lottoRewardListMap.keySet().contains(lottoReward)) {
				lottoRewardListMap.put(lottoReward, new ArrayList<>());
			}
		});
	}
}
