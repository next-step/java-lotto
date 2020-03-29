package study.lotto.domain;

import java.util.*;

public class LottoRule {
    private static final int LOTTO_NUMBER_TOTAL = 6;

    public static boolean isComplianceNumberRule(List<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) ||
                lottoNumbers.size() != LOTTO_NUMBER_TOTAL) {
            return false;
        }

        Set<Integer> uniqLottoNumbers = new HashSet<>(lottoNumbers);
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
