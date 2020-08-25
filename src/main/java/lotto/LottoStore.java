package lotto;

import java.util.Scanner;

public class LottoStore {
    public Lottos sold(int price){
        Lottos lottos = new Lottos();
        int amount = price / Lotto.PRICE;
        for(int i = 0 ; i < amount ; i ++){
            lottos.add(LottoFactory.create());
        }

        System.out.println(amount+"개를 구매 했습니다.");
        System.out.println(lottos.toString());

        return lottos;
    }

    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();

        Scanner scanner = new Scanner(System.in);

        System.out.println("구입 금액을 입력 해 주세요.");
        int price = Integer.parseInt(scanner.nextLine());

        Lottos lottos = lottoStore.sold(price);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = scanner.nextLine();

        SummaryPrinter.summary(lottos, winningNumber.split(","));
    }
}