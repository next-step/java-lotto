package lotto;

public class Main {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.start();
        }catch (Exception exception){
            System.out.println(String.join("\n", "ERROR", exception.getMessage()));
        }
    }
}
