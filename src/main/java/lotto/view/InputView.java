package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";

    public int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public Lotto inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO_MESSAGE);
        String strLottoNumbers = scanner.nextLine();
        List<Integer> lottoNumbers = Arrays.stream(strLottoNumbers.split(","))
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }
}
