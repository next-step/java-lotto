package step2.model;

import step2.util.LottoGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
	private final static int LOTTO_PRICE = 1000;

	private final int ticketCnt;
	private final int money;
	private final List<Lotto> lottos;
	private final LottoGenerator lottoGenerator;

	public Lottos(final int money, final LottoGenerator lottoGenerator) {
		this.money = money;
		this.ticketCnt = money / LOTTO_PRICE;
		this.lottoGenerator = lottoGenerator;
		lottos = generateLottos();
	}

	private List<Lotto> generateLottos() {
		return IntStream.range(0, ticketCnt)
						.mapToObj(i -> Lotto.generate(lottoGenerator))
						.collect(Collectors.toList());
	}

	public Map<Integer, Integer> checkHit(final List<Integer> hitNumber) {
		Map<Integer, Integer> hitMap = new HashMap<>();
		lottos.stream()
				.mapToInt(lotto -> lotto.checkHit(hitNumber))
				.forEachOrdered(hitCnt -> hitMap.put(hitCnt, hitMap.containsKey(hitCnt) ? hitMap.get(hitCnt) + 1 : 1));
		return hitMap;
	}

	public Double getEarningRate(Map<Integer, Integer> hitCntMap){
		int prizeMoney = 0;
		for(int cnt : hitCntMap.keySet()){
			prizeMoney += Awards.findAward(cnt).getAward() * hitCntMap.get(cnt);
		}

		return (double) (prizeMoney / money);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public int getTicketCnt() {
		return ticketCnt;
	}
}
