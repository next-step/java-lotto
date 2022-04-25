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
        Collections.shuffle(NUMBER_POOL);
        IntStream.range(0, LOTTO_SIZE)
                .mapToObj(i -> new LottoNo(NUMBER_POOL.get(i)))
                .forEach(lottoNumbers::add);
    }

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        numbers.forEach(number -> lottoNumbers.add(new LottoNo(number)));
    }

    private void validateNumbers(List<Integer> numbers) {
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

    public static void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (bonusNumber < MIN_VALID_NUMBER || bonusNumber > MAX_VALID_NUMBER) {
            throw new IllegalArgumentException("bonus number is out of range : " + bonusNumber);
        }
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("bonus number is already used: " + bonusNumber);
        }
    }

    public double earnings(Lotto winningLotto, int bonusNumber) {
        return findPrize(winningLotto, bonusNumber).getEarnings();
    }

    public Prize findPrize(Lotto winningLotto, int bonusNumber) {
        return Prize.findPrizeByMatchCount(matchCount(winningLotto), contains(bonusNumber));
    }

    private int matchCount(Lotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(lottoNo -> winningLotto.contains(lottoNo.getNumber()))
                .count();
    }

    private boolean contains(int number) {
        return lottoNumbers.stream()
                .anyMatch(lottoNo -> lottoNo.equals(new LottoNo(number)));
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.stream()
                .map(LottoNo::getNumber)
                .collect(Collectors.toList());
    }
}
