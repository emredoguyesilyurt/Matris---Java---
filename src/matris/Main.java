/*

example main 

 */
package matris;

import matris.Matris;
import matris.SeyrekMatris;

public class Main {

    public static void main(String[] args) {

        int[][] arr = new int[3][4];
        for(int i=0;i<3;i++)
            for(int j=0;j<4;j++)
                arr[i][j] = j+1;
        /*
        arr[3][3] = 0;
        arr[3][2] = 0;
        arr[3][1] = 0;
        arr[2][3] = 0;
        arr[2][2] = 0;
        arr[1][3] = 1;
        */
        Matris mat1; 
        mat1 = new Matris(arr);
        mat1.print();
        
        Matris mat2;
        mat2 = new Matris(3,4,1);
        mat2.print();
        
        
        mat1.olcekle(3);
        
        /*
        
        System.out.println(mat1.ustUcgen());
        System.out.println();
        */

        
    }
    
}
