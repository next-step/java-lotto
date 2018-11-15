package view;

import java.util.*;

public class InputView {
    static final int LOTTOBALLS = 6;
    static final int PRICE = 1000;

    public static int purchasingAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int amount = sc.nextInt();
        return amount;
    }

    public static int numberOfPurchase(int money) throws Exception{
        if(money < PRICE) {
            throw new Exception("1000원 이상 입력");
        }
        return money/PRICE;
    }

    public static List<Integer> typeLottoNumbers() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String str = sc.nextLine();
        List<Integer> list = putWinningLotto(str);

        return list;
    }

    public static List<Integer> putWinningLotto(String str) throws Exception {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(String s : str.split(", |,")) {
            set.add(Integer.parseInt(s));
            list.add(Integer.parseInt(s));
        }

        if(list.size() != LOTTOBALLS) {
            throw new Exception("6개의 로또번호를 입력");
        }

        if(set.size() != list.size()) {
            throw new Exception("중복된 숫자를 입력하지 마세요");
        }

        return list;
    }
}
