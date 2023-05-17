package lottoauto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lottoauto.view.OutputView;

public class Lotto {

    public static final List<Integer> LOTTO_NUMBER_RANGE = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidation.checkLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public static Lotto auto() {
        List<Integer> lottoNumbers = new ArrayList<>(LOTTO_NUMBER_RANGE);
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0, 6);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    public static Lotto manual(String numbers) {
        return new Lotto(Arrays.stream(numbers.split(OutputView.DELIMITER))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList()));
    }

}
