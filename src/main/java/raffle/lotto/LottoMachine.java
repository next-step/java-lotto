package raffle.lotto;

import raffle.lotto.win.LottoResult;
import raffle.lotto.win.WinLotto;

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

    List<Integer> lottoNumber;
    private List<Lotto> lottos;

    public LottoMachine(int lottoAmount) {
        lottos = new ArrayList<Lotto>();
        while (lottoAmount >= LOTTO_PRICE){
            suffleLotto();
            lottoAmount -= LOTTO_PRICE;
        }
    }

    private void suffleLotto() {
        lottoNumber = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumber);
        lottos.add(new Lotto(lottoNumber.subList(LOTTO_MIN, LOTTO_MAX)));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult winLotto(List<Integer> lastWeekLotto) {
        List<WinLotto> winLottos = new ArrayList<>();
        for(Lotto lotto : lottos){
            int winCount = (int) lotto.getLottoNumber().stream().filter(number -> lastWeekLotto.contains(number)).count();
            winLottos.add(WinLotto.search(winCount));
        }
        return new LottoResult(winLottos);
    }

}
