package study.lotto.view;

import java.util.Scanner;

public abstract class AbstractView {

    protected final Scanner scanner;
    protected final StringBuilder stringBuilder;

    public AbstractView() {
        this.scanner = new Scanner(System.in);
        this.stringBuilder = new StringBuilder();
    }

    protected void clearStringBuilder() {
        stringBuilder.setLength(0);
    }

    protected void print() {
        System.out.println(stringBuilder.toString());
    }

    protected void printAndClear() {
        print();
        clearStringBuilder();
    }

}
