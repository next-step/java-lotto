package step3.domain;

import step3.common.WinningType;

import java.util.Arrays;
import java.util.List;

public class LottoChecker {

    public WinningType check(LottoTicket userLottoTicket, LottoTicket winningLottoTicket) {
        int matchCount = 0;
        List<LottoNumber> winningNumbers = Arrays.asList(winningLottoTicket.toArray());
        for (LottoNumber userLottoNumber : userLottoTicket.toArray()) {
            matchCount += countMatching(winningNumbers, userLottoNumber);
        }
        return WinningType.of(matchCount);
    }

    private int countMatching(List<LottoNumber> lottoNumbers, LottoNumber userLottoNumber) {
        if(lottoNumbers.contains(userLottoNumber)) {
            return 1;
        }

        return 0;
    }
}
