package lotto;

import lotto.domain.LottoStatistics;
import lotto.domain.Person;
import lotto.domain.Store;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));

        Store lottoStore = new Store();
        Person person = new Person(getAmount(inputView));

        lottoStore.sellTo(person);
        ResultView.printMyLottos(person);

        LottoStatistics statistics = new LottoStatistics(person, getWinningNumbers(inputView));
        ResultView.printResultStatistics(statistics);
        ResultView.printProfitRate(statistics);

        inputView.close();
    }

    public static int getAmount(InputView inputView) {
        return Integer.parseInt(inputView.nextLine("구입금액을 입력해 주세요."));
    }

    public static List<Integer> getWinningNumbers(InputView inputView) {
        String[] numbers = inputView.nextLine("지난 주 당첨 번호를 입력해 주세요.").replace(" ", "").split(",");
        return Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
