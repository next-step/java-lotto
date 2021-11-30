package com.pollra.calculator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @since       2021.11.29
 * @author      pollra
 **********************************************************************************************************************/
public class Separator {

    private Set<String> separators = new HashSet<>();

    public Separator decompose(String text) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Separator)) return false;
        Separator separator=(Separator) o;
        return Objects.equals(separators, separator.separators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(separators);
    }
}
