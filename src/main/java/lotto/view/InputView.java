package lotto.view;

import java.util.*;

public class InputView {
    private static final int UNIT_PRICE = 1000;
    private int price;
    private HashSet<Integer> wonNumbers = new HashSet<>();

    public InputView(Question question) {
        Scanner scanner = new Scanner(System.in);
        if (question.equals(Question.PRICE_QUESTION)) {
            System.out.println(Question.PRICE_QUESTION.getQuestionValue());
            price = amonut(scanner.nextInt());
        }
        if (question.equals(Question.WON_NUMBER_QUESTION)) {
            System.out.println(Question.WON_NUMBER_QUESTION.getQuestionValue());
            wonNumbers = getWonNumbers(scanner.nextLine());
        }
    }

    public InputView(int price) {
        this.price = amonut(price);
    }

    public InputView(String wonNumbers) {
        this.wonNumbers = getWonNumbers(wonNumbers);
    }

    public int getPrice() {
        return price;
    }

    public HashSet<Integer> getWonNumbers() {
        return wonNumbers;
    }

    public int amonut(int price) {
        if (price % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("로또의 1장당 가격은 1,000원입니다. 원하는 장수 만큼의 금액을 입력해주세요.");
        }
        return price / UNIT_PRICE;
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
