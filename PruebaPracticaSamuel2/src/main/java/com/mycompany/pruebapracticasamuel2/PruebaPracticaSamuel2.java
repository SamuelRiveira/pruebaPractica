package com.mycompany.pruebapracticasamuel2;

public class PruebaPracticaSamuel2 {

    public static void main(String[] args) {
        
        for(var i=0; i<5; i++){
            Plaza plaza = new Plaza();
            
            int x = 0;
        
            for(var z=0; z<15; z++){

                Coche coche = new Coche(("LZ" + x), plaza);

                Thread coches[] = new Thread[15];
                coches[x] = new Thread(coche);
                x++;
            }            
        }
        
        // Lanzar los coches
        for (Thread coche : coches) {
            coches.start();
        }
        
        // Esperar a que todos los coches terminen
        for (Thread coche : coches) {
            try {
                coches.join();
            } catch (InterruptedException e) {
            }
        }
    }
}
