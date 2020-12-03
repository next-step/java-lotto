package lotto.automatic.domain;

import lotto.automatic.util.NumberStringParser;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String rawNumberString, int bonusNumber) {
        List<LottoNumber> nums = NumberStringParser.parseString(rawNumberString);

        Lotto winningLotto = new Lotto(nums);
        LottoNumber bonusLottoNumber = LottoNumber.of(bonusNumber);

        validate(winningLotto, bonusLottoNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusLottoNumber;
    }

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {

        validate(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, LottoNumber bonusNumber) {

        if(lotto.contain(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호에 포함될 수 없습니다.");
        }
    }

    public LottoRank getRank(Lotto lotto) {

        return LottoRank.match(lotto.matchCount(winningLotto), lotto.contain(bonusNumber));
    }

    public List<LottoRank> getRankList(List<Lotto> lottoList) {

        List<LottoRank> rankList = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            rankList.add(getRank(lotto));
        }

        return rankList;
    }
}
