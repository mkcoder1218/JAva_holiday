import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Utility class for working with ragged 2D arrays of doubles.
 * This class contains static methods for reading, writing, and 
 * performing various calculations on ragged 2D arrays of double values.
 */
public class TwoDimRaggedArrayUtility {
    
    /**
     * Reads from a file and returns a ragged array of doubles
     * @param file - the file to read from
     * @return - the ragged array
     * @throws FileNotFoundException if the file is not found
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        
        // Count the number of rows
        int numRows = 0;
        String[] temp = new String[10]; // Assuming max 10 rows initially
        
        while (scanner.hasNextLine()) {
            temp[numRows] = scanner.nextLine();
            numRows++;
            // Extend array if needed
            if (numRows >= temp.length) {
                String[] newTemp = new String[temp.length * 2];
                System.arraycopy(temp, 0, newTemp, 0, temp.length);
                temp = newTemp;
            }
        }
        scanner.close();
        
        // Create the array with the correct number of rows
        double[][] data = new double[numRows][];
        
        // Fill the array
        for (int i = 0; i < numRows; i++) {
            Scanner lineScanner = new Scanner(temp[i]);
            
            // Count the number of values in this row
            int numCols = 0;
            double[] rowTemp = new double[10]; // Assuming max 10 columns initially
            
            while (lineScanner.hasNextDouble()) {
                rowTemp[numCols] = lineScanner.nextDouble();
                numCols++;
                // Extend array if needed
                if (numCols >= rowTemp.length) {
                    double[] newRowTemp = new double[rowTemp.length * 2];
                    System.arraycopy(rowTemp, 0, newRowTemp, 0, rowTemp.length);
                    rowTemp = newRowTemp;
                }
            }
            lineScanner.close();
            
            // Create the row with the correct number of columns
            data[i] = new double[numCols];
            System.arraycopy(rowTemp, 0, data[i], 0, numCols);
        }
        
        return data;
    }
    
    /**
     * Writes the ragged array of doubles to a file
     * @param data - the ragged array
     * @param outputFile - the file to write to
     * @throws FileNotFoundException if the file is not found
     */
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                writer.print(data[i][j]);
                if (j < data[i].length - 1) {
                    writer.print(" ");
                }
            }
            writer.println();
        }
        
        writer.close();
    }
    
    /**
     * Returns the total of all elements in the ragged array
     * @param data - the ragged array
     * @return the sum of all elements
     */
    public static double getTotal(double[][] data) {
        double total = 0;
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
        }
        
        return total;
    }
    
    /**
     * Returns the average of all elements in the ragged array
     * @param data - the ragged array
     * @return the average of all elements
     */
    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
                count++;
            }
        }
        
        return total / count;
    }
    
    /**
     * Returns the total of a specified row in the ragged array
     * @param data - the ragged array
     * @param row - the row index
     * @return the sum of all elements in the row
     */
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        
        for (int j = 0; j < data[row].length; j++) {
            total += data[row][j];
        }
        
        return total;
    }
    
    /**
     * Returns the total of a specified column in the ragged array
     * @param data - the ragged array
     * @param col - the column index
     * @return the sum of all elements in the column
     */
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                total += data[i][col];
            }
        }
        
        return total;
    }
    
    /**
     * Returns the highest value in a specified row in the ragged array
     * @param data - the ragged array
     * @param row - the row index
     * @return the highest value in the row
     */
    public static double getHighestInRow(double[][] data, int row) {
        if (data[row].length == 0) {
            return 0;
        }
        
        double highest = data[row][0];
        
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] > highest) {
                highest = data[row][j];
            }
        }
        
        return highest;
    }
    
    /**
     * Returns the index of the highest value in a specified row in the ragged array
     * @param data - the ragged array
     * @param row - the row index
     * @return the column index of the highest value in the row
     */
    public static int getHighestInRowIndex(double[][] data, int row) {
        if (data[row].length == 0) {
            return 0;
        }
        
        double highest = data[row][0];
        int highestIndex = 0;
        
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] > highest) {
                highest = data[row][j];
                highestIndex = j;
            }
        }
        
        return highestIndex;
    }
    
    /**
     * Returns the lowest value in a specified row in the ragged array
     * @param data - the ragged array
     * @param row - the row index
     * @return the lowest value in the row
     */
    public static double getLowestInRow(double[][] data, int row) {
        if (data[row].length == 0) {
            return 0;
        }
        
        double lowest = data[row][0];
        
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] < lowest) {
                lowest = data[row][j];
            }
        }
        
        return lowest;
    }
    
    /**
     * Returns the index of the lowest value in a specified row in the ragged array
     * @param data - the ragged array
     * @param row - the row index
     * @return the column index of the lowest value in the row
     */
    public static int getLowestInRowIndex(double[][] data, int row) {
        if (data[row].length == 0) {
            return 0;
        }
        
        double lowest = data[row][0];
        int lowestIndex = 0;
        
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] < lowest) {
                lowest = data[row][j];
                lowestIndex = j;
            }
        }
        
        return lowestIndex;
    }
    
    /**
     * Returns the highest value in a specified column in the ragged array
     * @param data - the ragged array
     * @param col - the column index
     * @return the highest value in the column
     */
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        boolean foundValue = false;
        
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (!foundValue) {
                    highest = data[i][col];
                    foundValue = true;
                } else if (data[i][col] > highest) {
                    highest = data[i][col];
                }
            }
        }
        
        return foundValue ? highest : 0;
    }
    
    /**
     * Returns the index of the highest value in a specified column in the ragged array
     * @param data - the ragged array
     * @param col - the column index
     * @return the row index of the highest value in the column
     */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        int highestIndex = 0;
        boolean foundValue = false;
        
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (!foundValue) {
                    highest = data[i][col];
                    highestIndex = i;
                    foundValue = true;
                } else if (data[i][col] > highest) {
                    highest = data[i][col];
                    highestIndex = i;
                }
            }
        }
        
        return foundValue ? highestIndex : 0;
    }
    
    /**
     * Returns the lowest value in a specified column in the ragged array
     * @param data - the ragged array
     * @param col - the column index
     * @return the lowest value in the column
     */
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        boolean foundValue = false;
        
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (!foundValue) {
                    lowest = data[i][col];
                    foundValue = true;
                } else if (data[i][col] < lowest) {
                    lowest = data[i][col];
                }
            }
        }
        
        return foundValue ? lowest : 0;
    }
    
    /**
     * Returns the index of the lowest value in a specified column in the ragged array
     * @param data - the ragged array
     * @param col - the column index
     * @return the row index of the lowest value in the column
     */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        int lowestIndex = 0;
        boolean foundValue = false;
        
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (!foundValue) {
                    lowest = data[i][col];
                    lowestIndex = i;
                    foundValue = true;
                } else if (data[i][col] < lowest) {
                    lowest = data[i][col];
                    lowestIndex = i;
                }
            }
        }
        
        return foundValue ? lowestIndex : 0;
    }
    
    /**
     * Returns the highest value in the ragged array
     * @param data - the ragged array
     * @return the highest value in the array
     */
    public static double getHighestInArray(double[][] data) {
        if (data.length == 0) {
            return 0;
        }
        
        double highest = Double.NEGATIVE_INFINITY;
        boolean foundValue = false;
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (!foundValue) {
                    highest = data[i][j];
                    foundValue = true;
                } else if (data[i][j] > highest) {
                    highest = data[i][j];
                }
            }
        }
        
        return foundValue ? highest : 0;
    }
    
    /**
     * Returns the lowest value in the ragged array
     * @param data - the ragged array
     * @return the lowest value in the array
     */
    public static double getLowestInArray(double[][] data) {
        if (data.length == 0) {
            return 0;
        }
        
        double lowest = Double.POSITIVE_INFINITY;
        boolean foundValue = false;
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (!foundValue) {
                    lowest = data[i][j];
                    foundValue = true;
                } else if (data[i][j] < lowest) {
                    lowest = data[i][j];
                }
            }
        }
        
        return foundValue ? lowest : 0;
    }
} 