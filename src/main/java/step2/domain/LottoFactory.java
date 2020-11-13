package step2.domain;

import step2.exception.LottoMoneyException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoFactory {


    private static final int LOTTO_PRICE = 1000;
    private final Lottos lottos;

    public LottoFactory(int money) {
        validMoney(money);
        int lottoTickets = money / LOTTO_PRICE;

        lottos = new Lottos(Arrays.stream(new Integer[lottoTickets])
                .map(integer -> new Lotto(RandomLottoGenerator.generateLottoNumbers()))
                .collect(Collectors.toList()));
    }

    private void validMoney(int money) {
        if(money < 1000){
            throw new LottoMoneyException();
        }
    }


    public boolean isLottoTicketsCount(int size) {
        return lottos.isLottoTicketsCount(size);
    }

}
