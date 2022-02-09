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
    private static final String LEFT_SQUARE_BRACKETS = "[";
    private static final String RIGHT_SQUARE_BRACKETS = "]";
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해주세요.";
    private static final int ZERO = 0;

    private final StringBuilder stringBuilder = new StringBuilder();

    public LottoInputView() {
    }

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
        stringBuilder.append(lottos.getLottos().size())
            .append("개를 구매했습니다.");
        System.out.println(stringBuilder);
    }


    private void printLotto(final List<LottoNumber> lottoNumbers) {
        stringBuilder.setLength(ZERO);
        stringBuilder.append(LEFT_SQUARE_BRACKETS);

        for (LottoNumber lottoNumber : lottoNumbers) {
            stringBuilder.append(lottoNumber.getNumber())
                .append(COMMA)
                .append(SPACE);
        }

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(SPACE));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(COMMA));
        stringBuilder.append(RIGHT_SQUARE_BRACKETS);

        System.out.println(stringBuilder);
    }

}
