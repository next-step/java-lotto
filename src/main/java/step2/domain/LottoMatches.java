package step2.domain;

import java.util.*;

public class LottoMatches {
    private LottoMatches() {
    }

    public static LottoRankDTO getMatchCounts(List<LottoNumber> lottos, LottoNumber winningNumbers) {
        LottoRankDTO lottoRankDTO = new LottoRankDTO();
        for (LottoNumber lottoNumber : lottos) {
            lottoRankDTO.setMatchCount(countMatchedNumbers(lottoNumber, winningNumbers));
        }
        return lottoRankDTO;
    }

    public static int countMatchedNumbers(LottoNumber numbersToMatch, LottoNumber numbersToCompare) {
        return (int) numbersToMatch.getNumbers().stream()
                .filter(numbersToCompare.getNumbers()::contains)
                .count();
    }
}
