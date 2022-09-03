package com.github.corneil.pingpong

object RomanNumeralConvert {
    enum class Numerals(
        internal val numeral: String,
        internal val arabic: Int
    ) {
        TEN_THOUSAND("x", 10000),
        NINE_THOUSAND("ix", 9000),
        EIGHT_THOUSAND("viii", 8000),
        SEVEN_THOUSAND("vii", 7000),
        SIX_THOUSAND("vi", 6000),
        FIVE_THOUSAND("v", 5000),
        THOUSAND("M", 1000),
        NINE_HUNDRED("CM", 900),
        FIVE_HUNDRED("D", 500),
        FOUR_HUNDRED("CD", 400),
        HUNDRED("C", 100),
        NINETY("XC", 90),
        FIFTY("L", 50),
        FORTY("XL", 40),
        TEN("X", 10),
        NINE("IX", 9),
        FIVE("V", 5),
        FOUR("IV", 4),
        ONE("I", 1)
    }

    fun parse(input: String): Int {
        return Numerals.values()
            .find { input.startsWith(it.numeral) }
            ?.let {
                val len = it.numeral.length
                return if (input.length > len) {
                    it.arabic + parse(input.substring(len))
                } else {
                    it.arabic
                }
            }.let {
                error("Invalid numeral:$input")
            }
    }

    fun convert(value: Int): String {
        val result = StringBuilder()
        var remainder = value
        while (remainder > 0) {
            for (numeral in Numerals.values()) {
                while (remainder >= numeral.arabic) {
                    result.append(numeral.numeral)
                    remainder -= numeral.arabic
                }
            }
        }
        return result.toString()
    }
}
