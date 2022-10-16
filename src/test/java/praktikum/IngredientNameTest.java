package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientNameTest {
    private final String expectedName;
    private final String actualName;

    public IngredientNameTest(String expectedName, String actualName) {
        this.expectedName = expectedName;
        this.actualName = actualName;
    }

    @Parameterized.Parameters(name = "Ingredient expected name: {0}, Ingredient actual name: {1}")
    public static Object[][] typeData() {
        return new Object[][]{
                {"hot sauce", "hot sauce"},
                {"", ""}
        };
    }

    @Test
    public void getPriceShowNameIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, actualName, 100);

        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }
}
