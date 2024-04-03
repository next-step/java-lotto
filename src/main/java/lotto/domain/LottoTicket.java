package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

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
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() > LOTTO_NUMBER_LIMIT) {
            throw new IllegalStateException("로또의 숫자의 갯수 제한은 6개입니다.");
        }
    }

    public static LottoTicket auto() {

        Set<Integer> randomNumber = new HashSet<>();
        Random rand = new Random();
        getNotDuplicatedNumber(randomNumber, rand);

        List<Integer> numbers = new ArrayList<>(randomNumber);
        Collections.sort(numbers);

        List<LottoNumber> lottoNumbers = createLottoNumbers(numbers);

        return new LottoTicket(lottoNumbers);
    }

    private static List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static void getNotDuplicatedNumber(Set<Integer> randomNumber, Random rand) {
        while (randomNumber.size() < LOTTO_NUMBER_LIMIT) {
            int number = rand.nextInt(LOTTO_BOUND_NUMBER) + 1;
            randomNumber.add(number);
        }
    }

    public List<Integer> numbers() {
        return lottoNumbers.stream().
                map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public int getNumberOfMatch(LottoTicket lastWeekLotto) {
        return (int) lastWeekLotto.numbers().stream()
                .filter(numbers()::contains)
                .count();
    }

    public List<LottoNumber> createLottoNumbers() {
        return lottoNumbers;
    }
}
