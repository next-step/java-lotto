package autolotto;

public class Lottery {
    public static void main(String[] args) {
        int purchaseAmount = new LottoInput().prompt("구입 금액을 입력해주세요. 단위는 1000원이며 양수만 입력 가능합니다. ex. 14000 -> 14");
        System.out.println(purchaseAmount);
    }
}
