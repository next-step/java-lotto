package my.project.lotto.view;


import my.project.constants.Comments;
import my.project.utils.Scan;

import java.util.Scanner;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class InputView {
    Scanner scanner;

    public int getMoney() {
        this.scanner = Scan.getInstance();
        System.out.println(Comments.HOW_MUCH);
        return scanner.nextInt();
    }

}
