package lotto.domain2;

import java.util.Objects;

public class User {
    private final int money;

    public User(final int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return money == user.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
