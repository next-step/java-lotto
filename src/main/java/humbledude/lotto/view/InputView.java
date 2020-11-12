package humbledude.lotto.view;

import humbledude.lotto.domain.LottoNumbers;
import humbledude.lotto.domain.LottoWinningNumbers;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static long getBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(scanner.nextLine());
    }

    public static LottoWinningNumbers getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        Set<Integer> numbers = Stream.of(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toSet());

        return new LottoWinningNumbers(LottoNumbers.of(numbers));

    }

}
