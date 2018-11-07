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
        lottoNumber = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumber);
        lottos.add(new Lotto(lottoNumber.subList(0, 6)));
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
