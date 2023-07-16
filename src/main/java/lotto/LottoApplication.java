package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.RandomCandidateStrategy;
import lotto.view.ConsoleInputReader;
import lotto.view.ConsoleOutputWriter;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("예상하지 못한 예외가 발생했습니다.");
        }
    }

    public static void run() {
        final long inputMoney = ConsoleInputReader.readMoneyValue();
        final List<List<Integer>> autoLottoContents = LottoGenerator.generateLottoContents(inputMoney, new RandomCandidateStrategy());
        autoLottoContents.forEach(ConsoleOutputWriter::printLottoContent);

        final List<Integer> lotto = ConsoleInputReader.readLottoValue();
        final int bonus = ConsoleInputReader.readLottoNumberValue();
        final LottoGame lottoGame = new LottoGame(autoLottoContents, lotto, bonus);

        final LottoResult lottoResult = lottoGame.result();
        ConsoleOutputWriter.printLottoResultStatistic(lottoResult, inputMoney);
    }
}
