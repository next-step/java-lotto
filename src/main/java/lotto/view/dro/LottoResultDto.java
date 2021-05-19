package lotto.view.dro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.LottoRank;
import lotto.model.LottoResult;

public class LottoResultDto {

	List<LottoRankResultDto> lottoRankResultDtos;

	public LottoResultDto(List<LottoRankResultDto> lottoRankResultDtos) {
		this.lottoRankResultDtos = lottoRankResultDtos;
	}

	public static LottoResultDto from(LottoResult lottoResult) {
		List<LottoRank> lottoRanksToRender = Arrays.asList(LottoRank.FOUR, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);
		List<LottoRankResultDto> collect = lottoRanksToRender.stream()
			.map(lottoRank -> new LottoRankResultDto(lottoRank, lottoResult.count(lottoRank)))
			.collect(Collectors.toList());
		return new LottoResultDto(collect);
	}

	public List<LottoRankResultDto> getLottoRankResultDtos() {
		return lottoRankResultDtos;
	}
}
