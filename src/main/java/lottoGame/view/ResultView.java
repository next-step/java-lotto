package lottoGame.view;

import lottoGame.model.exception.InputException;
import lottoGame.RankResult;
import lottoGame.model.lotto.AutoLotto;
import lottoGame.model.lotto.WinningLotto;
import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {
    private static final String start = "개를 구매했습니다.";

    private static final String inputWinningNum = "지난 주 당첨 번호를 입력해주세요";

    private static final String startStatics = "당첨 통계";

    private static final String line = "\n---------\n";
    private final Scanner scanner = new Scanner(System.in);


    public void printLottery(Lottery lottery) {
        System.out.println(lottery.countAllLotto() + start);
        lottery.getLottery().forEach(autoLotto -> System.out.println(autoLotto.toString()));
    }

    public WinningLotto inputWinningNumer() {
        System.out.println(inputWinningNum);
        String winningString = scanner.nextLine();
        return new WinningLotto(changeInteger(winningString));
    }

    public void printStatistics(RankResult rankResult) {

        System.out.printf("%s%s%n", startStatics, line);
        rankResult.getLotteryBoard().forEach((ranks, matchCount) ->
                System.out.printf("%s개 일치 (%s원)- %s개\n", ranks.getMatchNum(), ranks.getRank(), matchCount));
    }

    public void printYield(String lottoYield) {
        System.out.printf("총 수익률은 %s 입니다.", lottoYield);
    }

    private List<LottoNumber> changeInteger(String winningString) {
        return Arrays.stream(checkNumCount(split(winningString)))
                .map(Integer::parseInt)
                .map(DefaultLottoNumber::new)
                .collect(Collectors.toList());
    }

    private String[] split(String winningString) {
        return winningString.split(",");
    }


    private String[] checkNumCount(String[] split) {
        if (split.length > AutoLotto.LOTTO_NUMBER_SIZE) {
            throw new InputException("6개 이상의 숫자를 입력했습니다.");
        }
        return split;
    }

}
