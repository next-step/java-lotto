package lotto.view.printable;

public abstract class Printable {
    static void println(Object obj) {
        System.out.println(obj);
    }

    public abstract void print();
}
