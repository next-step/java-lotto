package step3.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerLotto {
	private static List<Integer> winningNumber;
	private static int bonusNumber;

	public WinnerLotto(String winningNumber, int bonusNumber) {
		this.winningNumber = splitWinningNumber(winningNumber);
		checkWinningNumber();
		this.bonusNumber = bonusNumber;
		checkBonusNumber();
	}

	private static List<Integer> splitWinningNumber(String winningNumber) {
		return Arrays.stream(winningNumber.replaceAll(" ", "").split(","))
				.map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());
	}

	private void checkWinningNumber(){
		winningNumber.stream().mapToInt(number -> number)
				.filter(number -> number < 1 || number > 45)
				.forEach(number -> {throw new IllegalArgumentException("지난주 당첨 번호가 잘못 입력되었습니다.");
		});

		if(winningNumber.size() != winningNumber.stream().distinct().count()){
			throw new IllegalArgumentException("지난 주 당첨 번호에 중복된 번호가 들어있습니다.");
		}
	}

	private void checkBonusNumber(){
		if(winningNumber.contains(bonusNumber)){
			throw new IllegalArgumentException("보너스 번호가 지난주 당첨 번호에 있습니다.");
		}

		if(bonusNumber > 45 || bonusNumber < 1) {
			throw new IllegalArgumentException("보너스 번호가 입력될 수 있는 범위를 넘었습니다.");
		}
	}

	private static int countHit(List<Integer> lottoList) {
		int hitCnt = (int) winningNumber.stream()
				.mapToInt(hitNumber -> hitNumber)
				.filter(lottoList::contains)
				.count();
		return hitCnt;
	}

	private static boolean checkBonusHit(List<Integer> lottoList) {
		return lottoList.contains(bonusNumber);
	}

	public int match(Lotto lotto) {
		List<Integer> numberList = lotto.getNumberList();
		return rank(countHit(numberList), checkBonusHit(numberList));
	}
	public static int rank(final int matchCnt, final boolean matchBonus){
		if(matchCnt == 6) return 1;
		if(matchCnt == 5 && matchBonus) return 2;
		if (matchCnt > 2) {
			return 6 - matchCnt +2;
		}
		return 0;
	}
}
