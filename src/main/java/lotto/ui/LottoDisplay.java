package lotto.ui;

import java.util.stream.Stream;

public class LottoDisplay {
    public static final String NEW_LINE = "\n";

    public static void display(Object o){
        display(o.toString());
    }

    public static void display(String msg){
        System.out.println(msg);
    }

    public static void newLine(){
        newLine(1);
    }

    public static void newLine(int newLineCount){
        Stream
            .iterate(0,(i)->i+1)
            .limit(newLineCount)
            .map(e -> NEW_LINE)
            .forEach(System.out::print);
    }
}
