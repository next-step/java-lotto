package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.Scanner;

public class InputView {
    private Money price;
    private Lotto wonNumbers;

    public InputView(Question question) {
        Scanner scanner = new Scanner(System.in);
        if (question.equals(Question.PRICE_QUESTION)) {
            System.out.println(Question.PRICE_QUESTION.getQuestionValue());
            price = new Money(scanner.nextInt());
        }
        if (question.equals(Question.WON_NUMBER_QUESTION)) {
            System.out.println(Question.WON_NUMBER_QUESTION.getQuestionValue());
            wonNumbers = new Lotto(scanner.nextLine());
        }
    }

    public InputView(int price) {
        this.price = new Money(price);
    }

    public InputView(String wonNumbers) {
        this.wonNumbers = new Lotto(wonNumbers);
    }

    public Money getPrice() {
        return price;
    }

    public Lotto getWonNumbers() {
        return wonNumbers;
    }
}
