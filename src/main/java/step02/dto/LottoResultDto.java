package step02.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import step02.domain.LottoGrade;
import step02.domain.LottoResult;

public class LottoResultDto {

    private final List<LottoGradeDto> lottoGradeDtos = new ArrayList<>();
    private final float earningRate;

    public LottoResultDto(List<LottoGradeDto> lottoGradeDtos, float earningRate) {
        this.earningRate = earningRate;
        this.lottoGradeDtos.addAll(lottoGradeDtos);
    }

    public static LottoResultDto of(LottoResult lottoResult, float earningRate) {
        Map<LottoGrade, Integer> lottoGradeResultMap = lottoResult.getLottoGradeResultMap();
        List<LottoGradeDto> lottoGradeDtos = Arrays.stream(LottoGrade.values())
            .map(lottoGrade -> LottoGradeDto.of(lottoGrade, lottoGradeResultMap.getOrDefault(lottoGrade, 0)))
            .collect(Collectors.toList());

        return new LottoResultDto(lottoGradeDtos, earningRate);
    }

    public List<LottoGradeDto> getLottoGradeDtos() {
        return lottoGradeDtos;
    }

    public float getEarningRate() {
        return earningRate;
    }
}
