package cc.oakk.lotto;

public class LottoApplication {
    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate());
        }
    }
}
