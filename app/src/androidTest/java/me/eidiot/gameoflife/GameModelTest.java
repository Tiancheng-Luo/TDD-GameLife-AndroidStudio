package me.eidiot.gameoflife;

import junit.framework.TestCase;

public class GameModelTest extends TestCase {

    GameModel instance;
    public void setUp() throws Exception {
        super.setUp();
        instance = new GameModel(3, 3);
    }

    public void test_init() throws Exception {
        assertEquals(3, instance.getRows());
        assertEquals(3, instance.getColumns());
    }

    public void test_is_alive() throws Exception {
        assertFalse(instance.isAlive(0, 0));

        assertFalse(instance.isAlive(-1, 0));
        assertFalse(instance.isAlive(0, -1));
        assertFalse(instance.isAlive(3, 0));
        assertFalse(instance.isAlive(0, 3));
    }

    public void test_make_alive() throws Exception {
        instance.makeAlive(0, 0);
        assertTrue(instance.isAlive(0, 0));

        instance.makeAlive(-1, 0);
        instance.makeAlive(0, -1);
        instance.makeAlive(3, 0);
        instance.makeAlive(0, 3);
    }

    public void test_make_dead() throws Exception {
        instance.makeAlive(0, 0);
        instance.makeDead(0, 0);
        assertFalse(instance.isAlive(0, 0));

        instance.makeDead(-1, 0);
        instance.makeDead(0, -1);
        instance.makeDead(3, 0);
        instance.makeDead(0, 3);
    }
}