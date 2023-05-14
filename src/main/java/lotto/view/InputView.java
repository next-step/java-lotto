package lotto.view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {
    private int price;
    private Set<Integer> wonNumbers = new HashSet<>();

    public InputView(Question question) {
        Scanner scanner = new Scanner(System.in);
        if (question.equals(Question.PRICE_QUESTION)) {
            System.out.println(Question.PRICE_QUESTION.getQuestionValue());
            price = scanner.nextInt();
        }
        if (question.equals(Question.WON_NUMBER_QUESTION)) {
            System.out.println(Question.WON_NUMBER_QUESTION.getQuestionValue());
            wonNumbers = getWonNumbers(scanner.nextLine());
        }
    }

    public InputView(int price) {
        this.price = price;
    }

    public InputView(String wonNumbers) {
        this.wonNumbers = getWonNumbers(wonNumbers);
    }

    public int getPrice() {
        return price;
    }

    public Set<Integer> getWonNumbers() {
        return wonNumbers;
    }

    private HashSet<Integer> getWonNumbers(String answer) {
        HashSet<Integer> numbers = new HashSet<>();

        String[] params = answer.replaceAll("\\s+", "").split(",");
        for (String param : params) {
            try {
                numbers.add(Integer.parseInt(param));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘몬된 값을 입력하였습니다.");
            }
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개입니다. 다시 입력해주세요.");
        }

        numbers.stream()
                .filter(i -> i < 1 || i > 45)
                .findAny()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("1부터 45까지의 숫자만 가능합니다.");
                });
        return numbers;
    }
}
