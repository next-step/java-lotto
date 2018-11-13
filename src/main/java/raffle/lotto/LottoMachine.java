package raffle.lotto;

import raffle.lotto.money.Money;
import raffle.lotto.validator.LottoNumberValidator;
import raffle.lotto.validator.LottoValidator;
import raffle.lotto.win.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_MIN = 0;
    public static final int LOTTO_MAX = 6;

    private List<Lotto> lottos;
    private LottoValidator lottoValidator;
    private Money money;

    public LottoMachine(Money moeny, LottosGenerator lottosGenerator) {
        this.money = moeny;
        this.lottos = lottosGenerator.generate(moeny);
        this.lottoValidator = new LottoNumberValidator();
        if(lottoValidator.validator(lottos));
    }


    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResult winLotto(List<LottoNo> lastWeekLotto, LottoNo bonusLotto) {
        List<WinLotto> winLottos = new ArrayList<>();
        WinningLotto winningLotto = new WinningLotto(lastWeekLotto, bonusLotto);
        for(Lotto lotto : lottos){
            winLottos.add(winningLotto.result(lotto));
        }
        return new LottoResult(winLottos, LOTTO_PRICE, money);
    }

}
