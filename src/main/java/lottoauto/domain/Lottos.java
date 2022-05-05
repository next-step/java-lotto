package lottoauto.domain;

import lottoauto.domain.Lotto;
import lottoauto.domain.LottoGenerator;
import lottoauto.domain.LottoReport;
import lottoauto.domain.LottoStatus;

import java.util.*;

/**
 * - 금액을 입력 받아 로또 게임을 하는 클래스를 만든다.
 * - 1000원 금액에 맞는 로또 갯수만큼 로또 클래스를 생성한다.
 * - 당첨 로또를 생성한다.
 * - 당첨 통계를 출력한다.
 * - 3개(5000원), 4개(50000원), 5개(1500000원), 6개(2000000000) 일치갯수(당첨금액) 별 결과를 통계 점수에 보여준다.
 * - 총 수익률을 계산한다.(로또게임 입력 금액 / 당첨금액)
 */
public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;
    private Map<LottoStatus, Integer> winningMap = new HashMap<>();

    public Lottos(List<Lotto> inputLottos) {
        for (int i = 0; i < inputLottos.size(); i++) {
            this.lottos.add(inputLottos.get(i));
        }
        this.winningMap.put(LottoStatus.FIRST, 0);
        this.winningMap.put(LottoStatus.SECOND, 0);
        this.winningMap.put(LottoStatus.THIRD, 0);
        this.winningMap.put(LottoStatus.FOURTH, 0);
        this.winningMap.put(LottoStatus.FIFTH, 0);
    }

    public Map<LottoStatus, Integer> getWinningMap() {
        return winningMap;
    }

    public List<Lotto> all() {
        return new ArrayList<>(lottos);
    }

    public void reportLottoCount(LottoReport lottoReport){
        lottoReport.reportLottoCount(this.winningMap);
    }

    public void reportLottos(LottoReport lottoReport){
        lottoReport.reportLottos(this.lottos);
    }

    public void checkWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void match() {
        for (Lotto lotto : lottos) {
            lotto.match(winningLotto);
            if(lotto.isStatus() == LottoStatus.FIFTH) winningMap.put(LottoStatus.FIFTH, winningMap.get(LottoStatus.FIFTH) + 1);
            if(lotto.isStatus() == LottoStatus.FOURTH) winningMap.put(LottoStatus.FOURTH, winningMap.get(LottoStatus.FOURTH) + 1);
            if(lotto.isStatus() == LottoStatus.THIRD) winningMap.put(LottoStatus.THIRD, winningMap.get(LottoStatus.THIRD) + 1);
            if(lotto.isStatus() == LottoStatus.SECOND) winningMap.put(LottoStatus.SECOND, winningMap.get(LottoStatus.SECOND) + 1);
            if(lotto.isStatus() == LottoStatus.FIRST) winningMap.put(LottoStatus.FIRST, winningMap.get(LottoStatus.FIRST) + 1);
        }
    }


}
