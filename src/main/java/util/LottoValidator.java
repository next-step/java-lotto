package util;

import java.util.List;

public class LottoValidator {

    public static void checkDuplicateNumber(List<Integer> numbers) {
        long uniqueLength = numbers.stream()
                .distinct()
                .count();

        if(uniqueLength != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자를 가질 수 없습니다.");
        }
    }
}
