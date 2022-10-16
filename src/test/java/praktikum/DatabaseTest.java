package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTest {
    @Test
    public void availableBunsShowCountBunsTest(){
        Database database = new Database();

        int expectedCountBuns = 3;
        Assert.assertEquals(expectedCountBuns, database.availableBuns().size());
    }

    @Test
    public void availableIngredientsShowCountIngredientsTest(){
        Database database = new Database();

        int expectedCountIngredients = 6;
        Assert.assertEquals(expectedCountIngredients, database.availableIngredients().size());
    }
}
