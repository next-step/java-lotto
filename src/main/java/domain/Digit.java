package domain;

import java.util.Objects;

public class Digit {
    private int digit;

    public Digit(String token) {
        this.digit = validate(token);
    }

    public int validate(String token){
        try {
            return Integer.parseUnsignedInt(token);
        }catch (Exception ex){
            throw new RuntimeException("token is not unsigned int");
        }
    }

    public int digit(){
        return digit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit1 = (Digit) o;
        return digit == digit1.digit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit);
    }
}
