package Lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Lottos {

    private List<Lotto> lottos;
    private String SPLIT_CHAR = ",";

    private int lottoCount = 0;
    private int manuelLottoCount = 0;
    private final BigDecimal LOTTO_AMOUNT = new BigDecimal(1000);

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

    public List<Lotto> buyLottos(LottoForm lottoForm) {
        this.lottoCount = lottoForm.getBuyPrice().divide(LOTTO_AMOUNT).intValue();
        this.lottos = new ArrayList<Lotto>();
        this.buyAmount = lottoForm.getBuyPrice();
        this.manuelLottoCount = lottoForm.getManualLottoCount();

        List<Lotto> lottoList = lottoForm.getManualLottosNumber().stream()
                .map(it -> Arrays.stream(it.split(SPLIT_CHAR))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(toList())
                )
                .map(it -> Lotto.createManualLotto(it))
                .collect(toList());
        lottos.addAll(lottoList);

        for (int i = 0; i < (lottoCount - manuelLottoCount); i++) {
            lottos.add(Lotto.createAutoLotto());
        }
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void setWinLotto(List<Integer> winLottoNumber) {

        this.winLotto = new Lotto(winLottoNumber);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void executeLotto() {
        for (Lotto lotto : lottos) {
            lotto.executeLotto(winLotto, bonusNumber);
            if (null != lotto.getRank()) {
                this.sumWinAmount = sumWinAmount.add(lotto.getRank().getRewardAmount());
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
