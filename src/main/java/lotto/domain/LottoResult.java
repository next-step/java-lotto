package lotto.domain;

import lotto.domain.dto.LottoWinnersDto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private Map<Award, Long> lottoResult;

    public LottoResult(Map<Award, Long> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public List<LottoWinnersDto> createLottoWinnerDtos() {
        Map<Award, Long> result = formatResult();
        return result.entrySet().stream()
                .filter(e -> isNotBang(e.getKey()))
                .map(e -> new LottoWinnersDto(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private Map<Award, Long> formatResult() {
        Map<Award, Long> result = new HashMap(this.lottoResult);
        for (Award award : Award.values()) {
            result.putIfAbsent(award, 0L);
        }
        return result;
    }

    private boolean isNotBang(Award award) {
        return !award.equals(Award.BANG);
    }

    public Yield calculateYield(int lottoPurchaseAmount) {
        double earnings = createLottoWinnerDtos().stream()
                .mapToDouble(lottoWinnerDto -> getYield(lottoWinnerDto.getAmount(), lottoWinnerDto.getCountWinners()))
                .sum();
        return new Yield(earnings / lottoPurchaseAmount);
    }

    private double getYield(int amount, long countWinners) {
        return amount * countWinners;
    }

    public Map<Award, Long> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
