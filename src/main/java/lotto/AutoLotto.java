package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class AutoLotto {
    public static final int MAX_LOTTO_NUMBER = 45;

    public static final int MAX_PICK_LOTTO_NUMBER = 6;

    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int buyAmt = scanner.nextInt();
        int buyCount = getBuyCount(buyAmt);
        System.out.println(buyCount + "개를 구매했습니다.");

        for (int i = 0; i < buyCount; i++) {
            lottoNumbers = generateLottoNumber();
        }
    }

    public static int getBuyCount(int buyAmt) {
        return (int) Math.floor(buyAmt / LOTTO_PRICE);
    }

    public static final List<Integer> getLottoNumberRange() {
        return IntStream.range(1, MAX_LOTTO_NUMBER+1).boxed().collect(Collectors.toList());
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumber = getLottoNumberRange();
        Collections.shuffle(lottoNumber);
        return lottoNumber.subList(0,MAX_PICK_LOTTO_NUMBER);
    }
}