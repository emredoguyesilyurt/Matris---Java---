/*

a matrix class that has addition, subtraction, scalar multiplication, matrix multiplication and transpose functions 

 */
package matris;

import java.util.Scanner;

public class Matris {
    
        private int[][] matris;
        private int satir = 0;
        private int sutun = 0;
        
        public Matris(){
            
        }
        
        //constructor 1
        // create a Matris object from a two dimensional array
        public Matris(int[][] mat) {
            
            // matris'in satır ve sütun uzunluklarını hesapla, sayılar verilen mat'ınkilerle ile aynı olacak
            // calculate the row and column lengths of the matris, these numbers should be equal to mat's row and column lengths
            this.satir = mat.length;
            this.sutun = mat[0].length;

            // matris'i satır ve sütun sayılarıyla oluştur
            // create the matris with the given row and column lengths
            this.matris = new int[satir][sutun];
            
            
            // matris'in bütün elemanlarını mat'a eşitle
            // set all elements of the matris equal to the mat's
            for(int i=0; i<satir; i++){
                for(int j=0; j<sutun; j++)
                    this.matris[i][j] = mat[i][j];
            }
            
            //this.print();
            
        }
        
        //constructor 2
        // construct Matris object with given row and column lengths, and set all of its elements to "deger" integer
        public Matris(int satirSayisi, int sutunSayisi, int deger){
            
            // sütun ve satır sayılarını al
            // get the row and column lengths
            this.satir = satirSayisi;
            this.sutun = sutunSayisi;
            
            // matris array'ini oluştur
            // create the matris array
            this.matris = new int[satir][sutun];
            
            // bütün elemanları deger'e eşitle
            // set all elements equal to "deger" integer
            for(int i=0; i<satirSayisi; i++){
                for(int j=0; j<sutunSayisi; j++)
                    this.matris[i][j] = deger;
            }
            
            //this.print();
        }
        
        // print the row and column lengths, and the matrix itself
        public void print(){
            System.out.println();
            System.out.println("satır: " + satir);
            System.out.println("sutun: " + sutun);
            
            for(int i=0; i<satir; i++){
                for(int j=0; j<sutun; j++)
                    System.out.print(this.matris[i][j] + " ");
                System.out.println();
            }
            
        }
        
        // add two matrices together
        public Matris ekle(Matris sag){
            
            // satır ve sütun sayılarını iki matris için de hesapla
            // calculate the row and column lengths for both matrices
            int sutun1, satir1, sutun2, satir2;

            satir1 = this.matris.length;
            sutun1 = this.matris[0].length;
            satir2 = sag.matris.length;
            sutun2 = sag.matris[0].length;
            
            // toplama işleminin sonucunu tutacağın arrayi oluştur
            // create the array that will store the sum
            int[][] resultArray = new int[satir1][sutun1];

            // satır ve sütun sayıları eşitse işlemi yap
            // if the row and column lengths are equal, do the addition
            if(satir1 == satir2 && sutun1 == sutun2){
                
                // iki matrisin bütün elemanlarını tek tek topla, ve resultArray'e at
                // add the elements of the two matrices one by one, and put them into the resultArray
                for(int i=0; i<satir1; i++)
                    for(int j=0; j<sutun1; j++)
                        resultArray[i][j] = this.matris[i][j] + sag.matris[i][j];
                
                // yeni bir result matris'i oluştur, oluşturmak için resultArray'i kullan
                // create a new result matrix, use resultArray to create this object
                Matris result = new Matris(resultArray);
                
                // sonucu dön
                // return the result
                return result;
            }
            // sayılar eşit değilse programdan çık
            // if the row and column lengths are not equal, exit the program
            else{
                System.out.println("Satır ve sütun sayıları eşit değil.");
                System.exit(0);
            }

            
            // bu kısma zaten gelinmeyeceği için rastgele bir return statement koy
            // put a random return statement, since we will never reach this line
            return sag;
        }
        
        // change a given element of the matrix to a new value (yeniDeger)
        public void degis(int sat, int sut, int yeniDeger){
            
            this.matris[sat-1][sut-1] = yeniDeger;
            
            this.print();
            
        }
        
