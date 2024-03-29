package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final String INVALID_LOTTO_NUMBERS = "로또 번호의 개수는 중복없이 6개만 사용 가능합니다.";
    private static final int VALID_LOTTO_LENGTH = 6;

    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public static Lotto createLottoFrom(List<String> lotto) {
        return new Lotto(parseLottoNumbers(lotto));
    }

    private static boolean isValidLottoSize(int lottoSize) {
        return lottoSize == VALID_LOTTO_LENGTH;
    }

    private static Set<LottoNumber> parseLottoNumbers(List<String> lotto) {
        return convertIntegerLottoToLottoNumber(convertStringToLottoNumber(lotto));
    }

    private static Set<LottoNumber> convertIntegerLottoToLottoNumber(List<Integer> input) {
        if(!isValidLottoSize(getLottoSizeWithoutDuplicatedNumbers(input))) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS);
        }

        Set<LottoNumber> result = new LinkedHashSet<>();
        Collections.sort(input);

        for (int i = 0; i < input.size(); i++) {
            result.add(new LottoNumber(input.get(i)));
        }

        return result;
    }

    private static int getLottoSizeWithoutDuplicatedNumbers(List<Integer> input) {
        Set<Integer> lottoWithUniqueNumbers = new HashSet<>(input);
        return lottoWithUniqueNumbers.size();
    }

    private static List<Integer> convertStringToLottoNumber(List<String> lotto) {
        return lotto.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
    }

    public static Lotto getRandomLotto(Random random) {
        Set<LottoNumber> numbers = new HashSet<>();

        while (numbers.size() < VALID_LOTTO_LENGTH) {
            numbers.add(LottoNumber.getRandomLottoNumber(random));
        }

        return new Lotto(numbers);
    }

    public boolean containsNumber(int number) {
        return lotto.stream()
                .anyMatch(lottoNumber -> lottoNumber.isSameNumber(number));
    }
}
