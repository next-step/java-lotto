package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.shuffle;

public class LottoMain {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        int amount = InputView.inputPurchaseAmount();
        int quantity = returnPurchaseQuantity(amount);

        Lottos lottos = new Lottos(createLottos(quantity));

        lottos.printAllLottos();

        Lotto lastWinningLotto = new Lotto(InputView.inputLastWinningNumbers());
        System.out.println();

        LottoResults lottoResults = lottos.getResults(lastWinningLotto);
        ResultView.printResult(lottoResults, amount);
    }

    private static int returnPurchaseQuantity(int amount) {
        int quantity = amount / LOTTO_PRICE;
        System.out.println(quantity + "개를 구매했습니다.");
        return quantity;
    }

    private static List<Lotto> createLottos(int quantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(createLottoNumbers());
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private static List<Integer> createLottoNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int lottoNumber = 1; lottoNumber <= 45; lottoNumber++) {
            randomNumbers.add(lottoNumber);
        }
        shuffle(randomNumbers);
        List<Integer> lottoNumbers = randomNumbers.subList(0, 6);
        lottoNumbers.sort(Integer::compareTo);
        return new ArrayList<>(lottoNumbers);
    }
}
