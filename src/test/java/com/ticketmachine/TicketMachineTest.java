
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {

    private TicketMachine ticketMachine;

    @Before
    public void setUp() {
        // Assuming TicketMachine has a constructor that takes an integer for price
        ticketMachine = new TicketMachine(5);
    }

    @Test
    public void testInsertMoney() {
        ticketMachine.inserir(10); // Insert 10
        assertEquals(10, ticketMachine.getSaldo()); // Assuming getSaldo() returns current balance
    }

    @Test
    public void testBalanceAfterPurchase() {
        ticketMachine.inserir(10);
        ticketMachine.imprimir(); // Assuming this deducts the price of the ticket
        assertEquals(5, ticketMachine.getSaldo()); // Balance should be 5 after purchase
    }

    @Test(expected = PapelMoedaInvalidaException.class)
    public void testInvalidCoin() throws PapelMoedaInvalidaException {
        // Assuming inserting an invalid coin throws an exception
        ticketMachine.inserir(3); // Invalid coin
    }
}
