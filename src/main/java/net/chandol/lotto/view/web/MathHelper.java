package net.chandol.lotto.view.web;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MathHelper implements Helper<Object> {

  public enum Operator {
    add("+"),
    subtract("-"),
    multiply("*"),
    divide("/"),
    mod("%");

    private Operator(String symbol) {
      this.symbol = symbol;
    }

    private String symbol;

    public static Operator fromSymbol(String symbol) {
      Operator op = null;
      if (symbol.equals("+")) {
        op = add;
      } else if (symbol.equals("-")) {
        op = subtract;
      } else if (symbol.equals("*")) {
        op = multiply;
      } else if (symbol.equals("/")) {
        op = divide;
      } else if (symbol.equals("%")) {
        op = mod;
      }
      return op;
    }
  }

  @Override
  public CharSequence apply(final Object value, Options options) throws IOException, IllegalArgumentException {
    if (options.params.length >= 2) {
      Operator op = Operator.fromSymbol(options.param(0).toString());
      if (op == null) {
        throw new IllegalArgumentException("Unknown operation '" + options.param(0) + "'");
      }

      Integer scale = options.hash("scale");

      MathContext mc = new MathContext(16, RoundingMode.HALF_UP);

      if (value == null || options.param(1) == null) {
        throw new IllegalArgumentException("Cannot perform operations on null values");
      }
      
      BigDecimal t0 = new BigDecimal(value.toString());
      BigDecimal t1 = new BigDecimal(options.param(1).toString());
      BigDecimal result;
      switch (op) {
        case add:
          result = t0.add(t1, mc);
          break;
        case subtract:
          result = t0.subtract(t1, mc);
          break;
        case multiply:
          result = t0.multiply(t1, mc);
          break;
        case divide:
          result = t0.divide(t1, mc);
          break;
        case mod:
          result = t0.remainder(t1, mc);
          break;
        default:
          throw new IllegalArgumentException("Unknown operation '" + options.param(0) + "'");
      }
      if (scale != null) {
        result = result.setScale(scale, BigDecimal.ROUND_HALF_UP);
      }
      return result.toString();
    } else {
      throw new IOException("MathHelper requires three parameters");
    }
  }
}