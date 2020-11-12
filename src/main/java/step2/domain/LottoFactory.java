package step2.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoFactory {


    private final Lottos lottos;

    public LottoFactory(int money) {
        int lottoTickets = money / 1000;

        lottos = new Lottos(Arrays.stream(new Integer[lottoTickets])
                .map(integer -> new Lotto(RandomLottoGenerator.generateLottoNumbers()))
                .collect(Collectors.toList()));
    }


    public boolean isLottoTicketsCount(int size) {
        return lottos.isLottoTicketsCount(size);
    }

}
