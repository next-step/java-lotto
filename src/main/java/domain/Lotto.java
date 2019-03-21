package domain;

import com.sun.deploy.util.StringUtils;
import util.WinType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private Set<Integer> numbers;

    Lotto(int... numbers) {
        this.numbers = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toSet());
    }

    public Lotto(String[] winLottoArr) {
        this.numbers = Arrays.stream(winLottoArr)
                .mapToInt(it -> Integer.parseInt(StringUtils.trimWhitespace(it)))
                .boxed()
                .collect(Collectors.toSet());
    }

    WinType lottery(Lotto answer) {
        Set<Integer> set = new HashSet<>();
        set.addAll(this.numbers);
        set.addAll(answer.numbers);

        return WinType.findByCount(12 - set.size());
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
