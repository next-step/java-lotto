package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Lotto> lottos = new ArrayList<>();
    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        InputView.printPurchaseRequest();

        int purchaseAmount = scanner.nextInt();
        int quantity = quantity(purchaseAmount);

        ResultView.printQuantity(quantity);

        for (int i = 0; i < quantity; i++) {
            LottoNumbers lottoNumbers = LottoMachine.generateLottoNumber();
            Lotto lotto = Lotto.from(lottoNumbers);

            lottos.add(lotto);
            ResultView.printLottoNumbers(lotto);
        }

        InputView.printWinningNumbersRequest();
        LottoNumbers winningNumbers = winningNumbers();

//        winningNumbers.match();

//        lottos.forEach(lotto -> lotto.match(winningNumbers));

        for (Lotto lotto : lottos) {
            lotto.match(winningNumbers);
        }

    }

    private static LottoNumbers winningNumbers() {
        String[] input = scanner.next().split(DELIMITER);

        List<Integer> winningNumbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return LottoNumbers.from(winningNumbers);
    }

    private static int quantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
