package lotto;

import lotto.util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FixedLottoGenerator implements LottoGenerator {
    private List<LottoNumber> numbers;
    private LottoNumber bonusBall;

    public FixedLottoGenerator(final List<Integer> numbers) {
        this.numbers = convertToLottoNumber(numbers);
    }

    public FixedLottoGenerator(final List<Integer> numbers, int bonusBall) {
        this.numbers = convertToLottoNumber(numbers);
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

    private List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::valueOf).collect(Collectors.toList());
    }
}