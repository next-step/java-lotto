package study.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRule {
    private static final int LOTTO_NUMBER_TOTAL = 6;

    public static boolean isComplianceNumberRule(int[] lottoNumbers) {
        if (Objects.isNull(lottoNumbers) ||
                lottoNumbers.length != LOTTO_NUMBER_TOTAL) {
            return false;
        }

        Set<Integer> uniqLottoNumbers = IntStream.of(lottoNumbers)
                .boxed()
                .collect(Collectors.toSet());
        if (uniqLottoNumbers.size() != LOTTO_NUMBER_TOTAL) {
            return false;
        }

        return true;
    }

    public static LottoRank getWinningRank(LottoTicket lottoTicket,
                                           LottoWinningNumber lottoWinningNumber) {
        List<LottoNumber> matches = lottoWinningNumber.getMatches(lottoTicket);

        if(matches.size() == 3) {
            return LottoRank.FOURTH;
        } else if(matches.size() == 4) {
            return LottoRank.THIRD;
        } else if(matches.size() == 5) {
            return LottoRank.SECOND;
        } else if(matches.size() == 6) {
            return LottoRank.FIRST;
        }

        return null;
    }
}
