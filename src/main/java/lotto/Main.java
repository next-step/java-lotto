package lotto;

public class Main {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new LottoView());
        lottoMachine.start();
    }
}
