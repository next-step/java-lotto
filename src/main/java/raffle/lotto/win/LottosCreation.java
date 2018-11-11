package raffle.lotto.win;

import raffle.lotto.Lotto;
import raffle.lotto.money.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static raffle.lotto.LottoMachine.*;

public class LottosCreation implements LottosGenerator {
    private List<Lotto> lottos;

    @Override
    public List<Lotto> generate(Money money) {
        lottos = new ArrayList<>();
        int count = (money.getAmout() / LOTTO_PRICE ) - money.getManualCount();
        for(int i =0; i < count; i++){
            suffleLotto();
        }
        return lottos;
    }

    private void suffleLotto() {
        List<Integer> lottoNumber = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList()));
        lottos.add(new Lotto(lottoNumber.subList(LOTTO_MIN, LOTTO_MAX)));
    }

}
