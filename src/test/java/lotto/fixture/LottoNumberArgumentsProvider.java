package lotto.fixture;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.arguments(Lotto.create(givenNumbers(1, 2, 3, 4, 5, 6)), Prize.FIRST),
                Arguments.arguments(Lotto.create(givenNumbers(1, 2, 3, 4, 5, 7)), Prize.SECOND),
                Arguments.arguments(Lotto.create(givenNumbers(1, 2, 3, 4, 15, 9)), Prize.THIRD),
                Arguments.arguments(Lotto.create(givenNumbers(1, 2, 3, 14, 19, 10)), Prize.FOURTH),
                Arguments.arguments(Lotto.create(givenNumbers(11, 12, 8, 9, 10, 11)), Prize.MISS));
    }


    private static List<Integer> givenNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
    }
}
