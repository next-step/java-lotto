package camp.nextstep.edu.nextstep8.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final List<Integer> LOTTO_CANDIDATE_NUMBERS = IntStream.range(1, 45).boxed().collect(Collectors.toList());
    private static final String DELIMITER = ", ";
    private static final String LEFT_BRACE = "[";
    private static final String RIGHT_BRACE = "]";
    private final List<Integer> numbers;

    public LottoNumber() {
        numbers = makeGoodLuck();
    }

    public LottoNumber(String lottoNumberStr) {
        numbers = StringLottoNumberConvertor.convert(lottoNumberStr);
    }

    private List<Integer> makeGoodLuck() {
        Collections.shuffle(LOTTO_CANDIDATE_NUMBERS);
        List<Integer> selection = new ArrayList<>(LOTTO_CANDIDATE_NUMBERS.subList(0, 6));
        Collections.sort(selection);
        return selection;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public String getResultForPrint() {
        StringBuilder builder = new StringBuilder();
        builder.append(LEFT_BRACE);
        builder.append(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER)));
        builder.append(RIGHT_BRACE);
        return builder.toString();
    }
}
