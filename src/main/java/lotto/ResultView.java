package lotto;

public class ResultView {

    public static void printLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        printLottos(new Lottos(5));
    }
}
