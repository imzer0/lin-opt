
import java.text.DecimalFormat;
import java.util.Arrays;
 
 
public class Simplex {
    public static void main (String [] args){

        double [][] arr = new double [][]{
            {1, 2, 1, 0, 0, 10},
            {1, 1, 0, 1, 0, 8},
            {3, 5, 0, 0, 1, 26},
            {-3, -4, 0, 0, 0, 0}
        };
   
        int outCol = outCol(arr[arr.length-1]);
        int outRow = outRow(arr, outCol);
        printTableau(arr);

        while (outCol != -1 && outRow != -1){
            System.out.println("\nPivot at location: \u001B[35m(" + outRow + ", " + outCol +")\u001B[0m\n");
            pivot(arr, outCol, outRow);
            printTableau(arr);
            System.out.println("\n_____________________________");
            outCol = outCol(arr[arr.length-1]);
            outRow = outRow(arr, outCol);
        }
    }
   
    public static void printTableau (double [][] arr){
        for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (j == arr[0].length-1 || i == arr.length-1){
                         System.out.print("\u001B[35m"+new DecimalFormat("#0.000").format(arr[i][j]) + "\u001B[0m\t");
                    }else{
                         System.out.print(new DecimalFormat("#0.000").format(arr[i][j]) + "\t");
                    }
                   
                }
                System.out.print("\n");
            }
    }

    public static void pivot (double [][] arr, int outCol, int outRow){
        double scale = arr[outRow][outCol];
        for (int i = 0; i<arr[0].length ; i++){
            arr[outRow][i] = arr[outRow][i]/scale;
        }
        for (int i = 0; i < arr.length; i++){
            if (i != outRow){
                scale = arr[i][outCol];
                for (int j = 0; j < arr[0].length ; j++){
                    arr[i][j] = arr[i][j] - scale*arr[outRow][j];
                }
            }
        }
    }
   
    public static int outRow(double [][] arr, int outCol){
        int index = -1;
        double minTheta = Double.MAX_VALUE;
        for (int i = 0; i <arr.length-1; i++){
            double theta = arr[i][arr[0].length-1] / arr[i][outCol];
            if (theta > 0){
                if (theta < minTheta){
                    minTheta = theta;
                    index = i;
                }
            }
        }
        return index;
    }
   
    public static int outCol(double [] arr){
        int index = -1;
        double min = 0;
        for (int i = 0; i<arr.length-1; i++){
            if (arr[i] >= 0 ) { continue;
            } else if ( (index == -1 && arr[i] < 0) || arr[i]<arr[index]){
                index = i;
                min = arr[i];
            }
        }
        return index;
    }
}