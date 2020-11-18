package lotto.view.printable;

import java.util.Scanner;

public abstract class Printable {
    static final Scanner scanner = new Scanner(System.in);

    static void println(String str) {
        System.out.println(str);
    }

    public abstract void print();
}
