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
        this.bonusBall = new LottoNumber(bonusBall);
    }

    @Override
    public Lotto generateLotto() {
        List<LottoNumber> newNumbers = new ArrayList<>(numbers);
        numbers = numbers.stream().map(LottoNumber::increase).collect(Collectors.toList());
        if(isWinningLotto()) {
            return new WinningLotto(newNumbers.subList(BASE_INDEX, Lotto.SIZE_LIMIT), bonusBall);
        }
        return new Lotto(newNumbers);
    }

    private boolean isWinningLotto() {
        return this.bonusBall != null;
    }

    private List<Integer> convertToInt(String str) {
        return Stream.of(str.split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }
}