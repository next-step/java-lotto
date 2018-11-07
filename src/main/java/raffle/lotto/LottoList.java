package raffle.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {

    private final int lottoPrice = 1000;

    List<Integer> lottoNumber;
    private List<Lotto> lottos;

    public LottoList(int lottoAmount) {
       lottos = new ArrayList<Lotto>();
       while (lottoAmount >= lottoPrice){
            lottoNumber = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
            suffleLotto();
            lottos.add(new Lotto(lottoNumber.subList(0, 6)));
            lottoAmount -= lottoPrice;
        }
    }
    private void suffleLotto() {
        Collections.shuffle(lottoNumber);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
