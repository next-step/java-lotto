package lotto;

import lotto.domain.*;
import lotto.view.ConsoleInputReader;
import lotto.view.ConsoleOutputWriter;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("예상하지 못한 예외가 발생했습니다.");
        }
    }

    public static void run() {
        final LottoMoney lottoMoney = ConsoleInputReader.readLottoMoney();

        final List<List<Integer>> autoLottoContents = LottoGenerator.generateLottoContents(lottoMoney, new RandomCandidateStrategy());
        autoLottoContents.forEach(ConsoleOutputWriter::printLottoContent);

        final List<Integer> lotto = ConsoleInputReader.readLottoValue();
        final int bonus = ConsoleInputReader.readLottoNumberValue();
        final LottoGame lottoGame = new LottoGame(autoLottoContents, lotto, bonus);

        final LottoResult lottoResult = lottoGame.result();
        ConsoleOutputWriter.printLottoResultStatistic(lottoResult, lottoMoney);
    }
}
