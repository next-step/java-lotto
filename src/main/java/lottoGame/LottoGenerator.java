package lottoGame;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int lotteryNum;

    public LottoGenerator(InputParameter inputParameter) {
        this.lotteryNum = inputParameter.getLotteryNum();
    }

    public Lottery create() {

        return new Lottery(lotteryNum);
    }
}
