package lotto.domain;

import lotto.domain.dto.LottoWinnersDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoDrawResult {
    private Map<Award, Long> lottoDrawResult;

    public LottoDrawResult(Map<Award, Long> lottoDrawResult) {
        this.lottoDrawResult = lottoDrawResult;
    }

    public List<LottoWinnersDto> createLottoWinnerDtos() {
        Map<Award, Long> result = formatResult();
        return result.entrySet().stream()
                .filter(e -> isNotBang(e.getKey()))
                .map(e -> new LottoWinnersDto(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private Map<Award, Long> formatResult() {
        Map<Award, Long> result = new HashMap(this.lottoDrawResult);
        for (Award award : Award.values()) {
            result.putIfAbsent(award, 0L);
        }
        return result;
    }

    private boolean isNotBang(Award award) {
        return !award.equals(Award.BANG);
    }

    public double calculateYield(int lottoPurchaseAmount) {
        double earnings = createLottoWinnerDtos().stream()
                .mapToDouble(lottoWinnerDto -> getYield(lottoWinnerDto.getAmount(), lottoWinnerDto.getCountWinners()))
                .sum();
        return earnings / lottoPurchaseAmount;
    }

    private double getYield(int amount, long countWinners) {
        return amount * countWinners;
    }

    public Map<Award, Long> getLottoDrawResult() {
        return lottoDrawResult;
    }
}
