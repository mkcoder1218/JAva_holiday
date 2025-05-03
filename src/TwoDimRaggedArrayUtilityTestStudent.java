import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents the student test cases for TwoDimRaggedArrayUtility.
 */
public class TwoDimRaggedArrayUtilityTestStudent {
    private double[][] dataSet1 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
    private double[][] dataSet2 = {{-1, 2, -3}, {4, -5}, {6, -7, 8, -9}};
    private double[][] dataSet3 = {{0, 0, 0}, {0, 0}, {0, 0, 0, 0}};
    private File tempFile;

    @Before
    public void setUp() throws Exception {
        tempFile = new File("temp.txt");
    }

    @After
    public void tearDown() throws Exception {
        tempFile.delete();
    }

    /**
     * Test readFile and writeToFile methods
     */
    @Test
    public void testReadFileWriteToFile() {
        try {
            // Write the ragged array to a file
            TwoDimRaggedArrayUtility.writeToFile(dataSet1, tempFile);
            
            // Read it back
            double[][] array = TwoDimRaggedArrayUtility.readFile(tempFile);
            
            // Check if the array was read correctly
            assertEquals(dataSet1.length, array.length);
            
            for (int i = 0; i < dataSet1.length; i++) {
                assertEquals(dataSet1[i].length, array[i].length);
                for (int j = 0; j < dataSet1[i].length; j++) {
                    assertEquals(dataSet1[i][j], array[i][j], 0.001);
                }
            }
        } catch (FileNotFoundException e) {
            fail("Failed with FileNotFoundException");
        }
    }

    /**
     * Test getTotal method
     */
    @Test
    public void testGetTotal() {
        assertEquals(45.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), 0.001);
        assertEquals(-5.0, TwoDimRaggedArrayUtility.getTotal(dataSet2), 0.001);
        assertEquals(0.0, TwoDimRaggedArrayUtility.getTotal(dataSet3), 0.001);
    }

    /**
     * Test getAverage method
     */
    @Test
    public void testGetAverage() {
        assertEquals(5.0, TwoDimRaggedArrayUtility.getAverage(dataSet1), 0.001);
        assertEquals(-0.5556, TwoDimRaggedArrayUtility.getAverage(dataSet2), 0.001);
        assertEquals(0.0, TwoDimRaggedArrayUtility.getAverage(dataSet3), 0.001);
    }

    /**
     * Test getRowTotal method
     */
    @Test
    public void testGetRowTotal() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), 0.001);
        assertEquals(30.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 2), 0.001);
        
        assertEquals(-2.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 0), 0.001);
        assertEquals(-1.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 1), 0.001);
        assertEquals(-2.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 2), 0.001);
    }

    /**
     * Test getColumnTotal method
     */
    @Test
    public void testGetColumnTotal() {
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), 0.001);
        assertEquals(14.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1), 0.001);
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 3), 0.001);
    }

    /**
     * Test getHighestInRow method
     */
    @Test
    public void testGetHighestInRow() {
        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), 0.001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 1), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2), 0.001);
    }

    /**
     * Test getHighestInRowIndex method
     */
    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 1));
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2));
    }

    /**
     * Test getLowestInRow method
     */
    @Test
    public void testGetLowestInRow() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0), 0.001);
        assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1), 0.001);
        assertEquals(6.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2), 0.001);
    }

    /**
     * Test getLowestInRowIndex method
     */
    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2));
    }

    /**
     * Test getHighestInColumn method
     */
    @Test
    public void testGetHighestInColumn() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0), 0.001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1), 0.001);
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 3), 0.001);
    }

    /**
     * Test getHighestInColumnIndex method
     */
    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 0));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 3));
    }

    /**
     * Test getLowestInColumn method
     */
    @Test
    public void testGetLowestInColumn() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0), 0.001);
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1), 0.001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 3), 0.001);
    }

    /**
     * Test getLowestInColumnIndex method
     */
    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2));
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 3));
    }

    /**
     * Test getHighestInArray method
     */
    @Test
    public void testGetHighestInArray() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), 0.001);
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet2), 0.001);
        assertEquals(0.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet3), 0.001);
    }

    /**
     * Test getLowestInArray method
     */
    @Test
    public void testGetLowestInArray() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), 0.001);
        assertEquals(-9.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet2), 0.001);
        assertEquals(0.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet3), 0.001);
    }
} 