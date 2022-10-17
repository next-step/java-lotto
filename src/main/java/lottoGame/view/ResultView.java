package lottoGame.view;

import lottoGame.InputException;
import lottoGame.WinningNumbers;
import lottoGame.model.InputParameter;
import lottoGame.model.Lottery;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ResultView {
    private static final String start = "개를 구매했습니다.";

    private static final String inputWinningNum = "지난 주 당첨 번호를 입력해주세요";

    private static final String startStatics = "당첨 통계";

    private static final String line = "\n---------\n";

    private static final Pattern FILTER = Pattern.compile("^([1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$|^,+$)");
    private final Scanner scanner = new Scanner(System.in);


    public void printLottery(InputParameter inputParameter, Lottery lottery) {
        System.out.println(inputParameter.getLotteryNum() + start);
        lottery.getLottery().forEach(lotto -> System.out.println(lotto.toString()));
    }

    public List<Integer> inputWinningNumer() {
        System.out.println(inputWinningNum);
        String winningString = scanner.nextLine();
        return changeInteger(winningString);
    }

    public void printStatistics(EnumMap<WinningNumbers, Integer> winningMap) {
        System.out.printf("%s%s%n", startStatics, line);
        winningMap.forEach((key, value) -> System.out.printf("%s개 일치 (%s원)- %s개%n", key.getNumberOfWins(), key.getWinnings(), value));
    }

    public void printYield(String lottoYield) {
        System.out.printf("총 수익률은 %s 입니다.", lottoYield);
    }

    private List<Integer> changeInteger(String winningString) {
        return Arrays.stream(checkNumCount(split(winningString)))
                .filter(this::validateNumRange)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String[] split(String winningString) {
        return winningString.split(",");
    }


    private String[] checkNumCount(String[] split) {
        if (split.length > 6) {
            throw new InputException("6개 이상의 숫자를 입력했습니다.");
        }
        return split;
    }

    private boolean validateNumRange(String inputWinningNum) {
        if (FILTER.matcher(inputWinningNum).matches()) {
            return true;
        }
        throw new InputException("로또 숫자 범위 안의 숫자와 , 입력해주세요.");
    }


}
