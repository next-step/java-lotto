package step2.domain;

import static step2.Constants.COMMA;
import static step2.Constants.EMPTY_STRING;
import static step2.Constants.REX_WHITE_SPACE_IN_STRING;
import static step2.domain.LottoGenerator.LOTTO_SELECTION_COUNT;
import static step2.view.ErrorMessages.INVALID_WINNING_NUMBERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import step2.view.ErrorMessages;

public class LottoGame {

    private int userPrice;
    private List<Lotto> lottos;
    private int cashPrize;
    private LottoGenerator lottoGenerator;

    public LottoGame(int userPrice) {
        this.userPrice = userPrice;
        this.lottos = new ArrayList<>();
        this.cashPrize = 0;
        this.lottoGenerator = new LottoGenerator(new RandomGenerableStrategy());
    }

    private void validateUserPrice(int userPrice) throws IllegalArgumentException {
        if (userPrice < 1000 || userPrice > 100000) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_USER_PRICE);
        }
    }

    public void run() throws IllegalArgumentException {
        validateUserPrice(userPrice);
        this.lottos = lottoGenerator.generateLottos(this.userPrice);
    }

    private List<Integer> convertStringToIntegerList(List<String> stringList) {
        List<Integer> result = new ArrayList<>();
        stringList.stream().forEach(string -> {
            result.add(Integer.parseInt(string));
        });
        return result;
    }

    private void validateWinningNumbers(List<String> winningNumbers)
        throws IllegalArgumentException {

        if (CollectionUtils.size(winningNumbers) != LOTTO_SELECTION_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }

        if (winningNumbers.stream().anyMatch(number -> !Character.isDigit(number.charAt(0)))) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }
    }

    private List<String> parseWinningNumbers(String winningNumbers)
        throws IllegalArgumentException {

        String[] parsedWinningNumbers = winningNumbers
            .replaceAll(REX_WHITE_SPACE_IN_STRING, EMPTY_STRING)
            .split(COMMA);

        return Arrays.asList(parsedWinningNumbers);
    }

    public LottoGameResultDto getGameResult(String winningNumbers) throws IllegalArgumentException {

        List<String> parsedWinningNumbers = parseWinningNumbers(winningNumbers);
        validateWinningNumbers(parsedWinningNumbers);
        List<Integer> winningNumberList = convertStringToIntegerList(parsedWinningNumbers);

        drawLottos(winningNumberList);

        double earningRate = getEarningRate();
        int firstPrizeCount = (int) this.lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.FIRST.getGrade())
            .count();
        int secondPrizeCount = (int) this.lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.SECOND.getGrade())
            .count();
        int thirdPrizeCount = (int) this.lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.THIRD.getGrade())
            .count();
        int forthPrizeCount = (int) this.lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.FORTH.getGrade())
            .count();

        return new LottoGameResultDto(
            earningRate,
            firstPrizeCount,
            secondPrizeCount,
            thirdPrizeCount,
            forthPrizeCount);
    }

    private void setCashPrize() {
        this.lottos.stream().forEach(lotto -> this.cashPrize += lotto.getCashPrice());
    }

    private double getEarningRate() {
        setCashPrize();
        return (double) this.cashPrize / this.userPrice;
    }

    private void drawLottos(List<Integer> winningNumbers) {
        lottos.stream().forEach(lotto -> lotto.setPrize(winningNumbers));
        //for logging
        //lottos.stream().forEach(lotto -> System.out.println(lotto));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
