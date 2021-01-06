package com.github.corneil.pingpong

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*


/**
 * Created by Corneil on 2016-07-21.
 */
class RomanNumeralConverterTest {
	@Test
	fun testConvert1() {
		assertEquals("I", RomanNumeralConvert.convert(1))
	}

	@Test
	fun testConvert2() {
		assertEquals("II", RomanNumeralConvert.convert(2))
	}

	@Test
	@Throws(Exception::class)
	fun testConvert3() {
		assertEquals("III", RomanNumeralConvert.convert(3))
	}

	@Test
	@Throws(Exception::class)
	fun testConvert4() {
		assertEquals("IV", RomanNumeralConvert.convert(4))
	}

	@Test
	@Throws(Exception::class)
	fun testConvert5() {
		assertEquals("V", RomanNumeralConvert.convert(5))
	}

	@Test
	@Throws(Exception::class)
	fun testConvert9() {
		assertEquals("IX", RomanNumeralConvert.convert(9))
	}

	@Test
	@Throws(Exception::class)
	fun testConvert10() {
		assertEquals("X", RomanNumeralConvert.convert(10))
	}

	@Test
	@Throws(Exception::class)
	fun testConvert50() {
		assertEquals("L", RomanNumeralConvert.convert(50))
	}

	@Test
	@Throws(Exception::class)
	fun testConvert40() {
		assertEquals("XL", RomanNumeralConvert.convert(40))
		assertEquals("XLI", RomanNumeralConvert.convert(41))
		assertEquals("XXXIX", RomanNumeralConvert.convert(39))
	}

	@Test
	@Throws(Exception::class)
	fun testConvert90() {
		assertEquals("LXXXIX", RomanNumeralConvert.convert(89))
		assertEquals("XC", RomanNumeralConvert.convert(90))
		assertEquals("XCI", RomanNumeralConvert.convert(91))
	}

	@Test
	fun testParse1() {
		assertEquals(1, RomanNumeralConvert.parse("I").toLong())
	}

	@Test
	fun testParse4() {
		assertEquals(4, RomanNumeralConvert.parse("IV").toLong())
	}

	@Test
	fun testParse9() {
		assertEquals(9, RomanNumeralConvert.parse("IX").toLong())
	}

	@Test
	fun testParse10() {
		assertEquals(10, RomanNumeralConvert.parse("X").toLong())
	}

	@Test
	fun testParse5326() {
		assertEquals(5623, RomanNumeralConvert.parse("MMMMMDCXXIII").toLong())
	}

	@Test
	fun testParse1965() {
		assertEquals(1965, RomanNumeralConvert.parse("MCMLXV").toLong())
	}

	@Test
	fun testParse1991() {
		assertEquals(1991, RomanNumeralConvert.parse("MCMXCI").toLong())
	}

	@Test
	fun testWide() {
		val rand = Random()
		for (i in 0..499) {
			val number = rand.nextInt(10000)
			val numerals = RomanNumeralConvert.convert(number)
			val arabic = RomanNumeralConvert.parse(numerals)
			assertEquals(number.toLong(), arabic.toLong(), "Problem converting:$number:$numerals")
		}
	}
}
