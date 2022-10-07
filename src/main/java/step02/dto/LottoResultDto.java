package step02.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import step02.domain.EarningRate;
import step02.domain.LottoGrade;
import step02.domain.LottoResult;

public class LottoResultDto {

    private final List<LottoGradeDto> lottoGradeDtos = new ArrayList<>();
    private final EarningRateDto earningRateDto;

    public LottoResultDto(List<LottoGradeDto> lottoGradeDtos, EarningRateDto earningRate) {
        this.earningRateDto = earningRate;
        this.lottoGradeDtos.addAll(lottoGradeDtos);
    }

    public static LottoResultDto of(LottoResult lottoResult, EarningRate earningRate) {
        Map<LottoGrade, Integer> lottoGradeResultMap = lottoResult.getLottoGradeResultMap();
        List<LottoGradeDto> lottoGradeDtos = Arrays.stream(LottoGrade.values())
            .map(lottoGrade -> LottoGradeDto.of(lottoGrade, lottoGradeResultMap.getOrDefault(lottoGrade, 0)))
            .collect(Collectors.toList());

        return new LottoResultDto(lottoGradeDtos, EarningRateDto.from(earningRate));
    }

    public List<LottoGradeDto> getLottoGradeDtos() {
        return lottoGradeDtos;
    }

    public EarningRateDto getEarningRateDto() {
        return earningRateDto;
    }
}
