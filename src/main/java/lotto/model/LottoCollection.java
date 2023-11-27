package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoCollection {

	private final ArrayList<LottoNumber> lottoNumberList;

	public LottoCollection(int numberOfLottoTickets, RandomGenerator randomGenerator) {
		this.lottoNumberList = new ArrayList<>();
		for (int i = 0; i < numberOfLottoTickets; i++) {
			this.lottoNumberList.add(new LottoNumber(randomGenerator.generate()));
		}
	}

	public List<LottoNumber> getLottoNumberList() {
		return this.lottoNumberList;
	}

	public List<LottoRank> lottoRanks(LottoNumber winningNumbers) {
		List<LottoRank> lottoRanks = new ArrayList<>();
		for (LottoNumber lottoNumber : lottoNumberList) {
			lottoRanks.add(lottoRank(lottoNumber
					.getLottoNumbers()
					.stream()
					.filter(winningNumbers.getLottoNumbers()::contains)
					.count()));
		}
		return lottoRanks;
	}

	private LottoRank lottoRank(long rank) {
		return Arrays.stream(LottoRank.values())
				.filter(lottoRank -> lottoRank.rank() == rank)
				.findAny()
				.orElse(LottoRank.BLANK);
	}

}
