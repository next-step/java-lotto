package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRandomNumberStrategy;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.Lottos;
import lotto.domain.RandomNumbersGenerator;
import lotto.dto.LottosDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        long cost = inputView.moneyToBuyLotto();

        LottoController controller = createLottoController();
        LottosDto lottosDto = controller.buyLottos(cost);

        List<Integer> winnerLotto = inputView.winnerLottoNumbers();
        controller.informRankStatistics(lottosDto, winnerLotto, cost);
    }

    private static LottoController createLottoController() {
        return new LottoController(
                new LottoMachine(new RandomNumbersGenerator(new LottoRandomNumberStrategy(), createPossibleLottoNumbers())),
                new OutputView()
        );
    }

    public static List<Integer> createPossibleLottoNumbers() {
        List<Integer> possibleLottoNumbers = new ArrayList<>();
        for (int possibleLottoNumber = MIN_LOTTO_NUMBER; possibleLottoNumber <= MAX_LOTTO_NUMBER; possibleLottoNumber++) {
            possibleLottoNumbers.add(possibleLottoNumber);
        }
        return possibleLottoNumbers;
    }

}
