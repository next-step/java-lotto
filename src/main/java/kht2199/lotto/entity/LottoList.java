package kht2199.lotto.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heetaek.kim
 */
public class LottoList {

	private final List<Lotto> list;

	public LottoList() {
		list = new ArrayList<>();
	}

	public LottoList(List<Lotto> lottoList) {
		this.list = new ArrayList<>(lottoList);
	}

	public void addLotto(Lotto lotto) {
		this.list.add(lotto);
	}

	public void addLottoNumbers(LottoList lottoList) {
		if (lottoList.isEmpty()) {
			return;
		}
		list.addAll(lottoList.list);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return list.size();
	}

	public int countAuto() {
		return (int) this.list.stream()
			.filter(Lotto::isAuto)
			.count();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Lotto lotto : list) {
			sb.append(lotto.toString()).append('\n');
		}
		return sb.toString().trim();
	}

	public Rank[] calculateRanks(Lotto winningNumber, LottoNumber bonusNumber) {
		return list.stream()
			.map(lotto -> lotto.calculateRank(winningNumber, bonusNumber))
			.toArray(Rank[]::new);
	}
}
