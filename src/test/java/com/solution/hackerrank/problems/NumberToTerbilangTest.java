package com.solution.hackerrank.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberToTerbilangTest {


    private NumberToTerbilang converter = new NumberToTerbilang();
    @Test
    void convertToTerbilang() {
        assertEquals("dua puluh dua", converter.convertToTerbilang(22));        // dua puluh dua
        assertEquals("dua belas", converter.convertToTerbilang(12));        // dua belas
        assertEquals("seratus dua puluh tiga", converter.convertToTerbilang(123));       // seratus dua puluh tiga
        assertEquals("lima ribu enam ratus tujuh puluh delapan", converter.convertToTerbilang(5678));      // lima ribu enam ratus tujuh puluh delapan
        assertEquals("seribu", converter.convertToTerbilang(1000));      // seribu
        assertEquals("seribu dua ratus tiga puluh", converter.convertToTerbilang(1230));      // seribu
        assertEquals("sebelas", converter.convertToTerbilang(11));      // seribu
        assertEquals("satu juta", converter.convertToTerbilang(1000000));   // satu juta
        assertEquals("satu miliar", converter.convertToTerbilang(1000000000)); // satu miliar
        assertEquals("satu triliun", converter.convertToTerbilang(1000000000000L)); // satu triliun
        assertEquals("satu triliun satu", converter.convertToTerbilang(1000000000001L)); // satu triliun

    }
}