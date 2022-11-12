package step2step3.lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int NUMBER_OF_LOTTO = 6;

    private final List<LottoNumber> numbers;

    private LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static LottoTicket from(NumbersGenerator numbersGenerator) {
        Set<Integer> numbers = numbersGenerator.numbers();
        verifyNumbers(numbers);
        return new LottoTicket(lottoNumbers(numbers));
    }

    private static List<LottoNumber> lottoNumbers(Set<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static void verifyNumbers(Set<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }

    }

    public void printNumbers(OutputDevice outputDevice) {
        Collections.sort(numbers);
        outputDevice.printNumbers(numbers);
    }

    public Rank rank(LottoTicket winningLottoTicket) {
        long numberOfMatchingNumbers = numbers.stream()
                .filter(winningLottoTicket.numbers::contains)
                .count();

        return Rank.rank(numberOfMatchingNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public boolean hasBonusNumber(int number) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.isSameNumber(number));
    }
}
