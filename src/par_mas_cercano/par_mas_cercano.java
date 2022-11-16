/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package par_mas_cercano;

//Copyright (c) 2022 Julian Almario Vergara
 //* This file is released under the GNU General Public License as published
 //* by the Free Software Foundation, either version 3 of the License, or
 //* (at your option) any later version.


import java.util.Random;
import java.util.Scanner;

public class par_mas_cercano {

    /**
     * @param args the command line arguments
     */
    public static double d_min[]=new double[3];
    public static int c;
    public static void main(String[] args) {  
    
    int N=7;
     int X=30;
    c=0;
    d_min[2]=Double.POSITIVE_INFINITY;
    double dis[]=new double[3];  
    double dis2[]=new double[3];  
    dis2[2]=Double.POSITIVE_INFINITY;
    dis[2]=Double.POSITIVE_INFINITY;
    int coords[][] = new int[N][3]; 
     generar(coords,X,N);
      coords=ordenar(coords,N);
       FB(coords,N,dis2);
      es(coords,N,3);
      dis=d(coords,N,dis);
      System.out.println("Los pares mas cercanos son "+((int)dis[0])+" y "+((int)dis[1])+" con una distancia de "+dis[2]);
    
   
  
    }
    
    public static double []d(int coords[][], int N,double dis[]){
        if(coords.length<=3){
           dis=pc(N,coords,dis);        
        }else{
         dis=mitad(coords,N,dis);
         dis=md(coords,N,dis[2],dis);
        }
         if(dis[2]<d_min[2]){
              d_min[2]=dis[2];
              d_min[0]=dis[0];
              d_min[1]=dis[1];
          }
        return d_min;
    }
    
      public static void FB(int matriz[][], int N, double dis[]){
     dis=pc(N,matriz,dis);
    System.out.println("Los pares mas cercanos son "+dis[0]+" y "+dis[1]+" con una distancia de "+dis[2]);
    }
    
    public static double [] mitad(int matriz[][], int N,double dis[]){
        int k1=0;
        int k2=0;
        
        if(N%2==0){
        //Particion de una matriz si su tamaño es un numero par
      int matriz1[][]=new int [N/2][3];  
      int matriz2[][]=new int [N/2][3]; 
      double dis1[]=new double[3];
      double dis2[]=new double[3];
      //Ciclo para partir la matriz en dos partes
      for(int i=0;i<N;i++){       
              if(i<N/2){
                  matriz1[k1][0]=matriz[i][0];
                   matriz1[k1][1]=matriz[i][1];
                   matriz1[k1][2]=matriz[i][2];
                   k1++;
              }else{
               matriz2[k2][0]=matriz[i][0];
                matriz2[k2][1]=matriz[i][1]; 
                matriz2[k2][2]=matriz[i][2];
                k2++;
              }
      }
       dis1=d(matriz1,N/2,dis);
      dis2=d(matriz2,N/2,dis);
       //Se compara las dos distancias minimas de las dos particiones
      if(dis1[2]<dis2[2]){
         return dis1; 
      }else{
         return dis2; 
      }
        }else{
      //Particion de la matriz si su tamaño es un numero impar
      int matriz1[][]=new int [N/2+1][3];  
      int matriz2[][]=new int [N-(N/2+1)][3]; 
      double dis1[]=new double[3];
      double dis2[]=new double[3];
      for(int i=0;i<N;i++){       
              if(i<(N/2+1)){
                  matriz1[k1][0]=matriz[i][0];
                   matriz1[k1][1]=matriz[i][1];
                   matriz1[k1][2]=matriz[i][2];
                   k1++;
              }else{
               matriz2[k2][0]=matriz[i][0];
                matriz2[k2][1]=matriz[i][1]; 
                matriz2[k2][2]=matriz[i][2];
                k2++;
              }
      }
     dis1=d(matriz1,N/2+1,dis);
      dis2=d(matriz2,N-(N/2+1),dis);
      //Se compara las dos distancias minimas de las dos particiones
      if(dis1[2]<dis2[2]){
         return dis1; 
      }else{
         return dis2;
      }
      }   
    }
    
