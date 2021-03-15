package step2.view;

import step2.dto.LottoDto;
import step2.dto.LottoStatisticsDto;
import step2.dto.LottosDto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoView {

    private final Scanner scanner;

    public LottoView() {
        this.scanner = new Scanner(System.in);
    }

    public int paymentMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void lottoInfoPirnt(LottosDto lottosDto) {
        List<LottoDto> lottoDtoList = lottosDto.getLottoDtoList();
        System.out.println(lottoDtoList.size() + "개를 구매했습니다.");
        lottoDtoList.forEach(dto -> System.out.println(toString(dto.getLottoNumbers())));
    }

    private String toString(List<Integer> lottoNumbers) {
        return "[" + lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")) + "]";
    }

    public String setWinNumber() {
        System.out.println("지난주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public void finish(LottoStatisticsDto lottoStatisticsDto) {
        List<Integer> rankList = lottoStatisticsDto.getRankList();
        List<Integer> winningMoney = lottoStatisticsDto.getWinningMoney();
        List<Integer> countOfRank = lottoStatisticsDto.getCountOfRank();
        System.out.println("당청통계");
        System.out.println("---------");
        for (int i = 0; i < rankList.size(); i++) {
            System.out.println(rankList.get(i) + "개 일치 (" + winningMoney.get(i) + ")-" + countOfRank.get(i));
        }
        System.out.println("총 수익률은 " + lottoStatisticsDto.getRatioOfReturn() + "입니다.(기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
    }
}
