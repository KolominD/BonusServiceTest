import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService servise = new BonusService();
        long amount = 1000_60;
        boolean registred = true;
        long expected = 30;
        long actual = servise.calculate(amount, registred);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredNearBelowLimit() {
        BonusService service = new BonusService();

        long amount = 16634_00;
        boolean registered = true;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredNearOverLimit() {
        BonusService service = new BonusService();

        long amount = 16677_00;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredZero() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForNotRegAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void
    shouldCalculateForNotRegNearBelowLimit() {
        BonusService service = new BonusService();

        long amount = 49999_00;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForNotRegisteredNearOverLimit() {
        BonusService service = new BonusService();

        long amount = 50100_00;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForNotRegZero() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

}