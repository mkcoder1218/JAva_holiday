import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents the student test cases for HolidayBonus.
 */
public class HolidayBonusTestStudent {
    private double[][] dataSet1 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
    private double[][] dataSet2 = {{-1, 2, -3}, {4, -5}, {6, -7, 8, -9}};
    private double[][] dataSet3 = {{0, 0, 0}, {0, 0}, {0, 0, 0, 0}};
    private double[][] dataSet4 = {{7}};

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test calculateHolidayBonus method with dataset1
     */
    @Test
    public void testCalculateHolidayBonusA() {
        double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
        assertEquals(3000.0, result[0], 0.001);
        assertEquals(4000.0, result[1], 0.001);
        assertEquals(15000.0, result[2], 0.001);
    }

    /**
     * Test calculateHolidayBonus method with dataset2 (includes negative values)
     */
    @Test
    public void testCalculateHolidayBonusB() {
        double[] result = HolidayBonus.calculateHolidayBonus(dataSet2);
        assertEquals(5000.0, result[0], 0.001);   // Highest in column 1 (2)
        assertEquals(5000.0, result[1], 0.001);   // Highest in column 0 (4)
        assertEquals(10000.0, result[2], 0.001);  // Highest in column 0 (6) and column 2 (8)
    }

    /**
     * Test calculateHolidayBonus method with dataset3 (all zeros)
     */
    @Test
    public void testCalculateHolidayBonusC() {
        double[] result = HolidayBonus.calculateHolidayBonus(dataSet3);
        assertEquals(0.0, result[0], 0.001);
        assertEquals(0.0, result[1], 0.001);
        assertEquals(0.0, result[2], 0.001);
    }

    /**
     * Test calculateHolidayBonus method with dataset4 (only one store with one category)
     */
    @Test
    public void testCalculateHolidayBonusD() {
        double[] result = HolidayBonus.calculateHolidayBonus(dataSet4);
        assertEquals(5000.0, result[0], 0.001);  // Only one store with positive sales gets highest bonus
    }

    /**
     * Test calculateTotalHolidayBonus method with dataset1
     */
    @Test
    public void testCalculateTotalHolidayBonusA() {
        assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), 0.001);
    }

    /**
     * Test calculateTotalHolidayBonus method with dataset2 (includes negative values)
     */
    @Test
    public void testCalculateTotalHolidayBonusB() {
        assertEquals(20000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2), 0.001);
    }

    /**
     * Test calculateTotalHolidayBonus method with dataset3 (all zeros)
     */
    @Test
    public void testCalculateTotalHolidayBonusC() {
        assertEquals(0.0, HolidayBonus.calculateTotalHolidayBonus(dataSet3), 0.001);
    }

    /**
     * Test calculateTotalHolidayBonus method with dataset4 (only one store with one category)
     */
    @Test
    public void testCalculateTotalHolidayBonusD() {
        assertEquals(5000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet4), 0.001);
    }
} 