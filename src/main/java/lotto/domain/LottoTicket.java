package lotto.domain;

import java.util.*;

public class LottoTicket {

    private final static int LOTTO_BOUND_NUMBER = 45;
    private final static int LOTTO_NUMBER_LIMIT = 6;

    List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoTicket(Integer... lottoNumbers) {
        this(toLottoNumbers(lottoNumbers));
    }

    private static List<LottoNumber> toLottoNumbers(Integer... numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket() {
        Set<Integer> randomNumber = new HashSet<>();
        Random rand = new Random();

        getNotDuplicatedNumber(randomNumber, rand);

        List<Integer> numbers = new ArrayList<>(randomNumber);
        Collections.shuffle(numbers);

        for (Integer number : numbers) {
            this.lottoNumbers.add(new LottoNumber(number));
        }
    }

    private static void getNotDuplicatedNumber(Set<Integer> randomNumber, Random rand) {
        while (randomNumber.size() < LOTTO_NUMBER_LIMIT) {
            int number = rand.nextInt(LOTTO_BOUND_NUMBER) + 1;
            randomNumber.add(number);
        }
    }


    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
