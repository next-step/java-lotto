package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoMachine {

    private static final int DEFAULT_LOTTO_PRICE = 1000;
    private final int lottoPrice;
    private final Random random = new Random();

    public LottoMachine() {
        this(DEFAULT_LOTTO_PRICE);
    }

    public LottoMachine(int lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public LottoGroup generateLottoGroup(int inputMoney) {
        int lottoCount = inputMoney / lottoPrice;

        LottoGroup lottoGroup = new LottoGroup();
        for (int i = 0 ; i < lottoCount ; i++) {
            lottoGroup.add(LottoNumbers.with(generateRandomNumbers()));
        }

        return lottoGroup;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbersBetween1And45 = generateNumbersBetween1And45();
        List<Integer> randomNumbersBetween1And45 = new ArrayList<>();

        for (int i = 0 ; i < LottoNumbers.LOTTO_SIZE ; i++) {
            int randIdx = random.nextInt(numbersBetween1And45.size());
            randomNumbersBetween1And45.add(numbersBetween1And45.get(randIdx));
            numbersBetween1And45.remove(randIdx);
        }

        return randomNumbersBetween1And45;
    }

    private List<Integer> generateNumbersBetween1And45() {
        List<Integer> from1To45 = new ArrayList<>();
        for (int i = LottoNumber.LOWER ; i <= LottoNumber.UPPER ; i++) {
            from1To45.add(i);
        }
        return from1To45;
    }


}
