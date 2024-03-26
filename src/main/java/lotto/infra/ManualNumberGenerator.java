package lotto.infra;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.NumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManualNumberGenerator implements NumberGenerator {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<Integer> generateNumbers() {
        String input = scanner.nextLine();

        return parsingInput(input);
    }

    private List<Integer> parsingInput(String input) {
        return Arrays.stream(input.split(",\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
