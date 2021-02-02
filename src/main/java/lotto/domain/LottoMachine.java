package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoMachine {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int NUMBER_RANGE = 45;
    private static final int LOTTO_LENGTH = 6;
    private final Random random = new Random();
    private List<Integer> lottos;

    public int getLottoTicketNumber(int money) {
        return money / LOTTO_TICKET_PRICE;
    }

    public Lotto createLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> start(int money) {
        int lottoTicketNumber = getLottoTicketNumber(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketNumber; i++) {
            lottos.add(createLotto(generateLottoNumber()));
        }

        return lottos;
    }

    private List<Integer> generateLottoNumber() {
        lottos = new ArrayList<>();
        while (lottos.size() < LOTTO_LENGTH) {
            int candidateLottoNumber = random.nextInt(NUMBER_RANGE) + 1;
            lottoAdder(candidateLottoNumber);
        }

        lottos.sort(Integer::compareTo);

        return lottos;
    }

    private void lottoAdder(int number) {
        if (!lottos.contains(number)) {
            lottos.add(number);
        }
    }
}
