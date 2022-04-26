package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    private static final int MIN_VALID_NUMBER = 1;
    private static final int MAX_VALID_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> NUMBER_POOL = IntStream.range(MIN_VALID_NUMBER, MAX_VALID_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());

    private final Set<LottoNo> lottoNumbers = new HashSet<>();

    public Lotto() {
        this(generateRandomList());
    }

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        numbers.forEach(number -> lottoNumbers.add(LottoNo.of(number)));
    }

    private static List<Integer> generateRandomList() {
        Collections.shuffle(NUMBER_POOL);
        return IntStream.range(0, LOTTO_SIZE)
                .mapToObj(NUMBER_POOL::get)
                .collect(Collectors.toList());
    }

    private static void validateNumbers(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("lotto must contain non duplicate " + LOTTO_SIZE + " numbers");
        }
    }

    public static List<Lotto> createLottosOfSize(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public double earnings(WinningLotto winningLotto) {
        return findPrize(winningLotto).getEarnings();
    }

    public Prize findPrize(WinningLotto winningLotto) {
        return Prize.findPrizeByMatchCount(
                winningLotto.matchCount(this), winningLotto.matchBonus(this));
    }

    public int matchCount(Lotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(lottoNo -> winningLotto.contains(lottoNo.getNumber()))
                .count();
    }

    public boolean contains(int number) {
        return lottoNumbers.stream()
                .anyMatch(lottoNo -> lottoNo.equals(LottoNo.of(number)));
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.stream()
                .map(LottoNo::getNumber)
                .collect(Collectors.toList());
    }
}
