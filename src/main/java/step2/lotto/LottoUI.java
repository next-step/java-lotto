package step2.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step2.lotto.domain.LottoTicket;
import step2.lotto.domain.LottoTickets;
import step2.lotto.domain.LottoWinningStatisticDto;

public class LottoUI {
	private static final Scanner sc = new Scanner(System.in);

	public static int uiForLottoPurchase() {
		System.out.println("구입 금액을 입력해주세요.");

		int amount = Integer.parseInt(sc.nextLine());
		int lottoCount = amount / LottoTicket.PRICE;

		System.out.println(lottoCount + "개를 구매했습니다.");

		return lottoCount;
	}

	public static void printLottoTickets(LottoTickets lottoTickets) {
		for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
			String joinedNumbers = getJoinedLottoNumbers(lottoTicket);

			System.out.println("[" + joinedNumbers + "]");
		}
	}

	private static String getJoinedLottoNumbers(LottoTicket lottoTicket) {
		List<Integer> numbers = lottoTicket.getNumbers();

		String joinedNumbers = numbers.stream()
			.map(String::valueOf)
			.collect(Collectors.joining(", "));

		return joinedNumbers;
	}

	public static List<Integer> uiForWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해주세요.");

		List<Integer> winningNumbers = Arrays.stream(sc.nextLine().split(", "))
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		return winningNumbers;
	}

	public static void printLottoWinningStatistic(LottoWinningStatisticDto lottoWinningStatisticDto) {
		System.out.println("당첨 통계");
		System.out.println("---------");

		System.out.println("3개 일치 (5000원) - " + lottoWinningStatisticDto.getThreeMatch() + "개");
		System.out.println("4개 일치 (50000원) - " + lottoWinningStatisticDto.getFourMatch() + "개");
		System.out.println("5개 일치 (1500000원) - " + lottoWinningStatisticDto.getFiveMatch() + "개");
		System.out.println("6개 일치 (2000000000원) - " + lottoWinningStatisticDto.getSixMatch() + "개");
		System.out.println("총 수익률은 " + lottoWinningStatisticDto.getProfitRate() + "입니다.");
	}
}
