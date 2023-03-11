package Lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;
    private int lottoCount = 0;
    private final BigDecimal LOTTO_AMT = new BigDecimal(1000);

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    private BigDecimal buyAmount = BigDecimal.ZERO;

    private BigDecimal sumWinAmount = BigDecimal.ZERO;
    private Lotto winLotto;

    private int bonusNumber = 0;

    public double getRate() {
        return rate;
    }

    public void setRate() {
        this.rate = sumWinAmount.divide(buyAmount).doubleValue();
    }

    private double rate = 0;

    public List<Lotto> buyLottos(java.math.BigDecimal buyAmt) {
        this.lottoCount = buyAmt.divide(LOTTO_AMT).intValue();
        this.lottos = new ArrayList<Lotto>();
        this.buyAmount = buyAmt;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.createAutoLotto());
        }
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void setWinLotto(List<Integer> winLottoNumber){
        this.winLotto = new Lotto(winLottoNumber);
    }
    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void executeLotto(){
        for (int i = 0; i < lottoCount; i++) {
            lottos.get(i).setHitCount(winLotto);
            lottos.get(i).setIsBonusHit(bonusNumber);
            lottos.get(i).setRank();
            if(null != lottos.get(i).getRank()) {
                this.sumWinAmount = sumWinAmount.add(lottos.get(i).getRank().getRewardAmount());
            }
        }
        setRate();
    }
    public List<Lotto> getLottos() {
        return lottos;
    }

    public BigDecimal getSumWinAmount() {
        return sumWinAmount;
    }
}
