package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String COMMA = ",";
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해주세요.";
    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public List<LottoNumber> inputWinningNumber() {
        System.out.println(INPUT_LAST_WEEK_WINNING_NUMBER_MESSAGE);
        String input = SCANNER.nextLine();
        return Arrays.stream(splitWinningNumber(input))
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    private String[] splitWinningNumber(final String input) {
        return input.replace(SPACE, EMPTY).split(COMMA);
    }

    public LottoNumber inputBonusBall() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        return new LottoNumber(Integer.parseInt(SCANNER.nextLine()));
    }

    public void printLottos(final Lottos lottos) {
        printAmount(lottos);
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto.getLottoNumbers());
        }
    }

    private void printAmount(final Lottos lottos) {
        System.out.println(lottos.getLottos().size() + LOTTO_AMOUNT_MESSAGE);
    }

    private void printLotto(final List<LottoNumber> lottoNumbers) {
        final List<Integer> numbers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        System.out.println(numbers);
    }

}
