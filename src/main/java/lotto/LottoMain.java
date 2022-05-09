package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.UserAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        UserAmount userAmount = getUserAmount();
        int numberOfUserGenerateLotto = getNumberOfUserGenerateLotto();
        List<LottoNumbers> lottoOfUser = getLottoOfUser(numberOfUserGenerateLotto);

        Lottos lottos = new Lottos(userAmount, lottoOfUser);
        OutputView.outputLottoNumbers(lottos);

        LottoNumbers lottoNumbers = getLottoNumbers();

        WinningLotto winningLotto = getWinningLotto(lottoNumbers);
        OutputView.outputWinningStatistics(lottos, winningLotto);
        OutputView.outputRevenueRate(lottos, winningLotto);
    }

    private static List<LottoNumbers> getLottoOfUser(int numberOfUserGenerateLotto) {
        try {
            String inputLottoOfUSer = InputView.inputLottoOfUser(numberOfUserGenerateLotto);

            return Arrays.stream(inputLottoOfUSer.split(InputView.LINE_SEPARATOR))
                    .map(LottoNumbers::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
        }

        return getLottoOfUser(numberOfUserGenerateLotto);
    }

    private static LottoNumbers getLottoNumbers() {
        try {
            return new LottoNumbers(InputView.inputPreviousWeekWinningNumber());
        } catch (Exception e) {
            printExceptionMessage(e);
        }

        return getLottoNumbers();
    }

    private static int getNumberOfUserGenerateLotto() {
        try {
            return InputView.inputNumberOfUserGenerateLotto();
        } catch (InputMismatchException e) {
            printExceptionMessage(e);
        }

        return getNumberOfUserGenerateLotto();
    }

    private static UserAmount getUserAmount() {
        try {
            return new UserAmount(InputView.inputUserAmount());
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
        }

        return getUserAmount();
    }

    private static WinningLotto getWinningLotto(LottoNumbers lottoNumbers) {
        LottoNumber bonusBall = getBonusBall();

        try {
            return new WinningLotto(lottoNumbers, bonusBall);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
        }

        return getWinningLotto(lottoNumbers);
    }

    private static LottoNumber getBonusBall() {
        try {
            return new LottoNumber(InputView.inputBonusBall());
        } catch (Exception e) {
            printExceptionMessage(e);
        }

        return getBonusBall();
    }

    private static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