        // check if a matrix object is equal to the given one (sag matrix)
        public boolean equals(Matris sag){
            
            if(this.satir != sag.satir || this.sutun != sag.sutun)
                return false;
            else {
                
                for(int i=0; i<this.satir; i++){
                    for(int j=0; j<this.sutun; j++){
                        if(this.matris[i][j] != sag.matris[i][j])
                            return false;
                    }
                }
            }
            
            return true;
        }
        
        
        // take the transpose of the matrix object
        public Matris transpoz(){
            
            // transpoz'un satırları asıl matrisin sütunlarına, sütunları da asıl matrisin satırlarına eşit olacak
            // transpose's rows will be equal to the matrix' columns, and its columns will be equal to the matrix' rows
            int sat = this.sutun;
            int sut = this.satir;
            
            // transpoz matrisini oluşturmak için kullanacağın array'i oluştur
            // initialize the array that will be used to create the transpose matrix
            int[][] array = new int[sat][sut];
            
            // array'in her satırını this.matris'in her sütununa eşitle 
            // set each of the array's rows equal to the each of the rows of this.matris
            for(int i=0; i<sutun; i++)
                for(int j=0; j<satir; j++)
                    array[i][j] = this.matris[j][i];
            
            // array'i kullanarak transpoz adında yeni bir matris oluştur
            // create a new matrix named "transpoz" using the array
            Matris transpoz = new Matris(array);

            return transpoz;
            
        }
        
        
        // get the value at the given row and column
        public int getDeg(int sat, int sut){
            
            return this.matris[sat][sut];
            
        }
        
        
        // check if the matrix is an upper triangular or not
        public boolean ustUcgen(){
            
            // köşegenin altındaki bütün elemanların sıfır olup olmadığına bak
            // check all elements under the diagonal
            
            // 2. satırdan başla, 2. satırda sadece son elemana bak
            // start from the second row, and only check the last element at this row
            
            // son satırda da ilk eleman hariç bütün elemanlara bak
            // on the last row, check all elements except the first one
            
            /* 
            üst üçgen matris örneği:
            -- example of an upper triangular matrix
            1 1 1 1 1 1
            2 2 2 2 2 0
            3 3 3 3 0 0
            4 4 4 0 0 0
            5 5 0 0 0 0
            6 0 0 0 0 0
            */
            for(int i=1; i<this.satir; i++){
                for(int j=this.sutun-1; j>this.sutun - i -1; j--){
                    if(this.matris[i][j] != 0)
                        return false;
                }
            }
            
            return true;
        }
        
        
        // multiply two matrices
        public Matris carp(Matris sag){
            
            // matrislerin satır ve sütunlarını al
            // get the row and column lengths of both matrices
            int sat1, sut1, sat2, sut2, sat3, sut3;
            sat1 = this.satir;
            sut1 = this.sutun;
            sat2 = sag.satir;
            sut2 = sag.sutun;
            
            sat3 = sat1;
            sut3 = sut2;
            Matris result = new Matris(sat1, sut2, 0);
            
            // eğer matrisin satır sayısı sag matrisinin sütun sayısına eşit değilse
            // if the matrix' row length is NOT equal to the other one's column length
            if(sut1 != sat2){
                System.out.println("Satır ve sütun sayıları eşit değil.");
                System.exit(0);
            }
            // eşitse çarpma işlemini gerçekleştir
            // if they are equal, do the multiplication
            else{
                
                // matrisin bütün satırları için
                // for all rows of the matrix
                for(int i=0; i<sat1; i++){
   
                    // sag'ın bütün sütunları için
                    // for all columns of the sag matrix (the other one)
                    for(int j=0; j<sut3; j++){
                        
                        int sum = 0;
                        
                        // matrisin sütunundaki bütün elemanları, sag'ın satırındaki bütün elemanlarla çarp
                        // multiply all elements at the matris' row, with all elements at the sag matris' column
                        for(int k=0; k<sut1; k++){
                            
                            // her çarpımı topla
                            // add these multiplication results together
                            sum += (this.matris[i][k] * sag.matris[k][j]);
                            
                        }

                        // toplamı result'a at
                        // put this sum into the result
                        result.matris[i][j] = sum;
                        
                    }
                    
                    
                }
                
            }
            
            result.print();
            return result;
            
        }
        
        // get the column length
        public int sutunSayisi(){
            
            int sutun = this.matris[0].length;
            
            return sutun;
        }
        
        // get the row length
        public int satirSayisi(){
            
            int satir = this.matris.length;
            
            return satir;
        }
        
        // scalar multiplication
        public void olcekle(int f){
            
            for(int i=0; i<this.satir; i++){
                for(int j=0; j<this.sutun; j++){
                    this.matris[i][j] = f * this.matris[i][j];
                }
            }
            
            this.print();
        }
        
        // subtraction
        public Matris cikart(Matris sag){
            
            // matrislerin satır ve sütunlarını al
            // get the row and column lengths of bot matrices
            int sat1, sut1, sat2, sut2, sat3, sut3;
            sat1 = this.satir;
            sut1 = this.sutun;
            sat2 = sag.satir;
            sut2 = sag.sutun;
            
            // result matrisini oluştur
            // create the result matrix
            Matris result = new Matris(sat1, sut1, 0);
            
            // satır ya da sütun sayıları eşit değilse programı bitir
            // if the row or column lengths are not equal, stop the program
            if(sat1 != sat2 || sut1 != sut2){
                System.out.println("Satır ve sütun sayıları eşit değil.");
                System.exit(0);
            }
            else {
                
                // bütün elemanları tek tek çıkar
                // subtract each element one by one
                for(int i=0; i<sat1; i++){
                    for(int j=0; j<sut1; j++){
                        result.matris[i][j] = this.matris[i][j] - sag.matris[i][j];
                    }
                }
            }
            
            result.print();
            return result;
            
        }
        
        // print the matrix
        public void goster(Matris m){
            
            for(int i=0; i<m.satir; i++){
                for(int j=0; j<m.sutun; j++){
                    System.out.print(m.matris[i][j] + " ");
                }
                System.out.println();
            }
            
        }
}
