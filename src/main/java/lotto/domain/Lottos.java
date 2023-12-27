package lotto.domain;

import java.util.List;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos){
		this.lottos = lottos;
	}

	public Lotto indexOfLottos(int index){
		return lottos.get(index);
	}

	public int contains(List<Integer> winningNumbers) {
		int count = 0;
		for (Lotto lotto : lottos){
			for (Integer winningNumber : winningNumbers){
				if(lotto.equals(winningNumber)){
					count++;
				}
			}
		}
		return count;
	}
}
