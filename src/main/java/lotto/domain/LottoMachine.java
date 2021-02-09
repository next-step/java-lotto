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
    private int randomLottoCount;
    private int customLottoCount;

    public int getLottoTicketNumber(int money) {
        return money / LOTTO_TICKET_PRICE;
    }

    public Lotto createLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public void initializeLottoCount(int money, int customLottoCount) {
        this.randomLottoCount = money / LOTTO_TICKET_PRICE - customLottoCount;
        if (randomLottoCount < 0 ) {
            throw new IllegalArgumentException("잘못된 수동으로 구매할 로또 수 입니다.");
        }
        this.customLottoCount = customLottoCount;
    }

    public List<Lotto> generateLottos(List<Lotto> customLottos) {
        List<Lotto> lottos = new ArrayList<>();

        if (customLottos != null) lottos.addAll(customLottos);
        for (int i = 0; i < randomLottoCount; i++) {
            lottos.add(createLotto(generateRandomLottoNumber()));
        }

        return lottos;
    }

    private List<Integer> generateRandomLottoNumber() {
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

    public int getRandomLottoCount() {
        return randomLottoCount;
    }

    public int getCustomLottoCount() {
        return customLottoCount;
    }
}
