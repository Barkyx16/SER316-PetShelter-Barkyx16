package edu.asu.ser316.petshelter;

public final class RomanNumeral {

  private RomanNumeral() {}

  public static String toRoman(int number) {
    if (number <= 0 || number > 3999) {
      throw new IllegalArgumentException("number must be 1..3999");
    }

    int remaining = number;
    StringBuilder result = new StringBuilder();

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    for (int ix0 = 0; ix0 < values.length; ix0++) {
      while (remaining >= values[ix0]) {
        result.append(symbols[ix0]);
        remaining -= values[ix0];
      }
    }

    return result.toString();
  }
}
