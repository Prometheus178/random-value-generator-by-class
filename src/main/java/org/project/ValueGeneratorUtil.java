package org.project;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Author: Sergey.
 */
public class ValueGeneratorUtil {
    private static final Random RANDOM = new Random();


    public static <T> T generate(Class<T> clazz) {
        try {
            T object = clazz.getConstructor().newInstance();
            List<Field> fields = Arrays.stream(clazz.getDeclaredFields())
                    .collect(Collectors.toList());
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(object, getRandomValueForField(field));
            }
            return object;
        } catch (Exception e) {
            throw new RuntimeException("Error generating Object for class " + clazz.getName(), e);
        }
    }

    private static Object getRandomValueForField(Field field) {
        Class<?> type = field.getType();
        if (type.isAssignableFrom(String.class)) {
            return getRandomString();
        } else if (type.isAssignableFrom(Integer.class) || type.isAssignableFrom(int.class)) {
            return getRandomInt();
        } else if (type.isAssignableFrom(Byte.class) || type.isAssignableFrom(byte.class)) {
            return getRandomByte();
        } else if (type.isAssignableFrom(Long.class) || type.isAssignableFrom(long.class)) {
            return getRandomLong();
        } else if (type.isAssignableFrom(Double.class) || type.isAssignableFrom(double.class)) {
            return getRandomDouble();
        } else if (type.isAssignableFrom(Boolean.class) || type.isAssignableFrom(boolean.class)) {
            return getRandomBoolean();
        } else if (type.isAssignableFrom(Float.class) || type.isAssignableFrom(float.class)) {
            // Use the valueOf method to create an instance of Float using a float value
            return getRandomFloat();
        }  else if (type.isAssignableFrom(Character.class) || type.isAssignableFrom(char.class)) {
            return getRandomChar();
        }else if (type.isAssignableFrom(Short.class) || type.isAssignableFrom(short.class)) {
            return getRandomShort();
        } else {
            try {
                Object nestedObject = type.getConstructor().newInstance();
                for (Field nestedField : type.getDeclaredFields()) {
                    nestedField.setAccessible(true);
                    nestedField.set(nestedObject, getRandomValueForField(nestedField));
                }
                return nestedObject;
            } catch (Exception e) {
                throw new RuntimeException("Error generating value for field " + field.getName(), e);
            }
        }
    }

    private static byte getRandomByte() {
        // Generate a random integer between Byte.MIN_VALUE and Byte.MAX_VALUE
        int randomInt = RANDOM.nextInt(Byte.MAX_VALUE - Byte.MIN_VALUE + 1) + Byte.MIN_VALUE;
        // Return the integer as a byte
        return (byte) randomInt;
    }


    private static String getRandomString() {
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    private static int getRandomInt() {
        return RANDOM.nextInt(201) - 100;
    }

    private static long getRandomLong() {
        return RANDOM.nextInt(201) - 100;
    }

    private static double getRandomDouble() {
        return RANDOM.nextDouble();
    }

    private static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    private static char getRandomChar() {
        // Generate a random integer between 0 and 26
        int randomInt = RANDOM.nextInt(26);
        // Return the corresponding character in the alphabet
        return (char)('a' + randomInt);
    }


    private static float getRandomFloat() {
        return RANDOM.nextFloat();
    }

    private static Short getRandomShort() {
        // Generate a random short value
        int randomInt = RANDOM.nextInt(201) - 100;
        return (short) randomInt;
    }

}
