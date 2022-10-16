package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType expectedType;
    private final IngredientType actualType;

    public IngredientTypeTest(IngredientType expectedType, IngredientType actualType) {
        this.expectedType = expectedType;
        this.actualType = actualType;
    }

    @Parameterized.Parameters(name = "Ingredient Type Expected: {0}, Ingredient Type actual: {1}")
    public static Object[][] typeData() {
        return new Object[][]{
                {IngredientType.SAUCE, IngredientType.SAUCE},
                {IngredientType.FILLING, IngredientType.FILLING}
        };
    }

    @Test
    public void getTypeShowTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(actualType, "hot sauce", 100);

        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(expectedType, actualType);
    }
}
