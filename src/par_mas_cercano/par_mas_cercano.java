/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package par_mas_cercano;

/**
 *
 * @author julian
 */

import static java.lang.Math.sqrt;
import java.util.Random;
import java.util.Scanner;

public class par_mas_cercano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int X=30;
    int N=12;
    int matriz[][] = new int[N][2];
    distancia1(matriz,N,X);
   distancia2(matriz,N);
    }
    public static void distancia1(int matriz[][], int N, int X){
     int dis[]=new int[3];
    generar(matriz,X,N);
    es(matriz,N,2);
    dis=pc(N,matriz);
    System.out.println("Los pares mas cercanos son "+dis[0]+" y "+dis[1]+" con una distancia de "+dis[2]);
    }
    
    public static void distancia2(int matriz[][], int N){
        ordenar(matriz,N);
    es(matriz,N,2);
    System.out.println("-----");
    if(N%2==0){
        int k1=0;
        int k2=0;
      int matriz1[][]=new int [N/2][2];  
      int matriz2[][]=new int [N/2][2]; 
      int dis1[]=new int[3];
      int dis2[]=new int[3];
      for(int i=0;i<N;i++){       
              if(i<N/2){
                  matriz1[k1][0]=matriz[i][0];
                   matriz1[k1][1]=matriz[i][1];
                   k1++;
              }else{
               matriz2[k2][0]=matriz[i][0];
                matriz2[k2][1]=matriz[i][1]; 
                k2++;
              }
          
      }
      es(matriz1,N/2,2);
      dis1=pc(N/2,matriz1);
      System.out.println(dis1[2]);
      dis2=pc(N/2,matriz2);
      es(matriz2,N/2,2);
       System.out.println(dis2[2]);
      if(dis1[2]<dis2[2]){
     System.out.println("Los pares mas cercanos son "+dis1[0]+" y "+dis1[1]+" con una distancia de "+dis1[2]);
      }else{
        System.out.println("Los pares mas cercanos son "+dis2[0]+" y "+dis2[1]+" con una distancia de "+dis2[2]);  
      }
      }
    }
    
  public static void generar(int mat[][],int X,int N){
  int array[]=new int[N];
 Random r=new Random();
 int count=0;
 int x,y;
  
      for (int j=0;j<N;j++){
          boolean op=true;
         x=r.nextInt(X+1);
          if(count!=0){
          do{
            op=true;
               x=r.nextInt(X+1);
              for(int k=0;k<N;k++){
                 if(array[k]==x){
                     op=false;
                 }
              }
          } while(op==false);
          }
         array[count]=x;
         count++;
         y=r.nextInt(N)+1;
         mat[j][0]=x;
         mat[j][1]=y;
  }
  }
  
  public static void ordenar(int mat[][],int n){
      int tx , ty;
     for(int i=1;i<n;i++){
          for(int j=0;j<n-i;j++){
              if(mat[j][0]>mat[j+1][0]){
                  tx=mat[j][0];
                  ty=mat[j][1];
                  mat[j][0]=mat[j+1][0];
                   mat[j][1]=mat[j+1][1];
                   mat[j+1][0]=tx;
                   mat[j+1][1]=ty;                  
              }
          }
      }
  }
  
  public static void es(int mat[][],int x, int y){
      for (int i=0;i<x;i++){
      for (int j=0;j<y;j++){       
          System.out.print(mat[i][j]+" ");
      }
           System.out.println("");
      }
  }
  public static void escribir(int mat[][],int x,int y,int N){
     int mapa[][] =new int[x][y];
     for(int i=0;i<x;i++){
         for(int j=0;j<y;j++){
            for(int k=0;k<N;k++){
                if(mat[0][k]==i && mat[1][k]==j){
                    mapa[i][j]=k+1;
                }
            }
         }
     }
     
           for (int j=0;j<y;j++){
                for (int i=0;i<x;i++){
          System.out.print(mapa[i][j]+" ");
      }
           System.out.println("");
      }
  }
  public static int distancia(int coords[][], int i, int j) {
    int x1=coords[i][0];
    int y1=coords[i][1];
    
    int x2=coords[j][0];
    int y2=coords[j][1];
    
    int d=(int) sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
    return d;
}
   
public static int[]  pc(int N, int coords[][]){
   int p,s,d;
   int min[]= new int [3];
    double d_min=Double.POSITIVE_INFINITY;
    p=s=0;
    for (int i=0;i<N-1;i++){
        for (int j=i+1;j<N;j++){
           
            d=distancia(coords,i,j);
            if(d<d_min){
               p=i;
               s=j;
                 d_min=d;
            }
        }
    }
    min[0]=p+1;
    min[1]=s+1;
     min[2]=(int) d_min;
    return min;
} 
    
    
}
