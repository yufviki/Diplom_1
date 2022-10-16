package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void setBunsForBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientForBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        int expectedBurgerIngredientsCount = 1;
        Assert.assertEquals(expectedBurgerIngredientsCount, burger.ingredients.size());
    }

    @Test
    public void removeIngredientFromBurgerTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);

        burger.removeIngredient(0);

        int expectedBurgerIngredientsCount = 0;
        Assert.assertEquals(expectedBurgerIngredientsCount, burger.ingredients.size());
    }

    @Test
    public void moveIngredientInBurgerTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(secondIngredient);

        burger.moveIngredient(0, 1);

        Ingredient expectedBurgerFirstIngredientAfterMove = secondIngredient;
        Ingredient actualBurgerFirstIngredient = burger.ingredients.get(0);
        Assert.assertEquals(expectedBurgerFirstIngredientAfterMove, actualBurgerFirstIngredient);
    }

    @Test
    public void getPriceShowPriceBurgerTest() {
        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients.add(ingredient);

        float mockedPrice = 100;
        Mockito.when(bun.getPrice()).thenReturn(mockedPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(mockedPrice);

        //Формирование цены: bun.getPrice() * 2 + ingredient.getPrice()
        float expectedBurgerPrice = 100 * 2 + 100;
        float actualBurgerPrice = burger.getPrice();
        Assert.assertEquals(expectedBurgerPrice, actualBurgerPrice, 0);
    }

    @Test
    public void getReceiptShowReceiptBurgerTest() {
        Burger burger = new Burger();
        burger.bun = bun;
        burger.addIngredient(ingredient);

        float mockedPrice = 100;
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(mockedPrice);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("best sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(mockedPrice);

        String expectedBurgerReceipt = "(==== white bun ====)\n" +
                "= sauce best sauce =\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 300,000000\n";
        Assert.assertEquals(expectedBurgerReceipt, burger.getReceipt());
    }
}
