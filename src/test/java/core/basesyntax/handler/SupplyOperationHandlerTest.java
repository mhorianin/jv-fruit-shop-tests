package core.basesyntax.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import org.junit.jupiter.api.Test;

class SupplyOperationHandlerTest {
    private FruitDao fruitDao = new FruitDaoImpl();
    private SupplyOperationHandler supplyOperationHandler = new SupplyOperationHandler(fruitDao);

    @Test
    void fruitOperation_validOperation_ok() {
        Fruit apple = new Fruit();
        apple.setTypeFruit("apple");
        apple.setQuantity(50);
        apple.setTypeOperation(Fruit.Operation.RETURN);

        fruitDao.add("apple", 50);

        supplyOperationHandler.fruitOperation(apple);

        assertEquals(100, fruitDao.get("apple"),
                "Incorrectly entered data. Please check the data");
    }
}
