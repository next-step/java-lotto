package lotto.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRandomNumberStrategy;
import lotto.domain.RandomNumberStrategy;
import lotto.domain.RandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoFactory {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public InputView inputView() {
        return new InputView(scanner());
    }

    private Scanner scanner() {
        return new Scanner(System.in);
    }

    public LottoController lottoController() {
        return new LottoController(lottoMachine());
    }

    private LottoMachine lottoMachine() {
        return new LottoMachine(randomNumbersGenerator());
    }

    private RandomNumbersGenerator randomNumbersGenerator() {
        return new RandomNumbersGenerator(randomNumberStrategy(), createPossibleLottoNumbers());
    }

    private RandomNumberStrategy randomNumberStrategy() {
        return new LottoRandomNumberStrategy();
    }

    private List<LottoNumber> createPossibleLottoNumbers() {
        List<LottoNumber> possibleLottoNumbers = new ArrayList<>();
        for (int possibleLottoNumber = MIN_LOTTO_NUMBER; possibleLottoNumber <= MAX_LOTTO_NUMBER;
             possibleLottoNumber++) {
            possibleLottoNumbers.add(LottoNumber.valueOf(possibleLottoNumber));
        }
        return possibleLottoNumbers;
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
