package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lotto {

	InputView inputView = new InputView();

	private Scanner scanner = new Scanner(System.in);

	private int purchaseAmount;

	private int lottoCount;

	private static final int LOTTO_PRICE_PER_SHEET = 1000;

	private static final int LOTTO_NUMBER_MAX_COUNT = 6;

	private static final int TOTAL_LOTTO_NUMBER_MAX = 45;

	private String lastWeekPrizeNumber;

	private List<Integer> TOTAL_LOTTO_NUMBERS = new ArrayList<>();

	private List<List> randomLottoNumbers = new ArrayList<>();

	public Lotto() {
		for (int i = 0; i < TOTAL_LOTTO_NUMBER_MAX; i++) {
			this.TOTAL_LOTTO_NUMBERS.add(i + 1);
		}
	}

	public void start() {
		printInputUI();

		List<List> randomLottoNumbers = randomShuffle(lottoCount);

		printLottoNumberUI(randomLottoNumbers);

		inputView.print("지난 주 당첨 번호를 입력해 주세요.");
		this.lastWeekPrizeNumber = scanner.next();


	}

	private void printInputUI() {
		inputView.print("구입금액을 입력해 주세요.");
		this.purchaseAmount = scanner.nextInt();
		this.lottoCount = calculateLottoCount(this.purchaseAmount, LOTTO_PRICE_PER_SHEET);
		inputView.print(String.format("%d개를 구매했습니다.", lottoCount));
	}

	public int calculateLottoCount(int purchaseAmount, int lottoPricePerSheet) {
		return purchaseAmount / lottoPricePerSheet;
	}

	public List<List> randomShuffle(int lottoCount) {
		for (int i = 0; i < lottoCount; i++) {
			List<Integer> lottoNumber = generateLotto();
			randomLottoNumbers.add(lottoNumber);
		}
		return randomLottoNumbers;
	}

	private List<Integer> generateLotto() {
		Collections.shuffle(TOTAL_LOTTO_NUMBERS);
		List<Integer> lottoNumber = new ArrayList<>();
		for (int j = 0; j < LOTTO_NUMBER_MAX_COUNT; j++) {
//				System.out.print(TOTAL_LOTTO_NUMBERS.get(j) + ", ");
			lottoNumber.add(TOTAL_LOTTO_NUMBERS.get(j));
		}
		return lottoNumber;
	}

	private void printLottoNumberUI(List<List> randomLottoNumbers) {
		for (List lottoNumber : randomLottoNumbers) {
			inputView.print(lottoNumber.toString());
		}
		inputView.print("");
	}
}
