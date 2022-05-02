package lottoauto.service;

import lottoauto.domain.Lotto;
import lottoauto.domain.LottoGenerator;
import lottoauto.domain.LottoReport;
import lottoauto.domain.LottoStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * - 금액을 입력 받아 로또 게임을 하는 클래스를 만든다.
 * - 1000원 금액에 맞는 로또 갯수만큼 로또 클래스를 생성한다.
 * - 당첨 로또를 생성한다.
 * - 당첨 통계를 출력한다.
 * - 3개(5000원), 4개(50000원), 5개(1500000원), 6개(2000000000) 일치갯수(당첨금액) 별 결과를 통계 점수에 보여준다.
 * - 총 수익률을 계산한다.(로또게임 입력 금액 / 당첨금액)
 */
public class LottoGame {
    private final int money;
    private final int lottoCount;

    private final List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;
    private int firstWinningCount = 0;
    private int secondWinningCount = 0;
    private int thirdWinningCount = 0;
    private int fourthWinningCount = 0;
    private int fifthWinningCount = 0;

    public LottoGame(int money) {
        if(money < Lotto.PRICE) {
            throw new IllegalArgumentException("로또를 살 수 없습니다.");
        }
        this.money = money;
        this.lottoCount = money / Lotto.PRICE;
        System.out.println(this.lottoCount+"개를 구매했습니다.");
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getFirstWinningCount() {
        return firstWinningCount;
    }

    public int getSecondWinningCount() {
        return secondWinningCount;
    }

    public int getThirdWinningCount() {
        return thirdWinningCount;
    }

    public int getFourthWinningCount() {
        return fourthWinningCount;
    }

    public int getFifthWinningCount() {
        return fifthWinningCount;
    }

    public List<Lotto> all() {
        return Collections.unmodifiableList(lottos);
    }

    public void checkWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void buyLotto() {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoGenerator.makeLotto());
        }
    }

    public void start() {
        for (Lotto lotto : lottos) {
            lotto.match(winningLotto);
            if(lotto.isStatus() == LottoStatus.FIFTH) fifthWinningCount += 1;
            if(lotto.isStatus() == LottoStatus.FOURTH) fourthWinningCount += 1;
            if(lotto.isStatus() == LottoStatus.THIRD) thirdWinningCount += 1;
            if(lotto.isStatus() == LottoStatus.SECOND) secondWinningCount += 1;
            if(lotto.isStatus() == LottoStatus.FIRST) firstWinningCount += 1;
        }
    }

    public int getProfitRate() {
        int totalWinningMoney = LottoStatus.FIFTH.getWinningMoney() * getFifthWinningCount()
                + LottoStatus.FOURTH.getWinningMoney() * getFourthWinningCount()
                + LottoStatus.THIRD.getWinningMoney() * getThirdWinningCount()
                + LottoStatus.SECOND.getWinningMoney() * getSecondWinningCount()
                + LottoStatus.FIRST.getWinningMoney() * getFirstWinningCount();
        return totalWinningMoney / this.money;
    }

    public LottoReport report(){
        return new LottoReport(getFifthWinningCount(), getFourthWinningCount(), getThirdWinningCount(), getSecondWinningCount(), getFirstWinningCount(), getProfitRate());
    }
}
