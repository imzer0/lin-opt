public class LPP{
        double [] c, b;
        double [][] A;
        boolean dual;

        public LPP (double [] c, double [][] A, double [] b, boolean dual){
                this.c = c;
                this.b = b;
                this.A = A;
                this.dual = dual;
        }
}
