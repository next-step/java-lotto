package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningLotto {

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(LottoNumbers winningLottoNumbers, String bonusNumber) {
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(Integer.parseInt(bonusNumber));
        if (winningLottoNumbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호에 포함될 수 없습니다.");
        }

        this.lottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public Map<Rank, Integer> countPerRank(Games games) {
        List<Rank> rankForGames = games.checkResult(lottoNumbers, bonusLottoNumber);

        return Arrays.stream(Rank.values())
                .collect(Collectors.toUnmodifiableMap(
                        rank -> rank,
                        rank -> Collections.frequency(rankForGames, rank))
                );
    }

    public double calculateEarningRate(Games games) {
        double rate = (double) calculatePrize(games) / games.count() / LottoNumbers.PRICE;

        int decimalPlaces = 2;
        double decimalPlacesCorrectionValue = Math.pow(10, decimalPlaces);

        return Math.round(rate * decimalPlacesCorrectionValue) / decimalPlacesCorrectionValue;
    }

    private long calculatePrize(Games games) {
        return countPerRank(games).entrySet()
                .stream()
                .map(entry -> {
                    Rank rank = entry.getKey();
                    Integer count = entry.getValue();
                    return (long) rank.wins() * count;
                })
                .reduce(0L, Long::sum);
    }
}
