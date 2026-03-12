package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline feline;

    @ParameterizedTest(name = "Пол: {0}, грива присутствует: {1}")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void checkIsLionHasManeDifferentSex(String sex, boolean expectedResult) throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedResult, lion.doesHaveMane());
    }

    @Test
    void checkExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Оно", feline);
        });
    }

    @Test
    void checkGetKittensFromFeline() throws Exception {
        Lion lion = new Lion ("Самка", feline);
        int expectedKittens = 3;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittens);

        int actualKittens = lion.getKittens();

        assertEquals(expectedKittens, actualKittens, "Метод должен вернуть кол-во котят, полученное из Feline");

        Mockito.verify(feline).getKittens();
    }

    @Test
    void checkGetFoodFromFeline() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood, "Метод должен вернуть список еды, полученный из Feline");

        Mockito.verify(feline).eatMeat();
    }
}