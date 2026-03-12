package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineTest {

    Feline feline = new Feline();

    @Test
    void checkEatMeatReturnsPredatorsFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood, "Метод должен вернуть список еды для хищника");
    }

    @Test
    void checkGetFamilyReturnsCatFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();

        assertEquals(expectedFamily, actualFamily, "Метод должен вернуть семейство Кошачьи");
    }

    @Test
    void checkGetKittensReturnOne() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();

        assertEquals(expectedKittens, actualKittens, "По умолчанию метод должен вернуть значение 1");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 5, 10})
    void checkGetKittensReturnsCorrectValue(int kittensCount) {
        int actualKittens = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actualKittens, "Метод должен вернуть то же число, которое получил на вход");
    }
}