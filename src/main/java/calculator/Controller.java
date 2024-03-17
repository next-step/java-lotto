package calculator;

import java.util.Scanner;

public class Controller {

    private Scanner scanner = new Scanner(System.in);
    private Service service = new Service();

    public void start() {
        System.out.println("계산식을 입력해주세요.");
        System.out.println(service.start(scanner.nextLine()));
    }

}
