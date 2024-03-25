package lotto.ui;

import lotto.domain.LottoList;
import lotto.match.LottoResult;
import lotto.prize.StandardPrizeRate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoShop {

    private final static int LOTTO_VALUE = 1000;
    private final Scanner scanner = new Scanner(System.in);

    public void enter(){
        System.out.println("구매 금액을 입력하세요");
        String inputMoney = scanner.nextLine();
        LottoList lottoList = purchaseLotto(inputMoney);

        System.out.printf("%d개를 구매했습니다.",lottoList.size());
        System.out.println();
        lottoList.getLottoTextList().forEach(System.out::println);

        System.out.println("지난 주 당첨 번호를 입력해주세요");
        String inputNumbers = scanner.nextLine();
        List<Integer> answerList = extractNumber(inputNumbers);
        LottoResult lottoResult = lottoList.getLottoResult(answerList);

        System.out.println("당첨 통계");
        System.out.println("-------");
        lottoResult.getWinningWords().forEach(System.out::println);
        System.out.printf("총 수익률은 %.2f 입니다.",lottoResult.getWinningPercent(new StandardPrizeRate(), LOTTO_VALUE));
    }

    private List<Integer> extractNumber(String inputNumbers) {
        List<Integer> collect = Arrays.stream(inputNumbers.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        if(collect.size() != 6)
            throw new IllegalArgumentException("숫자는 6개이여야합니다.");
        return collect;
    }

    private LottoList purchaseLotto(String requestMoney) {
        int count = Integer.parseInt(requestMoney) / LOTTO_VALUE;
        return new LottoList(count);
    }
}
