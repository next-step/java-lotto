package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FixedLottoGenerator implements LottoGenerator {
    private List<LottoNumber> numbers;
    private LottoNumber bonusBall;

    public FixedLottoGenerator(final String numbers) {
        this.numbers = convertToLottoNumber(convertToInt(numbers));
    }

    public FixedLottoGenerator(final String numbers, int bonusBall) {
        this.numbers = convertToLottoNumber(convertToInt(numbers));
        this.bonusBall = LottoNumber.valueOf(bonusBall);
    }

    @Override
    public Lotto generateLotto() {
        List<LottoNumber> newNumbers = new ArrayList<>(numbers);
        numbers = numbers.stream().map(LottoNumber::increase).collect(Collectors.toList());
        return new Lotto(newNumbers);
    }

    public WinningLotto generateWinningLotto() {
        return new WinningLotto(generateLotto(), bonusBall);
    }

    private List<Integer> convertToInt(String str) {
        return Stream.of(str.split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::valueOf).collect(Collectors.toList());
    }
}