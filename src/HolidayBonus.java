/**
 * This class calculates holiday bonuses for stores in a retail district.
 * The bonus amount is determined by the sales performance in each category.
 */
public class HolidayBonus {
    // Constants for bonus amounts
    private static final double HIGHEST_BONUS = 5000.0;
    private static final double LOWEST_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;
    
    /**
     * Calculates the holiday bonus for each store
     * @param data the two dimensional array of store sales
     * @return an array of the bonus for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        
        // Find the number of columns (categories)
        int maxCol = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > maxCol) {
                maxCol = data[i].length;
            }
        }
        
        // Calculate bonus for each category
        for (int col = 0; col < maxCol; col++) {
            // Find highest and lowest sales in this category (only positive sales)
            int highestIndex = -1;
            int lowestIndex = -1;
            double highestSale = 0;
            double lowestSale = Double.MAX_VALUE;
            
            for (int row = 0; row < data.length; row++) {
                // Check if store has this category and if sales is positive
                if (col < data[row].length && data[row][col] > 0) {
                    if (data[row][col] > highestSale) {
                        highestSale = data[row][col];
                        highestIndex = row;
                    }
                    if (data[row][col] < lowestSale) {
                        lowestSale = data[row][col];
                        lowestIndex = row;
                    }
                }
            }
            
            // Assign bonuses for this category
            // If only one store has positive sales in a category, it gets the highest bonus
            if (highestIndex == lowestIndex && highestIndex != -1) {
                bonuses[highestIndex] += HIGHEST_BONUS;
            } else {
                // Assign highest bonus
                if (highestIndex != -1) {
                    bonuses[highestIndex] += HIGHEST_BONUS;
                }
                
                // Assign lowest bonus
                if (lowestIndex != -1 && lowestIndex != highestIndex) {
                    bonuses[lowestIndex] += LOWEST_BONUS;
                }
                
                // Assign other bonuses
                for (int row = 0; row < data.length; row++) {
                    if (row != highestIndex && row != lowestIndex && col < data[row].length && data[row][col] > 0) {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }
        
        return bonuses;
    }
    
    /**
     * Calculates the total holiday bonuses for all stores
     * @param data the two dimensional array of store sales
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double totalBonus = 0;
        
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }
        
        return totalBonus;
    }
} 