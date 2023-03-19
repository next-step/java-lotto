package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class AutoLotto {
    public static final int MAX_LOTTO_NUMBER = 45;

    public static final int MAX_PICK_LOTTO_NUMBER = 6;

    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        ArrayList<Lotto> userLotto = new ArrayList<>();
        Lotto winningLotto;

        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int buyAmt = scanner.nextInt();
        int buyCount = getBuyCount(buyAmt);
        System.out.println(buyCount + "개를 구매했습니다.");

        for (int i = 0; i < buyCount; i++) {
            userLotto.add(new Lotto(generateLottoNumber()));

            System.out.println(userLotto.get(i).getLottoNumber().toString());
        }

        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String inputWinningLotto = scanner.next();

        winningLotto = getWinningLottoNumber(inputWinningLotto);

        System.out.println("보너스 볼을 입력해 주세요.");

    }

    private static Lotto getWinningLottoNumber(String inputWinningLotto) {
        return Arrays.stream(inputWinningLotto.split(","))
                .mapToInt(i -> Integer.parseInt(i))
                .collect(Collectors.toList());
    }

    public static int getBuyCount(int buyAmt) {
        return (int) Math.floor(buyAmt / LOTTO_PRICE);
    }

    public static List<Integer> getLottoNumberRange() {
        return IntStream.range(1, MAX_LOTTO_NUMBER + 1).boxed().collect(Collectors.toList());
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumber = getLottoNumberRange();
        Collections.shuffle(lottoNumber);
        return lottoNumber.subList(0, MAX_PICK_LOTTO_NUMBER);
    }

}
