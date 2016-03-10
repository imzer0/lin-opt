import java.text.DecimalFormat;
import java.util.Arrays;

public class Dual{
        //Only works with LPP's in standard form for now
        public static void main (String [] args){
                double [] c = new double []{3, 8, 7};
                double [][] A = new double [][]{
                        {6, 4, 5},
                        {2, 3, 4},
                        {3, 7, 9}
                };
                double [] b = new double []{7, 12, 13};

                LPP primal = new LPP(c, A, b, false);

                PrintLPP(primal);

                LPP dual = new LPP(b, Transpose(A), c, true);

                PrintLPP(dual);
        }

        public static double [][] Transpose (double [][] A){
                double [][] transpose = new double [A[0].length][A.length];

                for (int i = 0; i < A.length; i++){
                        for (int j = 0; j < A[0].length; j++){
                                transpose[j][i] = A[i][j];
                        }
                }

                return transpose;
        }

        public static void PrintLPP(LPP lpp){
                String z, var, sign;
                int i, j;

                if (lpp.dual){
                        System.out.println("\nDual:");
                        z = "min z_bar = ";
                        var = "w";
                        sign = " >= ";
                }else{
                        System.out.println("\nPrimal:");
                        z = "max z = ";
                        var = "x";
                        sign = " <= ";
                }

                System.out.print(z);
                for (i = 0; i < lpp.c.length-1; i++){
                        System.out.print(lpp.c[i] + var + i + " + "); 
                }
                System.out.println(lpp.c[i] + var + "\nSubject to");
                for (i = 0; i < lpp.A.length; i++){
                        for (j = 0; j < lpp.A[i].length-1; j++){
                                System.out.print(lpp.A[i][j] + var + j +  " + ");
                        }
                        System.out.println(lpp.A[i][j] + var + j + sign + lpp.b[i]);
                }
                for (i = 0; i < lpp.A[0].length-1; i++){
                        System.out.print(var + i + ", ");
                }
                System.out.println(var + i + " >= 0");
        }
}
