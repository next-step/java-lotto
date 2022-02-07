package stringadder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertInt {

    public static List<Integer> convertInt(List<String> numbers) {
        return numbers.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
