package autolotto;

public class Lottery {
    public static void main(String[] args) {
        int purchaseAmount = new LottoInput().prompt("구입 장수를 입력해주세요. 1장 당 1000원이며 양수만 입력 가능합니다. ex. 14000 -> 14");
        new LottoOutput().println(purchaseAmount + "장을 구입했습니다.");
    }
}
