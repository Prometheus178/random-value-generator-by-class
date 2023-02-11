package org.project;



import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ValueGeneratorUtilTest {

    private static final int NUM_TESTS = 100;

    @Test
    public void testGenerateString() {
        for (int i = 0; i < NUM_TESTS; i++) {
            Example testClass = ValueGeneratorUtil.generate(Example.class);
            assertNotNull(testClass);
        }
    }

    @Test
    public void testGenerateInteger() {
        for (int i = 0; i < NUM_TESTS; i++) {
            Example testClass = ValueGeneratorUtil.generate(Example.class);
            assertTrue(testClass.getIntegerField() >= -100 && testClass.getIntegerField() <= 100);
        }
    }

    @Test
    public void testGenerateByte() {
        for (int i = 0; i < NUM_TESTS; i++) {
            Example testClass = ValueGeneratorUtil.generate(Example.class);
            assertTrue(testClass.getByteField() >= Byte.MIN_VALUE && testClass.getByteField() <= Byte.MAX_VALUE);
        }
    }

    @Test
    public void testGenerateLong() {
        for (int i = 0; i < NUM_TESTS; i++) {
            Example testClass = ValueGeneratorUtil.generate(Example.class);
            assertTrue(testClass.getLongField() >= -100 && testClass.getLongField() <= 100);
        }
    }

    @Test
    public void testGenerateDouble() {
        for (int i = 0; i < NUM_TESTS; i++) {
            Example testClass = ValueGeneratorUtil.generate(Example.class);
            assertTrue(testClass.getDoubleField() >= 0.0 && testClass.getDoubleField() <= 1.0);
        }
    }

    @Test
    public void testGenerateBoolean() {
        for (int i = 0; i < NUM_TESTS; i++) {
            Example testClass = ValueGeneratorUtil.generate(Example.class);
            assertTrue(testClass.getBooleanWrapperField() == true || testClass.getBooleanWrapperField() == false);
        }
    }

    @Test
    public void testGenerateFloat() {
        for (int i = 0; i < NUM_TESTS; i++) {
            Example testClass = ValueGeneratorUtil.generate(Example.class);
            assertTrue(testClass.getFloatField() >= 0.0f && testClass.getFloatField() <= 1.0f);
        }
    }

}