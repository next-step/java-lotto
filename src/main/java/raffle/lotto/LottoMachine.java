package raffle.lotto;

import raffle.lotto.money.Money;
import raffle.lotto.validator.LottoValidator;
import raffle.lotto.win.LottoResult;
import raffle.lotto.win.WinLotto;
import raffle.lotto.win.WinningLotto;

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

    public LottoMachine(Money moeny, List<Lotto> lottos, LottoValidator lottoValidator) {
        this.lottoValidator = lottoValidator;
        if(lottoValidator.validator(lottos));
        this.lottos = lottos;
        this.money = moeny;

        int buyLottoAmount = lottos.size() * LOTTO_PRICE;
        int count = (moeny.getAmout() - buyLottoAmount) / LOTTO_PRICE;
        for(int i =0; i < count; i++){
            suffleLotto();
        }
    }

    private void suffleLotto() {
        List<Integer> lottoNumber = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumber);
        lottos.add(new Lotto(lottoNumber.subList(LOTTO_MIN, LOTTO_MAX)));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResult winLotto(Lotto lastWeekLotto, LottoNo bonusLotto) {
        if(bonusLotto.isLottoNumber());
        List<WinLotto> winLottos = new ArrayList<>();
        WinningLotto winningLotto = new WinningLotto(lastWeekLotto, bonusLotto);
        for(Lotto lotto : lottos){
            winLottos.add(winningLotto.result(lotto));
        }
        return new LottoResult(winLottos, LOTTO_PRICE, money);
    }

}
