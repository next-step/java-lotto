package lottoauto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lottoauto.view.OutputView;

public class Lotto {

    private static final int LOTTO_LIMIT_SIZE = 6;
    public static final List<Integer> LOTTO_NUMBER_RANGE = IntStream.range(1, 45)
            .boxed()
            .collect(Collectors.toList());

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        lottoValidation(numbers);
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    public boolean contains(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public static Lotto auto() {
        List<Integer> lottoNumbers = new ArrayList<>(LOTTO_NUMBER_RANGE);
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0, 6);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList()));

    }

    public static Lotto manual(String numbers) {
        return new Lotto(Arrays.stream(numbers.split(OutputView.DELIMITER))
                .map(number -> LottoNumber.from(Integer.parseInt(number)))
                .sorted()
                .collect(Collectors.toList()));
    }


    private void lottoValidation(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_LIMIT_SIZE) {
            throw new IllegalStateException("로또의 숫자가 6개가 아닙니다.");
        }

        Set<Integer> distinctNumbers = numbers.stream().map(LottoNumber::getNumber).collect(Collectors.toSet());
        if (distinctNumbers.size() != LOTTO_LIMIT_SIZE) {
            throw new IllegalStateException("중복되는 숫자가 있습니다.");
        }
    }

}
