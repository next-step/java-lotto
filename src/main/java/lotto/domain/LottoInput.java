package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {

    private final int numberOfLotto;

    public LottoInput(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
    }

    public static LottoInput inputLottoCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        int manualLottoNumber = sc.nextInt();
        sc.nextLine();
        return new LottoInput(manualLottoNumber);
    }

    public List<List<Integer>> inputLottoNumbers() {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> numbers = new ArrayList<List<Integer>>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for (int i = 0; i < numberOfLotto; i++) {
            String input = sc.nextLine();
            numbers.add(toIntegerList(input));
        }

        return numbers;
    }

    protected List<Integer> toIntegerList(final String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    public void printTotalLottoCount(int manualLottoCount, int autoLottoCount) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottoCount, autoLottoCount));
    }
}
