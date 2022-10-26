package lottoGame.dto;

import lottoGame.model.lotto.Lotto;

import java.util.Collections;
import java.util.List;

public class ResultParameter {
    private final List<Lotto> resultLottery;

    public ResultParameter(List<Lotto> resultLotto) {
        this.resultLottery = resultLotto;
    }

    public int getLotteryCount() {
        return resultLottery.size();
    }

    public List<Lotto> getLottoResult(){
        return Collections.unmodifiableList(resultLottery);
    }
}
