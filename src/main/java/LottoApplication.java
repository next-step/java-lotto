import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    private static final String LOTTO_FORMAT_REGEX = "^\\d+, \\d+, \\d+, \\d+, \\d+, \\d+$";

    public static void main(String[] args) {
        int price = InputView.promptForPurchasePrice();
        Lottos lottos = new Lottos(price);
        ResultView.print(lottos);

        Lotto winningLotto = new Lotto(convertWinningNumbers(InputView.promptForWinningNumbers()));
        ResultView.printRanks(lottos.ranks(winningLotto));
        ResultView.printRateOfReturn(lottos.rateOfReturn(winningLotto));
    }

    private static List<Integer> convertWinningNumbers(String input) {
        assertionValidFormat(input);
        List<Integer> result = new ArrayList<>();
        for (String s : input.split(", ")) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    private static void assertionValidFormat(String input) {
        if (!input.matches(LOTTO_FORMAT_REGEX)) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}