  public static void generar(int mat[][],int X,int N){
  int array[]=new int[N];
 Random r=new Random();
 int count=0;
 int x,y;
  //Se genera la matriz
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
         y=r.nextInt(N+3)+1;
         //Se asigna la posicion de x
         mat[j][0]=x;
         //Se asigna la posicion de y
         mat[j][1]=y;
         //Se asigna el valor del entero
         mat[j][2]=j+1;
  }
  }
  
  public static int[][] ordenar(int mat[][],int n){
      int tx , ty, tz;
     //Ordenamiento de menor a mayor de la matriz con respecto al eje x
     //usando el metodo bubblesort
      for(int i=1;i<n;i++){
          for(int j=0;j<n-i;j++){
              if(mat[j][0]>mat[j+1][0]){
                  tx=mat[j][0];
                  ty=mat[j][1];
                  tz=mat[j][2];
                  mat[j][0]=mat[j+1][0];
                   mat[j][1]=mat[j+1][1];
                   mat[j][2]=mat[j+1][2];
                   mat[j+1][0]=tx;
                   mat[j+1][1]=ty;
                   mat[j+1][2]=tz;
              }
          }
      }
     return mat;
  }
  
  public static void es(int mat[][],int x, int y){
      //Se muestra la matriz 
      for (int i=0;i<x;i++){
      for (int j=0;j<y;j++){       
          System.out.print(mat[i][j]+" ");
      }
           System.out.println("");
      }
  }
  
  public static double distancia(int coords[][], int i, int j) {
    int x1=coords[i][0];
    int y1=coords[i][1];
    
    int x2=coords[j][0];
    int y2=coords[j][1];
    
    double d=(double) (((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
    return d;
}
   
public static double [] pc(int N, int coords[][],double dis[]){
   int p,s;
   double d;
   int min[]= new int [3];
    for (int i=0;i<N-1;i++){
        for (int j=i+1;j<N;j++){
           //Se haya la distancia entre dos puntos
            d=(double)distancia(coords,i,j);
            c++;
            if(d<dis[2]){          
               dis[0]=(double)coords[i][2];
               dis[1]=(double)coords[j][2];
               dis[2]=d;
            }
        }
    }
return dis;
} 
    

public static double [] md(int coords[][],int N,double d_min,double dis[]){
   int matriz[][]= new int [N+1][3];
   int count=0;
   
   if(N%2!=0){  
           double d=distancia(coords,N/2,N/2+1);
          //Si la distancia entre los dos valores mas cerca de la mitad
          //es menor a la distancia menor actual entonces se añaden a una matriz
           if(d<d_min){
              matriz[count][0]=coords[N/2][0]; 
              matriz[count][1]=coords[N/2][1]; 
              matriz[count][2]=coords[N/2][2];
              count++;
              matriz[count][0]=coords[N/2+1][0]; 
              matriz[count][1]=coords[N/2+1][1]; 
              matriz[count][2]=coords[N/2+1][2];
              count++;
           }
          
           int md=N/2+2;
           int mi=N/2-1;
           int t=0;
           if(N<10){
                t=2;
           }else{
               t=3;
           }
           //Se genera una matriz con los valores del medio si 
           // si las distancia entre esos valores en menor a la 
           // distancia menor actual
           for (int j=0;j<t;j++){
                d=distancia(coords,N/2,md+j);
                 if(d<d_min){
              matriz[count][0]=coords[md+j][0]; 
              matriz[count][1]=coords[md+j][1]; 
              matriz[count][2]=coords[md+j][2];
              count++;
                 }
                d=distancia(coords,N/2+1,mi-j);
                if(d<d_min){
              matriz[count][0]=coords[mi-j][0]; 
              matriz[count][1]=coords[mi-j][1]; 
              matriz[count][2]=coords[mi-j][2];
              count++;
           }
                 }
        }else{     
            double d=distancia(coords,N/2-1,N/2);
            //Si la distancia entre los dos valores mas cerca de la mitad
          //es menor a la distancia menor actual entonces se añaden a una matriz
           if(d<d_min){
              matriz[count][0]=coords[N/2-1][0]; 
              matriz[count][1]=coords[N/2-1][1]; 
              matriz[count][2]=coords[N/2-1][2];
              count++;
              matriz[count][0]=coords[N/2][0]; 
              matriz[count][1]=coords[N/2][1]; 
              matriz[count][2]=coords[N/2][2];
              count++;
           }        
           int md=N/2;
           int mi=N/2-1;
           int t=0;
           if(N<10){
                t=2;
           }else{
               t=3;
           }
           //Se genera una matriz con los valores del medio si 
           // si las distancia entre esos valores en menor a la 
           // distancia menor actual
           for (int j=0;j<t;j++){
                d=distancia(coords,N/2-1,md+j);
                 if(d<d_min){
              matriz[count][0]=coords[md+j][0]; 
              matriz[count][1]=coords[md+j][1]; 
              matriz[count][2]=coords[md+j][2];
              count++;
                 }
                d=distancia(coords,N/2,mi-j);
                if(d<d_min){
              matriz[count][0]=coords[mi-j][0]; 
              matriz[count][1]=coords[mi-j][1]; 
              matriz[count][2]=coords[mi-j][2];
              count++;
           }
                 }  
   }
   
        if(matriz[0][0]!=0){
            dis=pc(N,coords,dis);
        }
                                            
    return dis;
    
} 
}
