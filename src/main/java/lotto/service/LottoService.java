package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.MatchPointRank;

import java.util.List;

import static lotto.util.Util.parseIntegerList;

public class LottoService {

    private final List<Lotto> lottoList;
    private final MatchPointRank matchPointRank;

    public LottoService(List<Lotto> lottoList, MatchPointRank matchPointRank) {
        this.lottoList = lottoList;
        this.matchPointRank = matchPointRank;
    }

    public void playLotto(List<String> winningNumerList, int bonusNumber) {
        List<Integer> integerWinningList = parseIntegerList(winningNumerList);

        invalidBonusNumber(integerWinningList, bonusNumber);

        this.compareLottoWinningNumber(integerWinningList);
        this.compareLottoBonusNumber(bonusNumber);

        for (Lotto lotto : lottoList) {
            matchPointRank.compareMatchPoint(lotto);
        }
    }

    private void compareLottoWinningNumber(List<Integer> winningNumberList) {
        for (Lotto lotto : this.lottoList) {
            lotto.compareWinningNumber(winningNumberList);
        }
    }

    private void compareLottoBonusNumber(int bonusNumber) {
        for (Lotto lotto : this.lottoList) {
            lotto.addBonusMatchPoint(bonusNumber);
        }
    }

    public MatchPointRank getMatchPointMap() {
        return this.matchPointRank;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    private void invalidBonusNumber(List<Integer> integerList, int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
           throw new IllegalArgumentException("1 ~ 45 사이 보너스 볼만 입력 가능 합니다.");
        }

        if(integerList.contains(bonusNumber)) {
            throw new IllegalArgumentException("해당 번호는 이미 입력된 당첨번호 입니다.");
        }
    }

}
