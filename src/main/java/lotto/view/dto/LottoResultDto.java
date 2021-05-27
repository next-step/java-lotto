package lotto.view.dto;

import static lotto.model.LottoRank.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.Rate;

public class LottoResultDto {

	private List<LottoRankResultDto> lottoRankResultDtos;
	private LottoEarningRateDto lottoEarningRateDto;

	public LottoResultDto(List<LottoRankResultDto> lottoRankResultDtos, LottoEarningRateDto lottoEarningRateDto) {
		this.lottoRankResultDtos = lottoRankResultDtos;
		this.lottoEarningRateDto = lottoEarningRateDto;
	}

	public static LottoResultDto toDto(LottoResult lottoResult, Rate earningRate) {
		List<LottoRank> lottoRanksToRender = Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
		List<LottoRankResultDto> lottoRankResultDtos = lottoRanksToRender.stream()
			.map(lottoRank -> new LottoRankResultDto(lottoRank, lottoResult.count(lottoRank)))
			.collect(Collectors.toList());

		LottoEarningRateDto lottoEarningRateDto = new LottoEarningRateDto(earningRate);

		return new LottoResultDto(lottoRankResultDtos, lottoEarningRateDto);
	}

	public List<LottoRankResultDto> getLottoRankResultDtos() {
		return lottoRankResultDtos;
	}

	public LottoEarningRateDto getLottoEarningRateDto() {
		return lottoEarningRateDto;
	}
}
