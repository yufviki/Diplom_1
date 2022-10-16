package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientPriceTest {
    private final float expectedPrice;
    private final float actualPrice;

    public IngredientPriceTest(float expectedPrice, float actualPrice) {
        this.expectedPrice = expectedPrice;
        this.actualPrice = actualPrice;
    }

    @Parameterized.Parameters(name = "Ingredient Price Expected: {0}, Ingredient Price actual: {1}")
    public static Object[][] typeData() {
        return new Object[][]{
                {0, 0},
                {-1, -1},
                {500, 500}
        };
    }

    @Test
    public void getPriceShowPriceIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", actualPrice);

        float ingredientPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, ingredientPrice, 0);
    }
}
