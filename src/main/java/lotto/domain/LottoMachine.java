package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoMachine {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final Random random = new Random();

    public int getLottoTicketNumber(int money) {
        return money / LOTTO_TICKET_PRICE;
    }

    public Lotto createLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> start(int money) {
        int lottoTicketNumber = getLottoTicketNumber(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<lottoTicketNumber; i++) {
            lottos.add(createLotto(generateLottoNumber()));
        }

        return lottos;
    }

    private List<Integer> generateLottoNumber() {
        List<Integer> lottos = new ArrayList<>();
        while (lottos.size() < 6) {
            int candidateLottoNumber = random.nextInt(45) + 1;
            if (!lottos.contains(candidateLottoNumber)) {
                lottos.add(candidateLottoNumber);
            }
        }

        return lottos;
    }
}
