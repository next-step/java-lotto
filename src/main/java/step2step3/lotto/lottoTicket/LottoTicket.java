package step2step3.lotto.lottoTicket;

import step2step3.lotto.lottoNumber.LottoNumber;
import step2step3.lotto.lottoNumber.LottoNumberStorage;
import step2step3.lotto.lottoNumber.NumbersGenerator;

import java.util.*;

public class LottoTicket {

    private static final int NUMBER_OF_LOTTO = 6;

    private final List<LottoNumber> numbers;

    private LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static LottoTicket from(NumbersGenerator numbersGenerator) {
        LottoNumberStorage lottoNumberStorage = LottoNumberStorage.lottoNumberStorage();
        List<LottoNumber> lottoNumbers = lottoNumberStorage.lottoNumbers(numbersGenerator);
        Collections.sort(lottoNumbers);
        verifyNumbers(lottoNumbers);
        return new LottoTicket(lottoNumbers);
    }

    private static void verifyNumbers(List<LottoNumber> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(numbers);

        if (lottoNumbers.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }
    }

    public void printNumbers(OutputDevice outputDevice) {
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
